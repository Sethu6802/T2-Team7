import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from  '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';


import { HomePageComponent } from './home-page/home-page.component';
import { logoutComponent } from './logout/logout.component';
import { SidenavComponent } from './sidenav/sidenav.component';
import { ResqComponent } from './resq/resq.component';
import { HospComponent } from './hosp/hosp.component';
import { VolComponent } from './vol/vol.component';
import { ErrorComponent } from './error/error.component';
import { registerComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { SosComponent } from './sos/sos.component';

@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    logoutComponent,
    SidenavComponent,
    ResqComponent,
    HospComponent,
    VolComponent,
    ErrorComponent,
    registerComponent,
    LoginComponent,
    SosComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})

export class AppModule { }
