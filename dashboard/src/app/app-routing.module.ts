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
  { path: "**", component: ErrorComponent}  

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
