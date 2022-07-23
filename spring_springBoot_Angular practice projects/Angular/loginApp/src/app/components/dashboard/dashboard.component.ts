import { Component, OnInit } from '@angular/core';
import { MyStrPipePipe } from 'src/app/pipes/my-str-pipe.pipe';
import { UserService } from 'src/app/services/user.service';



@Component({
	selector: 'app-dashboard',
	templateUrl: './dashboard.component.html',
	styleUrls: ['./dashboard.component.css'],
	providers: [
		MyStrPipePipe
	]
})
export class DashboardComponent implements OnInit {



	constructor(private userService: UserService, private myStrPipe: MyStrPipePipe) {

	}

	ngOnInit(): void {

	}

	getUser() {
		this.userService.getUser().subscribe(
			user => {
				console.log(user);
			},
			error => {
				console.log(error);
			}
		);
	}
}
