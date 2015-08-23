/*
注入到页面
*/
$(function(){
	var imgSrc=chrome.extension.getURL('images/btn.gif');
	console.log(imgSrc);
	$('<div/>',{'id':'myDiv'})//
	.append($('<input/>',{'type':'button','value':'Run'}))//
	.prependTo($('body'))//
	.append($("<textarea/>",{'id':'myTextarea'}).keydown(function (e) {
		  if (e.ctrlKey && e.keyCode == 13) {//当Ctrl+Enter键一起按的时候执行输入的命令
			$('#myDiv').find('input').trigger('click');
		  }
		})
	);
	$('#myDiv').delegate('input','click',function(){
		var areaText = $('#myTextarea').val();
		if(areaText.length!=0)
			eval("("+areaText+")");
	});
});
chrome.extension.onRequest.addListener(
	function(request, sender, sendResponse) {
		console.log(sender.tab ?
					"from a content script:" + sender.tab.url :
					"from the extension");
		if (request.greeting == "hello")
			sendResponse({farewell: "goodbye"});
		else
			sendResponse({farewell:"how are you?"}); // snub them.
	}
);