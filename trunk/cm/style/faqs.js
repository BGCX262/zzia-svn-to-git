/*!
 * Copyright 2012, cm
 * Released under the GPL Licenses.
 */
;(function($,window){
var tabsName="优惠业务";//当前标签组名称
var totalpage=0;//总页数
var productId;//产品ID
var $mainContent;//暂时存放普通内容区
var $hotContent;//暂时存放热点内容区
var _mainContent,_hotContent;
var leftContent,rightContent,productName;
$(function(){
	_mainContent=$("#faqs_content_main1"),_hotContent=$("#faqs_content_right1");
	//$mainContent=$("#faqs_content_main1"),$hotContent=$("#faqs_content_right1");
	tabsName = getFaq("优惠业务");
	$('#proName').html();
	$("#tableNames").find("input:radio").bind('click',function(){
		if($(this).next().text()!=tabsName){//当切换标签的时候,重新取热点区内容
			//TODO
		}
		tabsName = $(this).next().text();
		$("#tableName").text(tabsName);
		getFaq(tabsName);
	});
});
//根据标签组名称和页码,获取FAQ
function getFaq(tabsName){
	/*
	var scriptsrc = document.createElement("script");
	var SSOscriptsrc="http://www.sh.10086.cn/dportal/tpq.do?method=getTabProductQAInfoAll&tabsName="+tabsName+"&nowPage=1";
	scriptsrc.src = SSOscriptsrc;
	document.body.appendChild(scriptsrc);
	*/
	
	$.ajax({
		url:"http://www.sh.10086.cn/dportal/tpq.do",
		data:"method=getTabProductQAInfoAll&tabsName="+tabsName+"&nowPage=1",
		dataType:"jsonp",
		jsonpCallback:"callBackSupport",//回调函数名称
		success: function(retVal){
			//TODO  把请求的结果放到cookies中,
			parseFaq(retVal);//解析
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
/*
//回调
function callBackSupport(retVal){
	 parseFaq(retVal);//解析
}
*/
var $line="<div id='line' style='margin:20px 0px 20px 0px; background:#dfdfdf; height:1px;overflow:hidden;'></div>";
//解析FAQ
function parseFaq(retJson){
	leftContent=[],rightContent=[];
	$mainContent='',$hotContent='';
 	var str = eval("("+retJson+")");
	if(typeof str.resultData !='undefined'){
		totalpage = str.totalpage;
		if(totalpage<1){//没有记录
			allNoContent();
		}
		for(var i = 0;i<str.resultData.length;i++){
			var singleProduct = str.resultData[i];//获取一个产品
			var productId = singleProduct.proId;//产品ID
			var $proName = singleProduct.proName;//产品名称
			var url='./productFaqList.html?pid='+productId+'&pname='+encodeURIComponent($proName);
			var DomProductName="<div style='overflow:hidden; margin:10px 0px 10px 0px;'>"+
			"<div class='h2' id='proName'>"+$proName+"</div><div class='more'><a target='_blank'"+
			" href='"+url+"'>更多&gt;&gt;</a></div></div>";
			productName = DomProductName;
			var proQaLength=singleProduct.qaBean.length;
			if(proQaLength>0){
				var singleQABean = singleProduct.qaBean[1];	//获取一个QA
				var faqId=singleQABean.faqid;//QAid
				var news_type =singleQABean.news_type;//推荐类型 2 为热点类型
				var question = singleQABean.question;
				if(rightContent.length<2&&news_type=='2'){//右侧内容区只显示2个QA
					rightContent.push([productName,[question,faqId]]);
				}else{
					leftContent.push([productName,[question,faqId]]);
				}
			}
		}
		addMainContent(leftContent);
	}else{//无记录
		allNoContent();
	}
}
//增加右侧QA
function addHotContent(hotVal){
	//var $hotContent = $("#faqs_content_right1");//热点内容区
	for(var i =0;i<hotVal.length;i++){
		var $tmp = hotVal[i];
		var $cssClass=i%2?'h4':'h3';//问题与答案样式
		var $qa=i%2?'答 : ':'问 : ';
		if($tmp){
			if(i%2){//问
				$hotContent.append("<div class='text'><span class="+$cssClass+">"+$qa+$tmp+"</span></div>");
			}else{//答
				$hotContent.append("<div class='text'><span class="+$cssClass+">"+$qa+"</span>"+$tmp+"</div>");
			}
		}
	}
}
//增加左侧QA
function addMainContent(mainVal){
	var proName,question,qid;//proName,leftQA,QA_ID
	//[[proName,[qa,qid]],[proName,[qa,qid]]]
	for(var i =0;i<mainVal.length;i++){//只输出一个问题
		proName=mainVal[i][0];//产品名称
		var qaAndId=mainVal[i][1];
		question=qaAndId[0];
		qid=qaAndId[1];
		$mainContent+=proName;
		$mainContent+="<div class='text'><span class='h3' id='"+qid+"'>问 : "+question+"</span></div>";
	}
	_mainContent.empty().append($mainContent);
}
//没有数据返回的处理
function allNoContent(){
	_mainContent.empty().append("<div class='text'><span class='h4'>暂时没有记录</span></div>");
	_hotContent.empty().append("<div class='text'><span class='h4'>暂时没有记录</span></div>");
}
function leftNoContent(){
	_mainContent.empty().append("<div class='text'><span class='h4'>暂时没有记录</span></div>");
}
function rightNoContent(){
	_hotContent.empty().append("<div class='text'><span class='h4'>暂时没有记录</span></div>");
}})(jQuery,window);