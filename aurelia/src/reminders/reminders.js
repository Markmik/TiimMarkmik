import {HttpClient, json} from 'aurelia-fetch-client'
export class Reminders {
	reminderData = {}
	reminderList = []
	activate() {
		let client = new HttpClient();

		client.fetch('http://localhost:8080/reminders')
			.then(response => response.json())
			.then(reminders => this.reminderList = reminders);
	}

	addReminder() {
		let client = new HttpClient();
		console.log(this.reminderData);
		client.fetch('http://localhost:8080/reminders/add', {
			'method': "POST",
			'body': json(this.reminderData)

		})
			.then(response => response.json())
			.then(data => {
				
				console.log("Server saatis " + data.title);
				document.getElementById('id03_note').style.display='none'
		});

		console.log("Method executed!")
	}
	removeReminder(reminderId){
      let client = new HttpClient();

      client.fetch('http://localhost:8080/reminders/' + reminderId, {
        'method': 'DELETE'
      }).then(() => {
        	
			console.log("kustutas ");

      });
  	}

  


}

var modal4 = document.getElementById('id04_reminder');

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal4){
		modal4.style.display = "none";
	}

}