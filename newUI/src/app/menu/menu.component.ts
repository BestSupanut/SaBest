import { Component, OnInit } from '@angular/core';
import { MenuService } from '../menu.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {
  menus: Array<any>;
constructor(private menuService: MenuService) { }

ngOnInit() {
    this.menuService.getAllMenu().subscribe(data => {
    this.menus = data;
    })
  }
}
