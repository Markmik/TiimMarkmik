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
				document.location.href = '/#/notes';
		});

		
	}
	removeNote(noteId){
      let client = new HttpClient();

      client.fetch('http://localhost:8080/notes/delete/' + noteId, {
        'method': 'DELETE'
      }).then(() => {
        	
			console.log("kustutas ");

      });
    document.location.href = '/#/notered';
  	}

  


}

var modal3 = document.getElementById('id03_note');
var modal4 = document.getElementById('id04_reminder');

