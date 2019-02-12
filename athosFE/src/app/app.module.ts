import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from "@angular/forms";
import { HttpClientModule } from "@angular/common/http";
import { HttpModule } from '@angular/http';

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { GameMasterComponent } from '../components/gameMaster/gameMaster.component';
import { GameComponent } from '../components/game/game.component';
import {GameService} from '../services/game.service'
import { loginComponent } from 'src/components/login/login.component';


@NgModule({
  declarations: [
    AppComponent,
    loginComponent,
    GameMasterComponent,
    GameComponent
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
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
