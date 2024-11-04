import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { ErrorComponent } from './error/error.component';
import { FormComponent } from './form/form.component';

const routes: Routes = [

  { path: "", component: FormComponent},
  { path: "login", component:  LoginComponent },
  { path: "form", component: FormComponent},
  { path: "**", component: ErrorComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }