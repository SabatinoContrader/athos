import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { loginComponent } from 'src/components/login/login.component';
import { GameComponent } from '../components/game/game.component';
import { GameMasterComponent } from '../components/gameMaster/gameMaster.component';
import { PlayerComponent } from '../components/player/player.component';
import { PlayComponent } from '../components/play/play.component';
import { PlayStartComponent } from '../components/play-start/play-start.component';
import { PlayEndComponent } from '../components/play-end/play-end.component';
import { SuperUserComponent } from '../components/super-user/super-user.component';
import { ViewSuperComponent } from '../components/view-super/view-super.component';
import { SuperListComponent } from '../components/super-list/super-list.component';

const routes: Routes = [
  {path: '', redirectTo: '/login', pathMatch: 'full'},
  {path:'login', component: loginComponent},
  {path:'gameMaster', component: GameMasterComponent},
  {path:'game', component: GameComponent},
  {path:'player', component: PlayerComponent},
  {path:'play', component: PlayComponent},
  {path:'playStart', component: PlayStartComponent},
  {path:'playEnd', component: PlayEndComponent},
  {path:'superUser', component: SuperUserComponent},
  {path:'viewSuper', component: ViewSuperComponent},
  {path:'superList', component: SuperListComponent}
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
