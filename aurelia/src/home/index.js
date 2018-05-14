
import {HttpClient, json} from 'aurelia-fetch-client'

export class Home {
	userData = {}
	userList = []
	activate() {

		let client = new HttpClient();

		client.fetch('http://localhost:8080/users')
			.then(response => response.json())
			.then(users => this.userList = users);

	}

	addUser() {
		for (var i = 0; i < this.userList.length; i++) {
			console.log(this.userList[i]['username']);
			if(this.userList[i]['username'] == this.userData.username) {
				alert("This username is already in use");
				return;
			}
			if(this.userList[i]['email'] == this.userData.email) {
				alert("This email is already in use");
				return
			}
			if(this.userData.password != this.password2) {
				alert("The passwords must match");
				return
			}
		}
		
		let client = new HttpClient();
		console.log();
		client.fetch('http://localhost:8080/users/add', {
			'method': "POST",
			'body': json(this.userData)
		})
			.then(response => response.json())
			.then(data => {
				this.userList.push(data);
		});
		console.log("Method executed!");
		document.getElementById('id01_signup').style.display='none'


		
		

		

	}
	
	
	login() {
		let client = new HttpClient();

		client.fetch('http://localhost:8080/users')
			.then(response => response.json())
			.then(users => this.userList = users);
			
		console.log(this.userList);
		for (var i = 0; i < this.userList.length; i++) {
			var valid = false;
			
			if(this.userList[i]['username'] == this.login_username) {
				valid=true;
			} else {
				valid=false;
			}
			if(this.userList[i]['password'] == this.login_password) {
				valid=true;
			} else {
				valid=false;
			}
			
			if(valid) {
				
				document.getElementById('save').className=this.userList[i]['userid'];
	
				document.getElementById('id02_login').style.display='none';
				document.location.href = '/#/notes';
				return;

			} 

		
		}
		alert("This username or password is wrong");
				return;
		
	}

	}




var modal = document.getElementById('id01_signup');
var modal2 = document.getElementById('id02_login');


// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    } else if (event.target == modal2){
		modal2.style.display = "none";
	}

}