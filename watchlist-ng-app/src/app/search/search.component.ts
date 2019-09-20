import { Component, OnInit } from '@angular/core';
import { Movie } from '../model/movie'
import { EventEmitterService } from '../event-emitter/event-emitter.service'
import { ApiService } from '../service/api.service'

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  movies: Movie[];

  constructor(private eventEmitterService: EventEmitterService,
              private api : ApiService) { }

  ngOnInit() {
      this.eventEmitterService.subsVar = this.eventEmitterService.
      invokeSearchComponentSetSearchFunction.subscribe(
        (res: Movie[]) => {
          this.movies = res;
      },
      err => {
        alert("Ocorreu um erro. Por favor tente novamente.")
      });
  }

}
