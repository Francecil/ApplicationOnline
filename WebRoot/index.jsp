<%@ page language="java" contentType="text/html;charset=utf8"
	isELIgnored="true" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="Generator" content="EditPlusÂ®">
<meta name="Author" content="">
<meta name="Keywords" content="">
<meta name="Description" content="">
<title>Application for admission</title>
<link href="css/menustyle.css" media="all" rel="stylesheet"
	type="text/css">
<link href="css/all.css" rel="stylesheet" type="text/css" media="all" />
<script src="js/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="js/articles_loading.js"></script>
</head>
<body>
	<s:include value="/header.html"></s:include>
	<div class="content">
		<div class="channeltopimg"
			style="text-align:center;background: #EAEAEA;overflow: hidden;">
			<div class="img_background"
				style="background:#EAEAEA;border:3px ;solid:#000; margin-top:20px;">
				<img src="./img/pic.jpg" class="img1" width="970px" height="235px"
					border="0">
			</div>
		</div>
	</div>
	<div class="content_2"
		style="clear:both;height:260px;overflow: hidden;min-width:980px;margin:0 aotu;position: relative;">
		<div class="column"
			style="width:978px;min-height:253px;margin-left:auto;margin-right:auto;">
			<div class="column_1"
				style="width:351px;height:253px;float:left;margin-top:11px;background:url(./img/b4.jpg) repeat;">
				<a href="" id="lanmu1" style="font-weight:bold;color:#a42517;margin-left: 12px;margin-top:11px;line-height: 30px;">XXX_1</a>
				<ul id="articlesOne" style="width:330px;height:200px;margin-left:12px;">


				</ul>
			</div>
			<div class="column_2"
				style="width:347px;height:253px;float:left;margin-top:11px;margin-left:5px;background:url(./img/b4.jpg) repeat;">
				<a href="" id="lanmu2" style="font-weight:bold;color:#a42517;margin-left: 12px;margin-top:11px;line-height: 30px;">XXX_2</a>
				<ul id="articlesTwo" style="width:330px;height:200px;margin-left:12px;">
				</ul>
			</div>

			<div class="column_3" align="middle"
				style="width:269px;height:253px;float:left;margin-top:11px;margin-left:5px;background:url(./img/b3.jpg) repeat;">

				<b>Contact Information</b> <br> <br> <b>Oversea
					Students &amp; Scholars</b>: Mr.Zhao <br> Contact Number: <b>+86
					591 22865239</b> <br> <br> <b>Studying Abroad</b>: Ms.Deng <br>
				Contact Number: <b>+86 591 22865239</b> <br> <br> <b>International
					School</b>: Ms.Chen <br> Contact Number: <b>+86 591 22865029</b>
			</div>
			<div style="clear:both;"></div>
		</div>
	</div>

	<div
		style="width:980px; height:89px; background:#a42517;margin-top:100px;margin-left:auto;margin-right:auto;clear:both;">

		<div class="footer"
			style="width: 940px; height: 60px;   margin:0 auto; padding:0 20px; text-align: center;   font-size: 12px;  color: #FFF; line-height: 30px; clear:both; ">
			Copyright © 2011 Fuzhou University. <br> Office of Cooperation
			and Exchange <br> <a href="Mailto : faomail@fzu.edu.cn">
				faomail@fzu.edu.cn</a>
		</div>
	</div>
</body>
</html>
