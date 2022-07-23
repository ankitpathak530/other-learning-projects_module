import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';



@Injectable({
  providedIn: 'root'
})
export class LoginService {
  
  url="http://localhost:8080"


  constructor(private http:HttpClient) { }


   //calling server to generate tokens
   generateToken(credentials:any){
   	  //generate token
   	  return this.http.post(`${this.url}/token`,credentials);
   }

 











  //for login user
  loginUser(token:string){
  	localStorage.setItem("token",token);
  	return true;
  }
  //To check that user is log in or not
  isLogedIn(){
  	let token = localStorage.getItem("token");
  	if(token == undefined || token==='' || token==null){
  		return false;
  	}
  	else{
  		return true;
  	}
  }
  // To logout the user
  logout(){
  	localStorage.removeItem("token");
  	return true;
  }

 // To get the token
   getToken(){
   	   return localStorage.getItem("token");
   }


}
