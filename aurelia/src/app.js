import {HttpClient, json} from 'aurelia-fetch-client'
export class App {
  configureRouter(config, router) {
    this.router = router;
    config.title = 'Markmik';
    config.map([
      { route: ['', 'home'],       name: 'home',       moduleId: 'home/index', nav: true },
      { route: 'Welcome', name: 'Welcome', moduleId: 'welcome/welcome', nav: true, title: 'Welcome' },
      { route: 'Notes', name: 'Notes', moduleId: 'notes/notes', nav: true, title: 'Notes' },
      { route: 'Reminders', name: 'Reminders', moduleId: 'reminders/reminders', nav: true, title: 'Reminders' },
      
    ]);
  }
  
}


