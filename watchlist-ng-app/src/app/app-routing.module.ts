import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {Routes, RouterModule} from '@angular/router';
import { WatchlistComponent } from './watchlist/watchlist.component';
import { SearchComponent } from './search/search.component';
import { WatchlistFavoritesComponent } from './watchlist-favorites/watchlist-favorites.component';
import { MoviePageComponent } from './movie-page/movie-page.component';


const appRoutes :Routes = [
  {
    path: '',
    redirectTo:'watchlist/all',
    pathMatch: 'full'
  },
  {
    path:'watchlist/all',
    component:WatchlistComponent
  },
  {
    path:'watchlist/favorites',
    component:WatchlistFavoritesComponent
  },
  {
    path: 'watchlist/search',
    component:SearchComponent
  },
  {
    path: 'watchlist/movie/:movieId',
    component:MoviePageComponent
  }
]

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forRoot(appRoutes, {onSameUrlNavigation: 'reload'})
  ],
  exports: [
    RouterModule
  ],
  declarations: []
})

export class AppRoutingModule { }
