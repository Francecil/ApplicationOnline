$(document).ready(function() {
	htmlobj = "";
	$.ajax({
		type: "get",
		url: "news-showRootLanmu.action",
		async: false,
		success: function(data) {
			//from 0
			var navAppend="";
			$.each(data.children, function(i, item) {
				
				navAppend+="<li><a href='news-showArticleList.action?lmid="+item.id+"'>"+item.name+"</a>";
				var haveChild=false;
				$.each(item.children, function(i, citem) {
					haveChild=true;
					if(i==0)navAppend+="<ul>";
					navAppend+="<li><a href='news-showArticleList.action?lmid="+citem.id+"'>"+citem.name+"</a></li>";
				});
				if(haveChild){
					navAppend+="</ul>";
				}
				navAppend+="</li>";
			});
			$('#nav').append(navAppend);//最后再渲染
		},
	});
});

