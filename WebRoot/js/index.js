var canvas = document.createElement("canvas");
var cxt = canvas.getContext('2d');
document.onreadystatechange = function(){
	if(document.readyState == 'complete'){
		canvas.width = document.body.offsetWidth;
		canvas.height = document.body.offsetHeight;
		document.addEventListener("onresize", function(e) {
			canvas.width = document.body.offsetWidth;
			canvas.height = document.body.offsetHeight;
		})
		drawAll();
	}
}
/**
 * 绘制一片星空
 */
function drawAll(){
	cxt.fillStyle = 'black';
	cxt.fillRect(0, 0, canvas.width, canvas.height);
	for (var i = 0; i <= 300; i++) {
		var fiveStart = {};
		fiveStart.bigRadius = Math.random() * 6 + 6;
		fiveStart.smallRadius = fiveStart.bigRadius / 2.0;
		fiveStart.offsetX = Math.random() * canvas.width;
		fiveStart.offsetY = Math.random() * canvas.height;
		fiveStart.RotationAngle = Math.random() * 360;
		drawFiveStar(cxt, fiveStart);
	}
	document.body.style.backgroundImage = 'url("'+canvas.toDataURL("image/png")+'")';
	setTimeout(drawAll,100);
//	requestAnimationFrame(drawAll)
}

/**
 * 绘制五角星的方法
 */
function drawFiveStar(cxt, fiveStart) {
	cxt.beginPath();
	var x = 0,
		y = 0;
	for (var i = 0; i < 5; i++) {
		x = Math.cos((18 + 72 * i - fiveStart.RotationAngle) / 180 * Math.PI);
		x = x * fiveStart.bigRadius + fiveStart.offsetX;
		y = -Math.sin((18 + 72 * i - fiveStart.RotationAngle) / 180 * Math.PI);
		y = y * fiveStart.bigRadius + fiveStart.offsetY;
		cxt.lineTo(x, y);
		x = Math.cos((54 + i * 72 - fiveStart.RotationAngle) / 180 * Math.PI);
		x = x * fiveStart.smallRadius + fiveStart.offsetX;
		y = -Math.sin((54 + i * 72 - fiveStart.RotationAngle) / 180 * Math.PI);
		y = y * fiveStart.smallRadius + fiveStart.offsetY;
		cxt.lineTo(x, y);
	}
	cxt.closePath();
	cxt.lineWidth = 3;
	cxt.strokeStyle = "#FD5";
	cxt.fillStyle = 'yellow';
	cxt.lineJoin = "round";
	cxt.fill();
	cxt.stroke();
}