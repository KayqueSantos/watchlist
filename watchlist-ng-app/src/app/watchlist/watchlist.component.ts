import { Component, OnInit } from '@angular/core';
import { ApiService } from '../service/api.service';
import { Movie } from '../model/movie'

@Component({
  selector: 'app-watchlist',
  templateUrl: './watchlist.component.html',
  styleUrls: ['./watchlist.component.css']
})
export class WatchlistComponent implements OnInit {
  movies: Movie[] = [];

  constructor(private api: ApiService) { }

  ngOnInit() {
    this.getWatchlist();
  }

  getWatchlist(): void{
    this.api.getWatchlist().subscribe(
      (res: Movie[]) => {
        this.movies = res;
      },
      err => {
        alert("Ocorreu um erro. Por favor tente novamente.")
      }
    );
  }

}
