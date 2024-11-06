import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from  '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomePageComponent } from './home-page/home-page.component';
import { RescueTeamComponent } from './rescue-team/rescue-team.component';
import { HospitalComponent } from './hospital/hospital.component';
import { VolunteerComponent } from './volunteer/volunteer.component';
import { SettingComponent } from './setting/setting.component';
import { SidenavComponent } from './sidenav/sidenav.component';
import { MatIconModule } from  '@angular/material/icon';

@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    RescueTeamComponent,
    HospitalComponent,
    VolunteerComponent,
    SettingComponent,
    SidenavComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatIconModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
