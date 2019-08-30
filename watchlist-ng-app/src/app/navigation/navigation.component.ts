import { Component, OnInit } from '@angular/core';
import { ApiService } from '../service/api.service'
import { Movie } from '../model/movie'
import { EventEmitterService } from '../event-emitter/event-emitter.service'


@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css']
})
export class NavigationComponent implements OnInit {
  model:Search = {
    movieTitleSearch:''
  };

  private movieList: Movie[];

  constructor(private api: ApiService,
              private eventEmitterService: EventEmitterService) {
   }

  ngOnInit() {
  }

  sendSearch(): void{
    const movieTitleSearch: string = this.model.movieTitleSearch;
      this.api.sendSearch(movieTitleSearch).subscribe(
        (res: Movie[]) =>  {
          this.eventEmitterService.onGetSearchMethod(res);
        },
        err => {
          alert("An error has occured.")
        }
      );
  }

}

export interface Search{
  movieTitleSearch:string;
}