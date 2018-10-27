import { MenuService } from './../menu.service';
import { Component, OnInit } from '@angular/core';
import { HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {

menu:Array<any>;
ingredient:Array<any>;
  ngOnInit() {
    this.getAllMenu();
    this.getShowIngredient();
  };

nutext:String;
stext:String;
protein:String;
carbohydrate:String;
vitamin:String;
fat:String;
fruit:String;

  mymenu : any = {
    cal:''
  }


  save(){

    this.httpClient.post('http://localhost:8080/menu/create/'+ this.stext+'/'+this.nutext+
    '/'+this.protein+'/'+this.carbohydrate+'/'+this.vitamin+'/'+this.fruit+'/'+this.fat,this.mymenu).subscribe(
      data => {
          console.log('PUT Request is successful', data);
      },
      error => {
          console.log('Error', error);
          //window.location.reload();
      }

  );

  }

  getAllMenu() {
    this.MenuService.getAllMenu().subscribe(data => {
    this.menu = data;
    console.log(this.menu);
    });
  }

  getShowIngredient() {
    this.MenuService.getShowIngredient().subscribe(data => {
    this.ingredient = data;
    console.log(this.ingredient);
    });
  }
  constructor(private httpClient: HttpClient,private MenuService: MenuService) { }
    }




