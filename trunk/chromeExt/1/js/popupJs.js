$(function(){
	$('input:button').click(function(){
		var vText = $('#tarea').val();
		alert(vText);

		chrome.extension.sendRequest({greeting: "hello"}, function(response) {
			alert("œÏ”¶–≈œ¢:"+response);
			console.log(response.farewell);
		});
	});
});