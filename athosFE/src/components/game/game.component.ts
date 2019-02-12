import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { Game } from 'src/models/Game';
import { GameService } from 'src/services/game.service';

@Component({
  selector: 'app-game',
  templateUrl: './game.component.html',
  styleUrls: ['./game.component.css']
})
export class GameComponent implements OnInit {

  public games: Array<Game>
  
  constructor(private router: Router, private gameService: GameService) { }

  ngOnInit() {
    this.gameService.findAll().subscribe((response) =>{
      this.games=response;
    } );
  }

  logout(){
    sessionStorage.clear();
    this.router.navigateByUrl("/login");
  }

}
