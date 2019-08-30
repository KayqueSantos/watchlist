import { Injectable } from "@angular/core";
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from "rxjs";
import { Movie } from "../model/movie"
import { moveEmbeddedView } from "@angular/core/src/view";

@Injectable({
    providedIn: 'root'
})
export class ApiService {
    private BASE_URL = "http://localhost:8080/api/";
    private GET_MOVIES_ALL_URL = this.BASE_URL+"movies/all";
    private GET_MOVIES_FAVORITES_URL = this.BASE_URL+"movies/favorites";
    private SEARCH_URL = this.BASE_URL+"search";

    constructor(private http: HttpClient) {

    }

    sendSearch(movieTitleSearch: string): Observable<Object> {
        let body = new HttpParams();
        body = body.set('movieTitleSearch', movieTitleSearch);
        return this.http.post(this.SEARCH_URL, body);
    }

    getWatchlist(): Observable<Object> {
        return this.http.get(this.GET_MOVIES_ALL_URL);
    }

    getWatchlistFavorites(): Observable<Object> {
        return this.http.get(this.GET_MOVIES_FAVORITES_URL);
    }

    setFavorite(movieId: string): Observable<Object> {
        return this.http.get(this.BASE_URL+movieId+"/favorite/toggle");
    }

}