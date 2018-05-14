import {HttpClient, json} from 'aurelia-fetch-client'
export class Notered {
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
		
		document.location.href = '/#/notes';

	}
}