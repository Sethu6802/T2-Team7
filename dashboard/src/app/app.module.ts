import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from  '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';


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
import { AuthInterceptor } from './auth.interceptor';
import { ReportComponent } from './report/report.component';
import { ServiceProviderFormComponent } from './service-provider-form/service-provider-form.component';
import { HelperFormComponent } from './helper-form/helper-form.component';
import { VictimStatusFormModalComponent } from './victim-status-form-modal/victim-status-form-modal.component';
import { RouterModule } from '@angular/router';
import { PatientStatusFormModalComponent } from './patient-status-form-modal/patient-status-form-modal.component';

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
    SosComponent,
    ReportComponent,
    ServiceProviderFormComponent,
    VictimStatusFormModalComponent,
    HelperFormComponent,
    PatientStatusFormModalComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule,
    HttpClientModule
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true }
  ],
  bootstrap: [AppComponent]
})

export class AppModule { }
