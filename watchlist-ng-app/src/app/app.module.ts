import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule }   from '@angular/forms';
import {HttpClientModule} from "@angular/common/http"
import { AppRoutingModule } from './app-routing.module'


import { AppComponent } from './app.component';
import { NavigationComponent } from './navigation/navigation.component';
import { WatchlistComponent } from './watchlist/watchlist.component';
import { SearchComponent } from './search/search.component';
import { WatchlistFavoritesComponent } from './watchlist-favorites/watchlist-favorites.component';
import { EventEmitterService } from './event-emitter/event-emitter.service';
import { MovieCardComponent } from './movie-card/movie-card.component';
import { MoviePageComponent } from './movie-page/movie-page.component';

@NgModule({
  declarations: [
    AppComponent,
    NavigationComponent,
    WatchlistComponent,
    SearchComponent,
    WatchlistFavoritesComponent,
    MovieCardComponent,
    MoviePageComponent
    ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [
    EventEmitterService, 
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

