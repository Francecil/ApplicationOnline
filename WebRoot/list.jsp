<%@ page language="java" contentType="text/html;charset=utf8" import="com.france.bean.Lanmu" isELIgnored="true" pageEncoding="UTF-8"%>
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
  <title>list</title>
  <link href="<%=basePath%>css/menustyle.css" media="all" rel="stylesheet" type="text/css">
  <link href="<%=basePath%>css/all.css" rel="stylesheet" type="text/css" media="all" />
  <link href="<%=basePath%>css/jPages.css" rel="stylesheet" type="text/css" />
    <!--[if IE 7]><link href="css/ie7.css" rel="stylesheet" type="text/css" media="all" />
<![endif]-->
    <!--[if IE 6]><link href="css/ie6.css" rel="stylesheet" type="text/css" media="all" />
<![endif]-->
    <script src="<%=basePath%>js/jquery.min.js" type="text/javascript"></script>
  <script type="text/javascript" src="<%=basePath%>js/jquery-1.8.2.min.js"></script>
	<script src="<%=basePath%>js/jPages.js"></script>
    <script src="<%=basePath%>js/site.js" type="text/javascript"></script>
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
  </style>
 </head>
 <body>
	<s:include value="/header.html"></s:include>
	<div id="content">
		
		<div id="lf_cont" style="float:left;">
		<div style="background:url(<%=basePath%>img/bg3-top.gif) no-repeat top;height:10px;width:100%;"></div>
			<ul class="menu">
				<li class="selected"><a href="news-showArticleList.action?lmid=<s:property value="currentLanmu.id"/>"><s:property value="currentLanmu.name"/></a>
                  <ul>
                  <s:iterator value="currentLanmu.children" var="child">
                  	<li><a href="news-showArticleList.action?lmid=<s:property value="#child.id"/>"><s:property value="#child.name"/></a></li>
                  </s:iterator>
                  </ul>
                </li>
                <s:iterator value="brotherLanmu" >
                  	<li><a href="news-showArticleList.action?lmid=<s:property value="id"/>"><s:property value="name"/></a></li>
                 </s:iterator>
			</ul>
			<div style="background:url(<%=basePath%>img/bg3-bottom.gif) no-repeat bottom;height:10px;width:100%;"></div>
		</div>
		<div id="ri_cont">
			<div class="pic1">
				<img src="<%=basePath%>img/pic1.jpg"/>
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
				<div class="title" style="font-size:16px;font-weight:bold;line-height:30px;margin:5px 20px;color:#333;"><s:property value="currentLanmu.name"/></div>
				<ul id="itemContainer">
					<s:iterator value="articleList">
					<li><a href="news-showArticleDetail.action?articleID=<s:property value="id"/>"><s:property value="title"/></a><span><s:property value="publishTime"/></span></li>
					</s:iterator>
					<!-- 展示分页效果需要 -->
					<!-- 
					<li><a href="">Studying costs in Fuzhou University</a><span>2015/11/14</span></li>
					<li><a href="">Measures of Annual Review of Chinese Government Scholarship Status</a><span>2015/11/14</span></li>
					<li><a href="">3</a><span>2015/11/14</span></li>
					<li><a href="">4</a><span>2015/11/14</span></li>
					<li><a href="">5</a><span>2015/11/14</span></li>
					<li><a href="">6</a><span>2015/11/14</span></li>
					<li><a href="">7</a><span>2015/11/14</span></li>
					<li><a href="">8</a><span>2015/11/14</span></li>
					<li><a href="">9</a><span>2015/11/14</span></li>
					<li><a href="">10</a><span>2015/11/14</span></li>
					<li><a href="">11</a><span>2015/11/14</span></li>
					<li><a href="">12</a><span>2015/11/14</span></li>
					<li><a href="">13</a><span>2015/11/14</span></li>
					<li><a href="">4</a><span>2015/11/14</span></li>
					<li><a href="">5</a><span>2015/11/14</span></li>
					<li><a href="">6</a><span>2015/11/14</span></li>
					<li><a href="">7</a><span>2015/11/14</span></li>
					<li><a href="">8</a><span>2015/11/14</span></li>
					<li><a href="">9</a><span>2015/11/14</span></li>
					<li><a href="">10</a><span>2015/11/14</span></li>
					<li><a href="">11</a><span>2015/11/14</span></li>
					<li><a href="">12</a><span>2015/11/14</span></li>
					<li><a href="">13</a><span>2015/11/14</span></li>
					<li><a href="">4</a><span>2015/11/14</span></li>
					<li><a href="">5</a><span>2015/11/14</span></li>
					<li><a href="">6</a><span>2015/11/14</span></li>
					<li><a href="">7</a><span>2015/11/14</span></li>
					<li><a href="">8</a><span>2015/11/14</span></li>
					<li><a href="">9</a><span>2015/11/14</span></li>
					<li><a href="">10</a><span>2015/11/14</span></li>
					<li><a href="">11</a><span>2015/11/14</span></li>
					<li><a href="">12</a><span>2015/11/14</span></li>
					<li><a href="">13</a><span>2015/11/14</span></li>
					<li><a href="">4</a><span>2015/11/14</span></li>
					<li><a href="">5</a><span>2015/11/14</span></li>
					<li><a href="">6</a><span>2015/11/14</span></li>
					<li><a href="">7</a><span>2015/11/14</span></li>
					<li><a href="">8</a><span>2015/11/14</span></li>
					<li><a href="">9</a><span>2015/11/14</span></li>
					<li><a href="">10</a><span>2015/11/14</span></li>
					<li><a href="">11</a><span>2015/11/14</span></li>
					<li><a href="">12</a><span>2015/11/14</span></li>
					<li><a href="">13</a><span>2015/11/14</span></li>
					<li><a href="">4</a><span>2015/11/14</span></li>
					<li><a href="">5</a><span>2015/11/14</span></li>
					<li><a href="">6</a><span>2015/11/14</span></li>
					<li><a href="">7</a><span>2015/11/14</span></li>
					<li><a href="">8</a><span>2015/11/14</span></li>
					<li><a href="">9</a><span>2015/11/14</span></li>
					<li><a href="">10</a><span>2015/11/14</span></li>
					<li><a href="">11</a><span>2015/11/14</span></li>
					<li><a href="">12</a><span>2015/11/14</span></li>
					<li><a href="">13</a><span>2015/11/14</span></li>
					<li><a href="">4</a><span>2015/11/14</span></li>
					<li><a href="">5</a><span>2015/11/14</span></li>
					<li><a href="">6</a><span>2015/11/14</span></li>
					<li><a href="">7</a><span>2015/11/14</span></li>
					<li><a href="">8</a><span>2015/11/14</span></li>
					<li><a href="">9</a><span>2015/11/14</span></li>
					<li><a href="">10</a><span>2015/11/14</span></li>
					<li><a href="">11</a><span>2015/11/14</span></li>
					<li><a href="">12</a><span>2015/11/14</span></li>
					<li><a href="">13</a><span>2015/11/14</span></li>
					<li><a href="">4</a><span>2015/11/14</span></li>
					<li><a href="">5</a><span>2015/11/14</span></li>
					<li><a href="">6</a><span>2015/11/14</span></li>
					<li><a href="">7</a><span>2015/11/14</span></li>
					<li><a href="">8</a><span>2015/11/14</span></li>
					<li><a href="">9</a><span>2015/11/14</span></li>
					<li><a href="">10</a><span>2015/11/14</span></li>
					<li><a href="">11</a><span>2015/11/14</span></li>
					<li><a href="">12</a><span>2015/11/14</span></li>
					<li><a href="">13</a><span>2015/11/14</span></li>
					<li><a href="">4</a><span>2015/11/14</span></li>
					<li><a href="">5</a><span>2015/11/14</span></li>
					<li><a href="">6</a><span>2015/11/14</span></li>
					<li><a href="">7</a><span>2015/11/14</span></li>
					<li><a href="">8</a><span>2015/11/14</span></li>
					<li><a href="">9</a><span>2015/11/14</span></li>
					<li><a href="">10</a><span>2015/11/14</span></li>
					<li><a href="">11</a><span>2015/11/14</span></li>
					<li><a href="">12</a><span>2015/11/14</span></li>
					<li><a href="">13</a><span>2015/11/14</span></li>
					 -->
				</ul>
				<div class="holder"></div>
			</div>
		</div>
		<div style="clear:both;margin-bottom:30px;"></div>
	</div>
	<s:include value="/footer.html"></s:include>
 </body>
</html>
