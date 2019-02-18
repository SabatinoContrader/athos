import { HttpClientModule } from "@angular/common/http";
import { NgModule } from '@angular/core';
import { FormsModule } from "@angular/forms";
import { HttpModule } from '@angular/http';
import { BrowserModule } from '@angular/platform-browser';
import { loginComponent } from 'src/components/login/login.component';
import { PlayerComponent } from 'src/components/player/player.component';
import { GameComponent } from '../components/game/game.component';
import { GameMasterComponent } from '../components/gameMaster/gameMaster.component';
import { GameService } from '../services/game.service';
import { RelUserGameTeamService } from '../services/relUserGameTeam.service';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PlayStartComponent } from '../components/play-start/play-start.component';
import { PlayEndComponent } from '../components/play-end/play-end.component';
import { PlayComponent } from '../components/play/play.component';
import { TeamService } from '../services/team.service';
import { DatePipe } from '@angular/common';
import { PlayTeamComponent } from "src/components/play-team/play-team.component";
import { PlayOnlyComponent } from "src/components/play-only/play-only.component";
import { SuperUserComponent } from '../components/super-user/super-user.component';

@NgModule({
  declarations: [
    AppComponent,
    loginComponent,
    GameMasterComponent,
    GameComponent,
    PlayerComponent,
    PlayStartComponent,
    PlayEndComponent,
    PlayComponent,
    PlayTeamComponent,
    PlayOnlyComponent,
    SuperUserComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    HttpModule
  ],
  providers: [
    GameService,
    RelUserGameTeamService,
    TeamService,
    DatePipe
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
