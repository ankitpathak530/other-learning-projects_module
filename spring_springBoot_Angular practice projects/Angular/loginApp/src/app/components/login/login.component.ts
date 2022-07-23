import { Component, OnInit } from '@angular/core';
import { Route, Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  credentials = {
    username: 'Ankit',
    password: '1234'
  }





  constructor(private loginService: LoginService, private router: Router) { }

  ngOnInit(): void {
  }



  onSubmit() {
    console.log("form is submited");
    if ((this.credentials.username != '' && this.credentials.password != '') && (this.credentials.username != null && this.credentials.password != null)) {

      if (this.credentials.username == 'Ankit' && this.credentials.password == '1234') {

        window.location.href = '/dashboard';
        // this.router.navigate(['dashboard']);
      }

      /*
          this.loginService.generateToken(this.credentials).subscribe(
                 (response:any)=>{
                       console.log(response.token);
           
                       console.log(this.loginService.loginUser(response.token));
                       window.location.href='/dashboard';


                  },
                 error=>{
                     console.log("error");
                 }     
            )
        */
    }
    else {
      alert("filed are empty.");
    }

  }








}
