import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { AuthGuard } from 'src/app/services/auth.guard';


const routes: Routes = [

	{
		path: 'admin',
		loadChildren: () => import('./admin/admin.module').then(mod => mod.AdminModule)
	},

	{
		path: 'normal',
		loadChildren: () => import('./normal/normal.module').then(mod => mod.NormalModule)
	},
	{
		path: '',
		component: HomeComponent
	},
	{
		path: "dashboard",
		component: DashboardComponent,
	},
	{
		path: "login",
		component: LoginComponent,
	}
];

@NgModule({
	imports: [RouterModule.forRoot(routes)],
	exports: [RouterModule]
})
export class AppRoutingModule { }
