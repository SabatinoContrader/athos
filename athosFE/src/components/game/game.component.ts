import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { Game } from 'src/models/Game';
import { GameService } from 'src/services/game.service';
import { User } from 'src/models/User';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-game',
  templateUrl: './game.component.html',
  styleUrls: ['./game.component.css']
})
export class GameComponent implements OnInit {

  public games: Array<Game>
  public userDTO:User
  
  constructor(private router: Router, private gameService: GameService, private datePipe: DatePipe) { }

  ngOnInit() {
    this.gameService.findAll().subscribe((response) =>{ this.games=response
            this.games.forEach(element => { 
              element.data_inizio = this.datePipe.transform(element.data_inizio, 'dd/MM/yyyy');
              element.data_fine = this.datePipe.transform(element.data_fine, 'dd/MM/yyyy');
            });
    } );
  }

  delete(idgame: String){
    this.gameService.delete(idgame).subscribe(async(response)=> {
      await this.ngOnInit();
    })

  }

  logout(){
    sessionStorage.clear();
    this.router.navigateByUrl("/login");
  }

}
