import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Movie } from '../model/movie'

@Component({
  selector: 'app-watchlist',
  templateUrl: './watchlist.component.html',
  styleUrls: ['./watchlist.component.css']
})
export class WatchlistComponent implements OnInit {
  movies: Movie[] = [];
  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.getWatchlist();
  }

  public getWatchlist() {
    let url = "http://localhost:8080/api/watchlist";
    this.http.get<Movie[]>(url).subscribe(
      res => {
        this.movies = res;
        console.log(res);
      },
      err => {
        alert("An error has occured.")
      }
    );
  }

}
