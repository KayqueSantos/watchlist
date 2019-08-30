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

  setFavorite(movie: Movie): void{
    this.api.setFavorite(movie.id).subscribe(
      (res: Movie) => {
        movie.favorite = res.favorite;
        if(movie.favorite==false){
          const index = this.movies.indexOf(movie);
          this.movies.splice(index, 1);
        } 
      },
      err => {
        alert("Ocorreu um erro. Por favor tente novamente.")
      }
    );
  }

}
