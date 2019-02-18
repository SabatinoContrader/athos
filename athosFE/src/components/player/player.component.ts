import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-player',
  templateUrl: './player.component.html',
  styleUrls: ['./player.component.less']
})
export class PlayerComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
  }

  
  logout(){
    sessionStorage.clear();
    this.router.navigateByUrl("/login");
  }

}
