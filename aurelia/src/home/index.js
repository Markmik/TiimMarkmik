
export class Home {
	}


var modal = document.getElementById('id01_signup');
var modal2 = document.getElementById('id02_login');


// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    } else if (event.target == modal2){
		modal2.style.display = "none";
	}

}