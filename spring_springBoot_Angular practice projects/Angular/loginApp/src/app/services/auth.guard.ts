import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { LoginService } from './login.service';


@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  constructor(private loginService: LoginService, private router: Router) {

  }
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {

    //As we are not using backend server here so for sake of time I am returning true alwayes else bottoom line need to be uncomment.
    return true;

    /*
    if(this.loginService.isLogedIn())
    {
     return true;
    }
    this.router.navigate(['login']);
  return false; 
    */

  }

}
