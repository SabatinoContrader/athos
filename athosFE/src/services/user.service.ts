import { Injectable } from "@angular/core";
import {HttpClient, HttpParams} from '@angular/common/http';
import {Observable, of, BehaviorSubject} from 'rxjs';
import { User } from '../models/User';
import { tap, catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  feedback: string;

  constructor(private http: HttpClient) { }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.log(result);
      console.error(error);
      console.log('${operation} failed: ${error.message}');
      return of(result as T);
    };
  }

  login(username: string, password: string): Observable <User> {
    var userInput=new User(0,username,password,0,true);
    return this.http.post<User>('http://localhost:8080/athos/Login/loginControl',userInput)
    .pipe(tap((response) => console.log("User"), catchError(this.handleError("login error", {}))));
  }

  changeFeedback(message: string){
    this.feedback = message;
  }

  deleteFeedback(){
    this.feedback = "";
  }

}
