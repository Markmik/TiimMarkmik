export class App {
  configureRouter(config, router) {
    this.router = router;
    config.title = 'StudyHub';
    config.map([
      { route: ['', 'home'],       name: 'home',       moduleId: 'home/home', nav: true },
      { route: 'welcome', name: 'welcome', moduleId: 'welcome/welcome', nav: true, title: 'welcome' },
      { route: 'notes', name: 'notes', moduleId: 'notes/notes', nav: true, title: 'notes' },
      { route: 'reminders', name: 'reminders', moduleId: 'reminders/reminders', nav: true, title: 'reminders' },
      
    ]);
  }
}


