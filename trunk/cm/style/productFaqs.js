/*!
 * Copyright 2012, cm
 * Released under the GPL Licenses.
 */
;(function($,window,undefined){
var productName;//当前产品名称
var productId,$productTitle,$productContent,$selector,$hideContent;
var qid;
$(function(){
	//TODO 测试使用,正式上线要删除下面一行
	$(".livcms_cell").remove();
	$productTitle=$("div.faqs_title");
	$productContent=$("div.faqs_content_main2 > div:first");
	$productTitle.empty();//清除标题
	$productContent.empty();//清除FAQ内容区
	var params=location.search.toString();
	try{
		if(params != undefined && params.length>0){
			parseParams(params);
			productId=$("body").data('pid');
			productName=$("body").data('pname');
			qid=$("body").data('qid');
			getProductFaqs(productId);
		}else{
			getProductFaqs(1);
		}
	}catch(e){getProductFaqs(1);}
});
$(function(){
	var qa = new QA();
	var $main = $("div.faqs_content_main2");
	var $H3 = $main.find('span.h3');
	$main.delegate(".h3",'mouseenter',function(e){
		$selector=$(this).parent('div.text').nextAll('div.text:eq(0)');
		qa.init($selector).show();
	}).delegate('.h3,div:has(.h4)','mouseleave click',function(e){
		qa.hide();
	}).delegate('div:has(.h4)','mouseenter',function(e){
		$main.find('div:has(.h4)').stop();
	})
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
//根据名称名称和页码,获取产品对应的FAQ
function getProductFaqs(productId){
	//	var scriptsrc = document.createElement("script");
	//	var SSOscriptsrc="http://www.sh.10086.cn/dportal/tpq_qalist.do?method=getAllQaInfoByPid&PRODUCTID="+productId;
	//	scriptsrc.src = SSOscriptsrc;
	//	document.body.appendChild(scriptsrc);
	$.ajax({
		url:"http://www.sh.10086.cn/dportal/tpq.do",
		data:"method=getAllQaInfoByPid&PRODUCTID="+productId,
		dataType:"jsonp",
		jsonpCallback:"callBackSupport",
		success: function(retVal){
			parseProductFaqsJson(retVal);
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
//	 parseProductFaqsJson(retVal);//解析返回的数据
//}
//解析FAQ
function parseProductFaqsJson(retJson){
	$productTitle.empty();//清除标题
	$productContent.empty();//清除FAQ内容区
	var $mainContectArray = [];//存放QA
 	var qaList =$.parseJSON(retJson.replace(/'/g,"\""));
	if(typeof qaList != undefined){
		$productTitle.html(productName);//设置标题
		for(var i = 0;i<qaList.resultData.length;i++){
				var qa = qaList.resultData[i];	//一个QA
				var question = qa.question;//问s
				var faqid=qa.faqid;//QAID
				var title=qa.title;//QA标题
				var an_brief = qa.an_brief;//答简介
				$mainContectArray.push(question+"|"+faqid+"|"+title+"|"+an_brief);
		}
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
	for(var i =0;i<mainVal.length;i++){
		var a = mainVal[i].split("|");
		//	 问 	qaID  QA标题 QA答简介
		var b=a[0],c=a[1],d=a[2],e=a[3];
		var url='./FaqMoreInfo.html?qid='+c+'&pname='+productName;
		var $ques,$answ,$more;
$more = $('<span/>').css('float','right').append($('<a/>',{'target':'_blank','href':url,'text':'查看详情>>'}));
$ques = $('<div/>').addClass('text').append($('<span/>',{'text':'问 : '+b}).addClass('h3').css({cursor:"pointer"}));
$answ = $('<div/>',{'id':c}).css('display','none').addClass('text').append($('<span/>',{'text':'答 : '})
				.addClass('h4')).append($('<span/>',{'text':e})).append($more);
		var tmp="<div class='text'><span class='h3' style='cursor:pointer'>问 : "+b+"</span></div>"+
			"<div class='text' id='"+c+"' style='display: none;'><span class='h4'>答 : </span><span>"+e+"</span><span style='float:right;'><a target='_blank' href='"+url+"'>查看详情&gt;&gt;</a></span></div><br/>";
		//$productContent.append(tmp);
		$productContent.append($ques).append($answ).append('<br/>');
	}
	//根据URL中的指定的值展开指定的QA项
	if(qid!=undefined){
		$('#'+qid).show();
	}
}
var QA = function(){
	this.count = 1,//定时记数
	this.v_time = {},//定时器
	this.$this = {};//选择器
	QA.prototype.init = function($selector){
		count = 1;
		$this = $selector;
		return this;
	};
	QA.prototype.show = function(){
		v_time = setInterval(function(){
			if(count++ === 3){
				$this.slideDown('500');
			}
		},100);
	};
	QA.prototype.hide = function(){
		clearInterval(v_time);
		$this.slideUp('500').init($this);
	};
}})(jQuery,window);