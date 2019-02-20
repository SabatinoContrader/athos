import { Component, OnInit } from '@angular/core';
import { User } from 'src/models/User';
import { UserService } from 'src/services/user.service';
import { Router } from '@angular/router';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-super-list',
  templateUrl: './super-list.component.html',
  styleUrls: ['./super-list.component.less']
})
export class SuperListComponent implements OnInit {

  public gamemaster : Array<User>;

  constructor(private router : Router, private userService : UserService, private datePipe: DatePipe) { }

  ngOnInit() { 
    this.userService.allGamer().subscribe(response => {this.gamemaster = response
    this.gamemaster.forEach(element => {
    element.data_iscrizione= this.datePipe.transform(element.data_iscrizione, 'dd/MM/yyyy');  
    });
  });
}
}

