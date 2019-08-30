import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {Routes, RouterModule} from '@angular/router';
import { WatchlistComponent } from './watchlist/watchlist.component';
import { SearchComponent } from './search/search.component';
import { WatchlistFavoritesComponent } from './watchlist-favorites/watchlist-favorites.component';


const appRoutes :Routes = [
  {
    path:'watchlist',
    component:WatchlistComponent
  },
  {
    path:'watchlist/favorites',
    component:WatchlistFavoritesComponent
  },
  {
    path: 'search',
    component:SearchComponent
  }
]

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forRoot(appRoutes)
  ],
  exports: [
    RouterModule
  ],
  declarations: []
})

export class AppRoutingModule { }
