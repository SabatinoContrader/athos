import { Component, OnInit } from '@angular/core';
import { RelUserGameTeam } from 'src/models/RelUserGameTeam';
import { RelUserGameTeamService } from 'src/services/relUserGameTeam.service';
import { Router } from '@angular/router';
import { User } from 'src/models/User';

@Component({
  selector: 'app-play-start',
  templateUrl: './play-start.component.html',
  styleUrls: ['./play-start.component.less']
})
export class PlayStartComponent implements OnInit {

  public partite : Array<RelUserGameTeam>;
  public userDTO:User

  constructor(private router : Router, private relUserGameTeamService : RelUserGameTeamService) { }

  ngOnInit() 
  {
    this.relUserGameTeamService.allGamexId().subscribe(response => {this.partite = response});
  }

  delete(id: number){
    this.relUserGameTeamService.delete(id).subscribe(async(response)=> {
      await this.ngOnInit();
    })
  }
}
