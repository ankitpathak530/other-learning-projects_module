import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { NormalRoutingModule } from './normal-routing.module';
import { AboutComponent } from './about/about.component';
import { ListComponent } from './list/list.component';


@NgModule({
  declarations: [
    AboutComponent,
    ListComponent
  ],
  imports: [
    CommonModule,
    NormalRoutingModule
  ]
})
export class NormalModule { }
