import { Injectable, EventEmitter } from '@angular/core';
import { Subscription } from 'rxjs/internal/Subscription';
import {Movie} from '../model/movie'
import { Router } from '@angular/router';


@Injectable({
  providedIn: 'root'
})
export class EventEmitterService {

  invokeSearchComponentSetSearchFunction = new EventEmitter<Movie[]>();
  subsVar: Subscription;

  constructor(private router: Router) { }

  onGetSearchMethod(MovieList: Movie[]): void{
    this.invokeSearchComponentSetSearchFunction.emit(MovieList);
  }

}
