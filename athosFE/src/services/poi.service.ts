import { Injectable } from "@angular/core";
import {HttpClient, HttpParams} from '@angular/common/http';
import {Observable, of, BehaviorSubject} from 'rxjs';
import { Poi } from '../models/Poi';
import { tap, catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class PoiService {
  feedback: string;

  constructor(private http: HttpClient) { }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);
      console.log('${operation} failed: ${error.message}');
      return of(result as T);
    };
  }
  delete(id: number):Observable<boolean>{ 
    return this.http.get<boolean>('http://localhost:8080/athos/Poi/disattivaPoi?id='+id)
     .pipe(tap((response) => console.log("Poi"), catchError(this.handleError("delete poi error", {}))))
   }
 
  tuttipoi():Observable<Array<Poi>>{
    return this.http.get<Array<Poi>>('http://localhost:8080/athos/Poi/tuttiPoi')
    .pipe(tap((response) => console.log("Poi"), catchError(this.handleError("list poi error", {}))))
  }

  deleteFeedback(){
    this.feedback = "";
  }

  save(nome: string, latitudine: number,longitudine: number): any{
    var poi = new Poi(0, true, nome, latitudine, longitudine);
    return this.http.post<any>('http://localhost:8080/athos/Poi/insertPoi', poi)
    .pipe(tap((response) => console.log("poi"), catchError(this.handleError("new Poi error", {})))
  );
  }
}
