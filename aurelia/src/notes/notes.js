import {HttpClient, json} from 'aurelia-fetch-client'

export class Notes {
	noteData = {}
	noteList = []
	noteListByCode = []
	activate() {
		let client = new HttpClient();
		try {
		    var test=parseInt(document.getElementById('save').className);
		}
		catch(err) {
		    document.location.href = '/#/';
		}
		
		console.log(this.userList);
		console.log("ntes");
		client.fetch('http://localhost:8080/note/'+document.getElementById('save').className)
			.then(response => response.json())
			.then(notes => this.noteList = notes);

	}

	addNote() {
		let client = new HttpClient();
		
		this.noteData['usercode']=parseInt(document.getElementById('save').className);
		client.fetch('http://localhost:8080/notes/add', {
			'method': "POST",
			'body': json(this.noteData)
		})
			.then(response => response.json())
			.then(data => {
				console.log("Server saatis " + data.usercode);
				document.getElementById('id03_note').style.display='none'
		});

		
	}
	removeNote(noteId){
      let client = new HttpClient();

      client.fetch('http://localhost:8080/notes/delete/' + noteId, {
        'method': 'DELETE'
      }).then(() => {
        	
			console.log("kustutas ");

      });
    
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