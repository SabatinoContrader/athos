import { Injectable } from "@angular/core";
import {HttpClient, HttpParams} from '@angular/common/http';
import {Observable, of, BehaviorSubject} from 'rxjs';
import { RelUserGameTeam } from '../models/RelUserGameTeam';
import { tap, catchError } from 'rxjs/operators';
import { DatePipe } from '@angular/common';

@Injectable({providedIn: 'root'})

export class RelUserGameTeamService {

 feedback: string;

  constructor(private http: HttpClient, public datepipe : DatePipe) { }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.log('${operation} failed: ${error.message}');
      return of(result as T);
    };
  }

 findAll():Observable<Array<RelUserGameTeam>>{
  return this.http.get<Array<RelUserGameTeam>>('http://localhost:8080/athos/relUserGame/tuttiGiochi')
    .pipe(tap((response) => console.log("RelUserGameTeam"), catchError(this.handleError("login error", {}))))
  }

}
