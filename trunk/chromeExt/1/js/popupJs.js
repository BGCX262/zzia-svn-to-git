$(function(){
	$('input:button').click(function(){
		var vText = $('#tarea').val();
		alert(vText);

		chrome.extension.sendRequest({greeting: "hello"}, function(response) {
			alert("��Ӧ��Ϣ:"+response);
			console.log(response.farewell);
		});
	});
});