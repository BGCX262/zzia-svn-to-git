/*!
 * Copyright 2012, cm
 * Released under the GPL Licenses.
 */
;(function($,window,undefined){
var proName,question,an_brief,answer,title,faqid;
var $productTitle,$productContent;
$(function(){
	//TODO 测试使用,正式上线要删除下面一行
	$(".livcms_cell").remove();
	$productTitle=$("div.faqs_title");
	$productContent=$("div.faqs_content_main2 > div:first");
	var params=location.search.toString();
	try{
		if(params != undefined && params.length>0){
			parseParams(params);
			faqid=$("body").data('qid');
			proName=$("body").data('pname');
			getFaqsMoreInfo(faqid);
		}else{
		}
	}catch(e){};
});
//解析URL参数,以键/值对的形式放入到缓存中.
function parseParams(params){
	var reallyArgs=params.substring(1);
	var allParams=reallyArgs.split("&");
	for(var i =0;i<allParams.length;i++){
		var tmp=allParams[i].split("=");
		$("body").data(tmp[0],decodeURIComponent(tmp[1]));
	}
}
//获取FAQ详情信息
function getFaqsMoreInfo(faqid){
	//	var scriptsrc = document.createElement("script");
	//	var SSOscriptsrc="http://www.sh.10086.cn/dportal/tpq_qalist.do?method=getQaInfoById&QAID="+faqid;
	//	scriptsrc.src = SSOscriptsrc;
	//	document.body.appendChild(scriptsrc);
	$.ajax({
		url:"http://www.sh.10086.cn/dportal/tpq.do",
		data:"method=getQaInfoById&QAID="+faqid,
		dataType:"jsonp",
		jsonpCallback:"callBackSupport",
		success: function(retVal){
			parseFaqsJson(retVal);
		},
		error:function(XMLHttpRequest, textStatus, errorThrown){
			try{
				console.log(textStatus);
				console.log(errorThrown);
			}catch(e){};
			location.reload();
		}
	});
}
//回调
//function callBackSupport(retVal){
//	 parseFaqsJson(retVal);//解析返回的数据
//}
//解析
function parseFaqsJson(retJson){
	$productTitle.empty();//清除标题
	$productContent.empty();//清除FAQ内容区
	var $mainContectArray = [];//存放QA
 	var $qa =$.parseJSON(retJson.replace(/'/g,"\""));// eval("("+retJson+")");
	if(typeof $qa !='undefined'){
		$("div.faqs_title").html(proName);//设置标题
		var $qaBean = $qa.resultData;	//获取一个QA
		title=$qaBean.title;
		question = $qaBean.question;//问题
		an_brief = $qaBean.an_brief;//答案简介
		$mainContectArray.push(question,an_brief,title);
		if($mainContectArray.length>0){
			addMainContent($mainContectArray);
		}else{
			$productContent.append("<div class='text'><span class='h4'>暂时没有记录</span></div>");
		}
	}else{//为空
		$productContent.append("<div class='text'><span class='h4'>暂时没有记录</span></div>");
	}
}
//增加FAQS
function addMainContent(mainVal){
	var a=mainVal[0],b=mainVal[1],c=mainVal[2];
	$productContent.append("<div class='text'><span title='"+c+"' class='h3'>问 : "+a+"</span></div>");
	$productContent.append("<br/>");
	$productContent.append("<div class='text'><span class='h4'>答 : </span>"+b+"</div>");

}})(jQuery,window);