import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router'
import { ApiService } from '../service/api.service';
import { Movie } from '../model/movie'

@Component({
  selector: 'app-movie-page',
  templateUrl: './movie-page.component.html',
  styleUrls: ['./movie-page.component.css']
})
export class MoviePageComponent implements OnInit {

  movie: Movie;

  constructor(private api: ApiService,
    private activatedRoute: ActivatedRoute) { }

  ngOnInit() {
    this.getMovieInfo();
  }

  getMovieInfo(): void{
    let movieId: string = this.activatedRoute.snapshot.paramMap.get("movieId");
    this.api.getById(movieId).subscribe(
      (res: Movie) => {
        this.movie = res;
      },
      err => {
        alert("Ocorreu um erro. Por favor tente novamente.")
      } 
    )
  }

  setFavorite(movie: Movie): void{
    this.api.setFavorite(movie.id).subscribe(
      (res: Movie) => {
        movie.favorite = res.favorite;
      },
      err => {
        alert("Ocorreu um erro. Por favor tente novamente.")
      }
    );
  }

}
