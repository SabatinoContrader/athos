import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { Game } from 'src/models/Game';
import { GameService } from 'src/services/game.service';
import { User } from 'src/models/User';

@Component({
  selector: 'app-game',
  templateUrl: './game.component.html',
  styleUrls: ['./game.component.css']
})
export class GameComponent implements OnInit {

  public games: Array<Game>
  public userDTO:User
  
  constructor(private router: Router, private gameService: GameService) { }

  ngOnInit() {
    this.gameService.findAll().subscribe((response) =>{
      this.games=response;
      console.log(this.games);
    } );
  }

  logout(){
    sessionStorage.clear();
    this.router.navigateByUrl("/login");
  }

}
