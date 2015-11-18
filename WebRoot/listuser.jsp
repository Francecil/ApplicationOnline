<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="/struts-tags" prefix="s" %>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <meta name="Generator" content="EditPlusÂ®">
  <meta name="Author" content="">
  <meta name="Keywords" content="">
  <meta name="Description" content="">
  <title>Document</title>
  <link href="<%=basePath%>css/application.css" media="all" rel="stylesheet" type="text/css">
 </head>
	<body>
		<div class="header">
			<h1>Online Application System</h1>
			<div class="rightTop">
			<div>welcome,<span id="user"><s:property value="#session.User.uname"/></span></div>
			<div style="line-height:50px;"><a href="./"><<-back</a></div>
			</div>
		</div>
		<div class="content">
			<div class="rightcontent" style="margin:0 auto;float:none;">
				<div class="selected tab">
					<span class="title">
						<h1>Not Submitted<a href="step.jsp" class="add">NEW</a></h1>
					</span>
					<ul class="unfinished list">
						<s:iterator value="noSubmitList" var="base">
						<s:set name="basic" value="#base.basicInfoApplication"></s:set>
						<li>Username:<s:property value="#basic.name"/>——Type:<s:property value="#basic.applicationType"/><input type="button" class="btn"  onclick="window.open('edit.action?aid=<s:property value="#base.applyId"/>')" value="edit" style="float:right;"/></li>
						</s:iterator>
					</ul>
				</div>
				<div class="selected tab">
					<span class="title">
						<h1>Submitted</h1>
					</span>
					<ul class="finished list">
						<s:iterator value="submitList" var="base">
						<s:set name="basic" value="#base.basicInfoApplication"></s:set>
						<li>Username:<s:property value="#basic.name"/>——Type:<s:property value="#basic.applicationType"/><input type="button" class="btn"  onclick="window.open('view.action?aid=<s:property value="#base.applyId"/>')" value="view" style="float:right;"/></li>
						</s:iterator>
					</ul>
				</div>
			</div>
		</div>
 </body>
</html>
