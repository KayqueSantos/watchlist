import { Component, OnInit } from '@angular/core';
import { ApiService } from '../service/api.service';
import { Movie } from '../model/movie'

@Component({
  selector: 'app-watchlist-favorites',
  templateUrl: './watchlist-favorites.component.html',
  styleUrls: ['./watchlist-favorites.component.css']
})
export class WatchlistFavoritesComponent implements OnInit {
  movies: Movie[] = [];

  constructor(private api: ApiService) { }

  ngOnInit() {
    this.getWatchlistFavorites();
  }

  public getWatchlistFavorites(): void{
    this.api.getWatchlistFavorites().subscribe(
      (res: Movie[]) => {
        this.movies = res;
      },
      err => {
        alert("Ocorreu um erro. Por favor tente novamente.")
      }
    );
  }

}
