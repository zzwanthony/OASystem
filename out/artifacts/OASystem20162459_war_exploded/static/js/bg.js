function randomRange(start, end) {
	return Math.floor(Math.random() * (end - start + 1)) + start;
}
$(function(){
	$("body").css({"background": "url('../static/img/" + randomRange(1,17) + ".jpg') no-repeat","backgroundSize":"100% 100%"});
	setInterval(function(){$("body").css({"background": "url('../static/img/" + randomRange(1,17) + ".jpg') no-repeat","backgroundSize":"100% 100%","transition":"background 1s"})}, 3000);
});