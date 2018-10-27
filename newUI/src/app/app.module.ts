import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { MatButtonModule, MatCardModule, MatInputModule, MatListModule, MatToolbarModule} from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import {MatCheckboxModule} from '@angular/material/checkbox';
import {MatIconModule} from '@angular/material/icon';
import {MatMenuModule} from '@angular/material/menu';
import {MatSelectModule} from '@angular/material/select';
import {MatRadioModule} from '@angular/material/radio';
import {MatSlideToggleModule} from '@angular/material/slide-toggle';
import { MenuComponent } from './menu/menu.component';
import { AddComponent } from './add/add.component';
import { MenuService } from './menu.service';
import { InfoComponent } from './info/info.component';


const appRoutes: Routes = [
  { path: '',
  redirectTo: 'WatchMenu',
  pathMatch: 'full'
},
{ path: 'AddFood',
  component: AddComponent },
  { path: 'WatchMenu',
  component: MenuComponent },
  {
    path: 'WatchMenu/info/:mid',
    component: InfoComponent
    }
];

@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    AddComponent,
    InfoComponent

  ],
  imports: [
    MatSlideToggleModule,
    MatRadioModule,
    MatSelectModule,
    MatMenuModule,
    MatIconModule,
    MatCheckboxModule,
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatCardModule,
    MatInputModule,
    MatListModule,
    MatToolbarModule,
    FormsModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [MenuService],
  bootstrap: [AppComponent]
})
export class AppModule { }
