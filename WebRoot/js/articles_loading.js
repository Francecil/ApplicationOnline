$(document).ready(function() {
	$.ajax({
		type: "get",
		url: "news-showDetailListByLanmuID.action?lmid=2",
		async: false,
		success: function(data) {
			//from 0
			var navAppend="";
			$.each(data, function(i, item) {
				
				navAppend+="<li style=\"width:330px;height:25px;line-height:25px;border-bottom: #ccc dashed 1px;\">"
						+"<span style=\"float:right;\">"+item.publishTime+"</span> <img src=\"./img/9k=.jpg\""
						+"width=\"10\" height=\"9\"> <a href=\"news-showArticleDetail.action?articleID="+item.id+"\">"+((item.title).length>25?((item.title).slice(0,22)+"..."):(item.title))+"</a></li>";
			});
			$('#articlesOne').append(navAppend);//最后再渲染
		},
	});
	$.ajax({
		type: "get",
		url: "news-showDetailListByLanmuID.action?lmid=3",
		async: false,
		success: function(data) {
			//from 0
			var navAppend="";
			$.each(data, function(i, item) {
				
				navAppend+="<li style=\"width:330px;height:25px;line-height:25px;border-bottom: #ccc dashed 1px;\">"
						+"<span style=\"float:right;\">"+item.publishTime+"</span> <img src=\"./img/9k=.jpg\""
						+"width=\"10\" height=\"9\"> <a href=\"news-showArticleDetail.action?articleID="+item.id+"\">"+((item.title).length>25?((item.title).slice(0,22)+"..."):(item.title))+"</a></li>";
			});
			$('#articlesTwo').append(navAppend);//最后再渲染
		},
	});
});

