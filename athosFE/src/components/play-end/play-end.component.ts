import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RelUserGameTeam } from 'src/models/RelUserGameTeam';
import { RelUserGameTeamService } from 'src/services/relUserGameTeam.service';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-play-end',
  templateUrl: './play-end.component.html',
  styleUrls: ['./play-end.component.less']
})
export class PlayEndComponent implements OnInit {

 public partite : Array<RelUserGameTeam>;

  constructor(private router : Router, private relUserGameTeamService : RelUserGameTeamService, private datePipe: DatePipe) { }

  ngOnInit() 
  {   
     this.relUserGameTeamService.findAll().subscribe(response => {this.partite = response
    this.partite.forEach(element => {
      element.data_inizio= this.datePipe.transform(element.data_inizio, 'dd/MM/yyyy');
      element.data_fine= this.datePipe.transform(element.data_fine, 'dd/MM/yyyy');
    });
  });
}
}

