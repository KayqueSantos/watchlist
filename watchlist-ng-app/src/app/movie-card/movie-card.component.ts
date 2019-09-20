import { Component, OnInit, Input } from '@angular/core';
import { Movie } from '../model/movie'
import { ApiService } from '../service/api.service';
import { Router } from '@angular/router'

@Component({
  selector: 'app-movie-card',
  templateUrl: './movie-card.component.html',
  styleUrls: ['./movie-card.component.css']
})
export class MovieCardComponent implements OnInit {
  @Input() movies: Movie[];

  constructor(private api: ApiService,
              private router: Router) { }

  ngOnInit() {
  }

  setFavorite(movie: Movie): void{
    this.api.setFavorite(movie.id).subscribe(
      (res: Movie) => {
        movie.favorite = res.favorite;
        if(this.router.url=='/watchlist/favorites' && !movie.favorite) {
          let index = this.movies.indexOf(movie);
          this.movies.splice(index, 1);
        }
      },
      err => {
        alert("Ocorreu um erro. Por favor tente novamente.")
      }
    );
  }

}
