import {HttpClient, json} from 'aurelia-fetch-client'

export class App {
  configureRouter(config, router) {
    this.router = router;
    config.title = 'Markmik';
    config.map([
      { route: ['', 'home'],       name: 'home',       moduleId: 'home/index', nav: true },
      { route: 'Welcome', name: 'Welcome', moduleId: 'welcome/welcome', nav: true, title: 'Welcome' },
      { route: 'Notes', name: 'Notes', moduleId: 'notes/notes', nav: true, title: 'Notes' },
      { route: 'NotesAdd', name: 'NotesAdd', moduleId: 'notes/notesadd', nav: true, title: 'Add Note' },
      { route: 'NoteRed', name: 'NoteRed', moduleId: 'redirect/notered', nav: true },
      { route: 'Reminders', name: 'Reminders', moduleId: 'reminders/reminders', nav: true, title: 'Reminders' },
      { route: 'RemindersAdd', name: 'RemindersAdd', moduleId: 'reminders/remindersadd', nav: true, title: 'Add Reminder' },
      
    ]);
  }
  
}


