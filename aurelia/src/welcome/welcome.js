import {HttpClient, json} from 'aurelia-fetch-client'
export class Welcome {
	reminderData = {}
	reminderList2 = []
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
		client.fetch('http://localhost:8080/reminders/late/'+document.getElementById('save').className)
			.then(response => response.json())
			.then(reminders => this.reminderList2 = reminders);

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

