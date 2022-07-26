import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutComponent } from './about/about.component';
import { ListComponent } from './list/list.component';

const routes: Routes = [


  { path: 'about', component: AboutComponent },
  { path: 'list', component: ListComponent }

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class NormalRoutingModule { }
