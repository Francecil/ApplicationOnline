<%@ page language="java" contentType="text/html;charset=utf8"  isELIgnored="true" pageEncoding="UTF-8"%>
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
  <title>Application for admission</title>
  <link href="css/menustyle.css" media="all" rel="stylesheet" type="text/css">
   <link href="css/all.css" rel="stylesheet" type="text/css" media="all" />
    <script src="js/jquery.min.js" type="text/javascript"></script>
  <script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
</head>
 <body>
	<s:include value="/header.html"></s:include>
	<div class="content">
		<div class="channeltopimg" style="text-align:center;background: #f3f3f3;overflow: hidden;">
			<img src="./img/fzu.jpg" class="img1" style="width:100%;height:auto;">
		</div>
	</div>
 </body>
</html>
