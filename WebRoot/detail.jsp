<%@ page language="java" contentType="text/html;charset=utf8"  import="com.france.bean.Lanmu"  isELIgnored="true" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!doctype html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <meta name="Generator" content="EditPlusÂ®">
  <meta name="Author" content="">
  <meta name="Keywords" content="">
  <meta name="Description" content="">
  <title><s:property value="detaileArticle.title"/></title>
  <link href="css/menustyle.css" media="all" rel="stylesheet" type="text/css">
  <link href="css/all.css" rel="stylesheet" type="text/css" media="all" />
  <link href="css/jPages.css" rel="stylesheet" type="text/css" />
    <!--[if IE 7]><link href="css/ie7.css" rel="stylesheet" type="text/css" media="all" />
<![endif]-->
    <!--[if IE 6]><link href="css/ie6.css" rel="stylesheet" type="text/css" media="all" />
<![endif]-->
    <script src="js/jquery.min.js" type="text/javascript"></script>
  <script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
	<script src="js/jPages.js"></script>
    <script src="js/site.js" type="text/javascript"></script>
	 <script>
  /* when document is ready */

    $(function(){

  $("div.holder").jPages({
    containerID : "itemContainer" 
  });


   });
  </script>
<style type="text/css">
.holder {
    margin:15px 0;
}
.holder a {
    font-size:12px;
    cursor:pointer;
    margin:0 5px;
    color:#333;
}
.holder a:hover {
    background-color:#222;
    color:#fff;
}
.holder a.jp-previous {
    margin-right:15px;
}
.holder a.jp-next {
    margin-left:15px;
}
.holder a.jp-current,a.jp-current:hover {
    color:#FF4242;
    font-weight:bold;
}
.holder a.jp-disabled,a.jp-disabled:hover {
    color:#bbb;
}
.holder a.jp-current,a.jp-current:hover,.holder a.jp-disabled,a.jp-disabled:hover {
    cursor:default;
    background:none;
}
.holder span {
    margin: 0 5px;
}
.photo-show img{
	display: block;
	margin: 0 auto;
	margin-bottom: 35px;
	width: 702px;
	height: 465px;
}
  </style>
 </head>
 <body>
	<s:include value="/header.html"></s:include>

	<div id="content">
		
		
		<div id="cont">
			<div class="pic1">
				<img src="./img/pic1.jpg" style="width:100%;height:100%;"/>
			</div>
			<div class="list" style="margin-top:10px;">
				<div style="color:#666;font-size:14px;line-height:30px;border-bottom:1px solid #ccc;">
				Current Position:
				<%
				String currentPosition = "";
				Lanmu currentLanmu = (Lanmu)request.getAttribute("currentLanmu");
				currentPosition+="<a href='news-showArticleList.action?lmid="+currentLanmu.getId()+"'>"+currentLanmu.getName()+"</a>";
				Lanmu lanmuTemp=currentLanmu.getParentLanmu();
				while(lanmuTemp!=null){
					currentPosition="<a href='news-showArticleList.action?lmid="+lanmuTemp.getId()+"'>"+lanmuTemp.getName()+"</a>|"+currentPosition;
					lanmuTemp=lanmuTemp.getParentLanmu();
				}
				if(currentLanmu.getParentLanmu()!=null)
				%>
				<%=currentPosition%>
				</div>
			</div>
			<div class="detail_cont">
				<h3><s:property value="detaileArticle.title"/></h3>
				<h1>
					<span>Information Source:</span><s:property value="detaileArticle.author"/> <span>Release Date: </span><s:property value="detaileArticle.publishTime"/><span>View Count: </span>0
				</h1>
				<div class="detail_cont_display">
					<s:property value="detaileArticle.content"/>
				</div>
				<div class="photo-show">
					<s:iterator value="detaileArticle.photos">
						<img alt="" src="resources/files/<s:property value="savename"/>" />
					</s:iterator>

				</div>
			</div>
		</div>
		<div style="clear:both;margin-bottom:30px;"></div>
	</div>
	
	<s:include value="/footer.html"></s:include>
 </body>
</html>
