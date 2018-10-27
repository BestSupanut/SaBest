import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()

export class MenuService {
  constructor(private http: HttpClient) {
  }
  public API = '//localhost:8080';

  getAllMenu(): Observable<any> {
    return this.http.get('//localhost:8080/menu');
  }
  getMenu(Mid) {
    return this.http.get('//localhost:8080/menu/' + Mid);
  }

  getAllStory(): Observable<any> {
    return this.http.get('//localhost:8080/story');
  }
  getStoryId(Sid) {
    return this.http.get('//localhost:8080/story/' + Sid);
  }
  getShowIngredient(): Observable<any> {
    return this.http.get('//localhost:8080/ingredient');
  }
  
}
