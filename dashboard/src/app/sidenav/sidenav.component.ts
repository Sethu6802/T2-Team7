import { Component } from '@angular/core';
import { navbarData } from './navData';
import { animate, style, transition, trigger } from '@angular/animations';

@Component({
  selector: 'app-sidenav',
  templateUrl: './sidenav.component.html',
  styleUrls: ['./sidenav.component.css'],
  animations: [
    trigger('fadeInOut',[
      transition(':enter',[
        style({opacity: 0}),
        animate('700ms',
          style({opacity: 1})
        )
      ]),
      transition(':leave',[
        style({opacity: 1}),
        animate('700ms',
          style({opacity: 0})
        )
      ])
    ])
  ]
})

export class SidenavComponent {

  collapsed = false;
  navData = navbarData;

  toggleCollapse(){
    this.collapsed = !this.collapsed;
  }

  closeSideBar(){
    this.collapsed = false;
  }

}