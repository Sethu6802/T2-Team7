
package com.example.cloudGateWay.filters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {

	public AuthenticationFilter() {
		super(Config.class);
	}

	@Autowired
	private RouteValidator validator;

	public static class Config {

	}

	@Override
	public GatewayFilter apply(Config config) {
		return ((exchange, chain) -> {
			
			if (validator.isSecured.test(exchange.getRequest())) {
				
				System.out.println("validator"+validator.isSecured.test(exchange.getRequest()));
				
				if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
					throw new RuntimeException("Missing Authorization Header");
				}
			String authHeaderToken = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
			System.out.println("Header"+authHeaderToken);
				if (authHeaderToken != null && authHeaderToken.startsWith("Bearer")) {
					
					authHeaderToken = authHeaderToken.substring(7);
				}
				try {
					
					RestClient restClient = RestClient.create();
					Boolean validBoolean = restClient.get()
							.uri("http://localhost:8090/user/validate?token=" + authHeaderToken)
							.retrieve().body(Boolean.class);

					if (!validBoolean) {

						exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
						return exchange.getResponse().setComplete(); // Terminate the request

					}
				
				} catch (Exception e) {
					
					exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
					return exchange.getResponse().setComplete();
				}
			}
		
			return chain.filter(exchange);
		});
	}



}