import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { UserService } from "src/services/user.service";
import { User } from 'src/models/User';

@Component({
  selector: 'app-super-user',
  templateUrl: './super-user.component.html',
  styleUrls: ['./super-user.component.less']
})
export class SuperUserComponent implements OnInit {
username:string;
password:string;
  user:User;
  constructor(private router: Router, private userService: UserService) { }

  ngOnInit() {
  }

  save(f: NgForm): void{
    this.userService.save(f.value.username, f.value.password).subscribe(response => {
      this.router.navigateByUrl("/viewSuper");
    });
  }
}