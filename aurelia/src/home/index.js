import {HttpClient, json} from 'aurelia-fetch-client'
export class Home {
	userData = {}
	userList = []
	activate() {
		let client = new HttpClient();

		client.fetch('http://localhost:8080/user')
			.then(response => response.json())
			.then(users => this.userList = users);
	}

	addUser() {
		let client = new HttpClient();
		console.log();
		client.fetch('http://localhost:8080/user/add', {
			'method': "POST",
			'body': json(this.userData)
		})
			.then(response => response.json())
			.then(data => {
				console.log("Server saatis " + data.username);
		});

		console.log("Method executed!");
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