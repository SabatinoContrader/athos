import { Injectable } from "@angular/core";
import {HttpClient, HttpParams} from '@angular/common/http';
import {Observable, of, BehaviorSubject} from 'rxjs';
import { Game } from '../models/Game';
import { tap, catchError } from 'rxjs/operators';
import { User } from "src/models/User";
import { DatePipe } from '@angular/common';

@Injectable({
  providedIn: 'root'
})
export class GameService {
  feedback: string;
  public user:User

  constructor(private http: HttpClient, public datepipe : DatePipe) { }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);
      console.log('${operation} failed: ${error.message}');
      return of(result as T);
    };
  }

 findAll():Observable<Array<Game>>{
  this.user=JSON.parse(sessionStorage.getItem("user")); 
  return this.http.post<Array<Game>>('http://localhost:8080/athos/Game/giochiPerCreatore', this.user);
  }

  tuttigiochi():Observable<Array<Game>>{
    return this.http.get<Array<Game>>('http://localhost:8080/athos/Game/tuttiGiochi')
    .pipe(tap((response) => console.log("Game"), catchError(this.handleError("login error", {}))))
  }

  delete(idGame: String): Observable<boolean>{
    return this.http.post<boolean>('http://localhost:8080/athos/Game/disattivaGiochi', idGame);
  }
 /*
  readOne(idmedico:string): Observable<Medico>{
    return this.http.get<Medico>('http://localhost:8080/HomeMedico/updateForm?id='+idmedico);
  }

  update(idmed:string, nomeMedico:string, cognomeMedico:string, specializzazioneMedico:string, indirizzoMedico:string, mailMedico:string):Observable<Medico>{
    const params = new HttpParams().set("idMedico", idmed).set("nomeMedico", nomeMedico).set("cognomeMedico", cognomeMedico).set("specializzazioneMedico",specializzazioneMedico).set("indirizzoMedico",indirizzoMedico).set("mailMedico",mailMedico);
    console.log(idmed);
    return this.http.post<Medico>("http://localhost:8080/HomeMedico/updateMedico", params)
  }

  

  newMedico(nomeMedico:string, cognomeMedico:string, specializzazioneMedico:string, indirizzoMedico:string, mailMedico:string): Observable<Medico>{
    const params = new HttpParams().set("nomeMedico", nomeMedico).set("cognomeMedico", cognomeMedico).set("specializzazioneMedico",specializzazioneMedico).set("indirizzoMedico",indirizzoMedico).set("mailMedico",mailMedico);
    return this.http.post<Medico>('http://localhost:8080/HomeMedico/insertMedico', params)
  }
  */

  /*changeFeedback(message: string){
    this.feedback = message;
  }*/

  deleteFeedback(){
    this.feedback = "";
  }

}
