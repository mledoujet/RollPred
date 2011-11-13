
$(document).ready(function() {

	/*
	 * VARIABLES GLOBALES
	 */
	//status de panel lateral: 1 ON (default), 0 OFF
	var leftstatus = 1;
	var lefttoggler = $("#lefttoggler");
	var leftlateral = $("#leftlateral");
	var leftlateralWidth = leftlateral.width() + "px";

	var rightstatus = 1;
	var righttoggler = $("#righttoggler");
	var rightlateral = $("#rightlateral");
	var rightlateralWidth = rightlateral.width() + "px";

	var content = $("#content");
	var windowHeight = 0;
	var renderHeight = 0;
	var togglerHeight = 0;
	var windowWidth = 0;
	var renderWidth = 0;
	var togglerWidth = 0;

	/*
	 * au chargement de la page, on adapte les dimensions
	 */
	calculateDimensions();
	applyDimensions();

	/*
	 * au redminisionnement de la page
	 */
	$(window).resize(function() {
		calculateDimensions();
		applyDimensions();
	});

	/*
	 * clique sur un toggler.
	 */
	lefttoggler.click(clicklefttoggler);
	righttoggler.click(clickrighttoggler);

	/*
	 * Controles des elements d'interface.
	 */
	// calcul des dimensions disponibles.
	function calculateDimensions() {
		windowHeight = document.documentElement.clientHeight; //hauteur disponible dans le browser
		renderHeight = (windowHeight - 51 - 25 - 31) + "px";
		togglerHeight = (windowHeight - 51 - 25 - 31) + "px";
		/*
		 * 51: #top: 40px de height, 10px de padding-top, y 1px de border-bottom
		 * 40: #content h2: 40px de height
		 * 31: #footer: 30px de height y 1px de border-top
		 */
	}
	// application des dimensions disponibles
	function applyDimensions() {
		content.css("height", renderHeight);
		lefttoggler.css("height", togglerHeight);
		righttoggler.css("height", togglerHeight);
		leftlateral.css("height", togglerHeight);
		rightlateral.css("height", togglerHeight);
	}

	// toggler gauche
	function clicklefttoggler() {
		//on cache le panneau si affiché
		if (leftstatus == 1) {
			leftlateral.hide();
			content.css("margin-left", "0px");
			lefttoggler.addClass("off");
			leftstatus = 0;
		}
		//on l'affiche s'il est caché
		else {
			leftlateral.show();
			content.css("margin-left", leftlateralWidth);
			lefttoggler.removeClass("off");
			leftstatus = 1;
		}
	}

	//toggler droit
	function clickrighttoggler() {
		//on cache le panneau si affiché
		if (rightstatus == 1) {
			rightlateral.hide();
			content.css("margin-right", "0px");
			righttoggler.addClass("off");
			rightstatus = 0;
		}
		//on l'affiche s'il est caché
		else {
			rightlateral.show();
			content.css("margin-right", rightlateralWidth);
			righttoggler.removeClass("off");
			rightstatus = 1;
		}
		windowWidth = document.documentElement.clientWidth; //largeur disponible dans le browser
		footerWidth = document.getElementById("footer").width
		//alert("windowWidth : "+windowWidth+"\n footerWidth:" +footerWidth)
		renderWidth = (windowWidth - 140 - 200) + "px";
	}

});