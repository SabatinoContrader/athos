import { Component, OnInit } from '@angular/core';
import { RelUserGameTeam } from 'src/models/RelUserGameTeam';
import { RelUserGameTeamService } from 'src/services/relUserGameTeam.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-play-start',
  templateUrl: './play-start.component.html',
  styleUrls: ['./play-start.component.less']
})
export class PlayStartComponent implements OnInit {

  public partite : Array<RelUserGameTeam>;

  constructor(private router : Router, private relUserGameTeamService : RelUserGameTeamService) { }

  ngOnInit() 
  {
    this.relUserGameTeamService.findAll().subscribe(response => {this.partite = response});
  }
}
