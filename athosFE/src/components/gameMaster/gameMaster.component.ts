import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-gameMaster',
  templateUrl: './gameMaster.component.html',
  styleUrls: ['./gameMaster.component.css']
})
export class GameMasterComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
  }

  logout(){
    sessionStorage.clear();
    this.router.navigateByUrl("/login");
  }

}
