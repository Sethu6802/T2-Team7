import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomePageComponent } from './home-page/home-page.component';
import { ErrorComponent } from './error/error.component';
import { HospComponent } from './hosp/hosp.component';
import { LoginComponent } from './login/login.component';
import { ResqComponent } from './resq/resq.component';
import { logoutComponent } from './logout/logout.component';
import { SosComponent } from './sos/sos.component';
import { VolComponent } from './vol/vol.component';
import { registerComponent } from './register/register.component';
import { ReportComponent } from './report/report.component';
import { HelperFormComponent } from './helper-form/helper-form.component';
import { ServiceProviderFormComponent } from './service-provider-form/service-provider-form.component';
import { VictimStatusFormModalComponent } from './victim-status-form-modal/victim-status-form-modal.component';
import { PatientStatusFormModalComponent } from './patient-status-form-modal/patient-status-form-modal.component';

const routes: Routes = [

  { path: "", component: SosComponent},
  { path: "register", component: registerComponent},
  { path: "hosp", component: HospComponent},
  { path: "login", component: LoginComponent},
  { path: "resq", component: ResqComponent},
  { path: "logout", component: logoutComponent},
  { path: "sos", component: SosComponent},
  { path: "homePage", component: HomePageComponent},
  { path: "vol", component: VolComponent},
  { path: "report", component: ReportComponent},
  { path: "helper-form", component: HelperFormComponent},
  { path: "register-service-provider", component: ServiceProviderFormComponent},
  { path:"victim-status",component:VictimStatusFormModalComponent },
  { path: "patient-status-form-model", component: PatientStatusFormModalComponent},
  { path: "**", component: ErrorComponent}  

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
