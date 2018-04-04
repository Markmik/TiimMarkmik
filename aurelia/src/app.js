export class App {
  configureRouter(config, router) {
    this.router = router;
    config.title = 'StudyHub';
    config.map([
      { route: ['', 'home'],       name: 'home',       moduleId: 'home/home', nav: true },
      { route: 'welcome',            name: 'welcome',      moduleId: 'welcome/welcome', nav: true, title: 'welcome' },
      
    ]);
  }
}

var modal = document.getElementById('id01');
var modal2 = document.getElementById('id02');
var modal3 = document.getElementById('id03');
var modal4 = document.getElementById('id04');

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    } else if (event.target == modal2){
		modal2.style.display = "none";
	} else if (event.target == modal3){
		modal3.style.display = "none";
	} else if (event.target == modal3){
		modal4.style.display = "none";
	}

}
