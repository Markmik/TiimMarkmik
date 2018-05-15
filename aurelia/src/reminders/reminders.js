import {HttpClient, json} from 'aurelia-fetch-client'
export class Reminders {
	reminderData = {}
	reminderList = []
	activate() {
		let client = new HttpClient();
		try {
		    var test=parseInt(document.getElementById('save').className);
		}
		catch(err) {
		    document.location.href = '/#/';
		}
		
		console.log(this.reminderList);
		console.log("rmdns");
		client.fetch('http://localhost:8080/reminders/'+document.getElementById('save').className)
			.then(response => response.json())
			.then(reminders => this.reminderList = reminders);

	}

	addReminder() {
		let client = new HttpClient();
		console.log(this.reminderData);
		this.reminderData['usercode']=parseInt(document.getElementById('save').className);
		client.fetch('http://localhost:8080/reminders/add', {
			'method': "POST",
			'body': json(this.reminderData)

		})
			.then(response => response.json())
			.then(data => {
				
				console.log("Server saatis " + data.title);
				document.getElementById('id04_reminder').style.display='none'
		});

		console.log("Method executed!")
	}
	removeReminder(reminderId){
      let client = new HttpClient();

      client.fetch('http://localhost:8080/reminders/' + reminderId, {
        'method': 'DELETE'
      }).then(() => {
        	
			console.log("kustutas ");
			document.location.href = '/#/Reminderred';
			

      });
  	}

  


}

var modal4 = document.getElementById('id04_reminder');

