import {HttpClient, json} from 'aurelia-fetch-client'
export class Welcome {
	noteData = {}
	noteList = []
	activate() {
		let client = new HttpClient();

		client.fetch('http://localhost:8080/note')
			.then(response => response.json())
			.then(notes => this.noteList = notes);
	}

	addUser() {
		let client = new HttpClient();

		client.fetch('http://localhost:8080/note/add', {
			'method': "POST",
			'body': json(this.noteData)
		})
			.then(response => response.json())
			.then(data => {
				console.log("Server saatis " + data.title);
		});

		console.log("Method executed!")
	}


}

var modal3 = document.getElementById('id03_note');
var modal4 = document.getElementById('id04_reminder');

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal3){
		modal3.style.display = "none";
	} else if (event.target == modal4){
		modal4.style.display = "none";
	}

}