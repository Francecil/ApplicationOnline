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
  <title>Admin list</title>
  <link href="css/application.css" media="all" rel="stylesheet" type="text/css">
 </head>
	<body>
		<div class="header">
			<h1>Online Application System</h1>
			<div class="rightTop">
			<div>welcome,<span id="user"> <s:property value="#session.User.uname"/></span></div>
			<div style="line-height:50px;"><a href="./"><<-back</a></div>
			</div>
		</div>
		<div class="content">
			<div class="rightcontent" style="margin:0 auto;float:none;">
				<div class="selected tab">
					<span class="title">
						<h1>
							<ul class="item">
								<li class="Applicant">Applicant</li>
								<li class="Application-content">Application content</li>
								<li class="Application-date">Date of application</li>
								<li class="View">View</li>
							</ul>
						</h1>
					</span>
					<ul class="adminlist">
					<s:iterator value="allApplications" var="base">
					<s:set name="basic" value="#base.basicInfoApplication"></s:set>
						<li>
							<span class="Applicant"><s:property value="#basic.name"/></span>
							<span class="Application-content"><s:property value="#basic.applicationType"/></span>
							<span class="Application-date"><s:property value="applyTime"/></span>
							<span class="View"><a href="view.action?aid=<s:property value="#base.applyId" />" style="float:right;">view</a></span>
							<input type="button" class="btn"  onclick="window.open('edit.action?aid=<s:property value="#base.applyId"/>')" value="edit" style="float:right;"/>
						</li>
					</s:iterator>
						<div class="clear"></div>
					</ul>
				</div>
			</div>
		</div>
 </body>
</html>
