import { Component, OnInit } from '@angular/core';
import { Game } from 'src/models/Game';
import { GameService } from 'src/services/game.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-play',
  templateUrl: './play.component.html',
  styleUrls: ['./play.component.less']
})
export class PlayComponent implements OnInit {

  public giochi: Array<Game>

  constructor(private router : Router,  private gameService: GameService) { }

  ngOnInit() {
    this.gameService.tuttigiochi().subscribe((response) =>{this.giochi=response;});
  //this.gameService.tuttigiochi().subscribe(response => {this.giochi = response;});
}
}
