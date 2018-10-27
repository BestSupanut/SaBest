import { Component, OnInit } from '@angular/core';
import { MenuService } from '../menu.service';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-info',
  templateUrl: './info.component.html',
  styleUrls: ['./info.component.css']
})
export class InfoComponent implements OnInit {
  menu: Object;
  menus: Array<any>;
  story:Object;
  stories: Array<any>;


   constructor(private menuService: MenuService,private route: ActivatedRoute,private httpClient: HttpClient
    ) {
    this.route.params.subscribe( params => this.menu = params.mid)
    this.route.params.subscribe( params => this.stories = params.mid)
   }
   ngOnInit() {
  this.menuService.getMenu(this.menu).subscribe(
      data => this.menu = data)
     this.menuService.getAllMenu().subscribe(data => {
     this.menus = data;})
     this.menuService.getAllStory().subscribe(data => {
      this.stories = data;})
   }

}
