import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css']
})
export class NavigationComponent implements OnInit {
  model:Search = {
    query:''
  };

  constructor(private http: HttpClient) {
   }

  ngOnInit() {
  }

  sendSearch(): void{
    alert(this.model.query)
    let url = "http://localhost:8080/api/search";
    let body = new HttpParams();
    body = body.set('query', this.model.query);
    this.http.post(url, body).subscribe(
      (data: any) => console.log(data)
    );
  }
}

export interface Search{
  query:string;
}