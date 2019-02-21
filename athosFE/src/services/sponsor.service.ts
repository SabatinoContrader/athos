import { Injectable } from "@angular/core";
import {HttpClient, HttpParams} from '@angular/common/http';
import {Observable, of, BehaviorSubject} from 'rxjs';
import { Sponsor } from '../models/Sponsor';
import { tap, catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class SponsorService {
  feedback: string;

  constructor(private http: HttpClient) { }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);
      console.log('${operation} failed: ${error.message}');
      return of(result as T);
    };
  }
  tuttisponsor():Observable<Array<Sponsor>>{
    return this.http.get<Array<Sponsor>>('http://localhost:8080/athos/Sponsor/tuttiSponsor')
    .pipe(tap((response) => console.log("Sponsor"), catchError(this.handleError("list sponsor error", {}))))
  }
  delete(id: number):Observable<boolean>{
    return this.http.get<boolean>('http://localhost:8080/athos/Sponsor/disattivaSponsor?id='+id)
     .pipe(tap((response) => console.log("Sponsor"), catchError(this.handleError("delete sponsor error", {}))))
   }
    deleteFeedback(){
      this.feedback = "";
    } 
  save(messaggio: string, nome: string): any{
    var sponsor = new Sponsor(0, true ,messaggio, nome);
    return this.http.post<any>('http://localhost:8080/athos/Sponsor/insertSponsor', sponsor)
    .pipe(tap((response) => console.log("sponsor"), catchError(this.handleError("new Sponsor error", {})))
  );
  }
}
