import { NgModule } from '@angular/core';
import {Routes, RouterModule} from '@angular/router'

import { loginComponent } from 'src/components/login/login.component';
import { GameMasterComponent } from '../components/gameMaster/gameMaster.component';
import { GameComponent } from '../components/game/game.component';

const routes: Routes = [
  {path: '', redirectTo: '/login', pathMatch: 'full'},
  {path:'login', component: loginComponent},
  {path:'gameMaster', component: GameMasterComponent},
  {path:'game', component: GameComponent}
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
