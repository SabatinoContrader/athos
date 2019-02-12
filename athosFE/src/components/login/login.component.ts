import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';

import { UserService } from "src/services/user.service";
import { User } from 'src/models/User';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class loginComponent implements OnInit {

  user:User;
  title = 'GIOCO PAZZESCO O.o';
  constructor(private router: Router, private userService: UserService) { }

  ngOnInit() {
  }

  login(f: NgForm): void{
    console.log("mi arrivano username="+ f.value.username + " password= "+ f.value.password);
    this.userService.login(f.value.username, f.value.password).subscribe((response) => {

      if (response != null) {
          this.user=response;
          sessionStorage.setItem("user", JSON.stringify(this.user));

          if(response.role==0)
           this.router.navigateByUrl("/superUser");
          else if(response.role==1)
           this.router.navigateByUrl("/gameMaster");
          else if(response.role==2)
           this.router.navigateByUrl("/player");
          else 
           this.router.navigateByUrl("/login");

      }

  });
  }

  logout(){
    sessionStorage.clear();
    this.router.navigateByUrl("/login");
  }

    

}