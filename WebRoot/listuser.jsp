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
  <link href="<%=basePath%>css/application2.css" media="all" rel="stylesheet" type="text/css">
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
				<div class="NotSubmitted tab" style="width:100%;min-height:100px; height:auto;display:block;float:left;">
					<span class="title">
						<h1>Not Submitted<a href="step.jsp" class="add">NEW</a></h1>
					</span>
				    
				    
				    
					<div style="width: 100%;min-height:100px; height:auto;margin:0 auto;">
					<div class="education-title" style="clear:both;height:40px;line-height:40px;margin-left:170px;margin-top:30px;width:70%; ">
										<div class="userlist_name" style="width:28.5%;border-right:1.5px solid #ccc;  ">Name</div>
										<div class="userlist_nationality" style="width:21.3%;border-right:1.5px solid #ccc;  ">Nationality</div>
										<div class="userlist_type" style="width:35.6%;border-right:1.5px solid #ccc;">Type</div>
										<div class="userlist_operation" style="width:14%;">Operation</div>	
					</div>
					<ul class="unfinishedname list" style="width: 20%;min-height:100px; height:auto;margin-left: 170px; float:left;">
					<s:iterator value="noSubmitList" var="base">
					<s:set name="basic" value="#base.basicInfoApplication"></s:set>
					<li  style="height:31px;border-left:1.5px solid #ccc; border-right:1.5px solid #ccc;border-bottom:1.5px solid #ccc; text-align:center;"><s:property value="#basic.name"/> </li>
					</s:iterator>
					</ul>
				
					
					<ul class="unfinishednationality list"  style="width: 15%;min-height:100px; height:auto;margin-left: 0px;float:left;">
					<s:iterator value="noSubmitList" var="base">
					<s:set name="basic" value="#base.basicInfoApplication"></s:set>
				       <li  style="  height:31px;border-bottom:1.5px solid #ccc; border-right:1.5px solid #ccc;  text-align:center;">	<s:property value="#basic.nationality"/></li>
				    </s:iterator>
					</ul>
				
					
					<ul class="unfinishedtype list" style="width:25%;min-height:100px; height:auto;margin-left:0px;float:left;">
					<s:iterator value="noSubmitList" var="base">
					<s:set name="basic" value="#base.basicInfoApplication"></s:set>
				        <li  style="height:31px;border-bottom:1.5px solid #ccc; border-right:1.5px solid #ccc;   text-align:center;" ><s:property value="#basic.applicationType"/></li>
				        </s:iterator>
					</ul>
					
				
					<ul class="unfinishededit list " style="width:10%;min-height:100px; height:auto;margin-left:0px;float:left;">
					<s:iterator value="noSubmitList" var="base">
					<s:set name="basic" value="#base.basicInfoApplication"></s:set>
					<li  style="height:31px;border-bottom:1.5px solid #ccc; border-right:1.5px solid #ccc;   text-align:center;"><a class=' operation' style="    margin-left: 50px;" href='edit.action?aid=<s:property value="#base.applyId"/>'target=_blank>edit</a></li>
			     	</s:iterator>
					</ul>
						</div>
				</div>
				<div class="Submitted tab" style="width:100%;min-height:100px; height:auto;display:block;float:left;">
					<span class="title">
						<h1>Submitted</h1>
					</span>
						<div style="width: 100%;min-height:100px; height:auto;margin:0 auto;">
					<div class="education-title" style="clear:both;height:40px;line-height:40px;margin-left:170px;margin-top:30px;width:70%; ">
										<div class="userlist_name" style="width:28.5%;border-right:1.5px solid #ccc;  ">Name</div>
										<div class="userlist_nationality" style="width:21.3%;border-right:1.5px solid #ccc;  ">Nationality</div>
										<div class="userlist_type" style="width:35.6%;border-right:1.5px solid #ccc;">Type</div>
										<div class="userlist_operation" style="width:14%;">Operation</div>	
					</div>
					<ul class="finishedname list" style="width: 20%;min-height:100px; height:auto;margin-left: 170px; float:left;">
					<s:iterator value="submitList" var="base">
					<s:set name="basic" value="#base.basicInfoApplication"></s:set>
					<li  style="height:31px;border-left:1.5px solid #ccc; border-right:1.5px solid #ccc;border-bottom:1.5px solid #ccc;   text-align:center;"><s:property value="#basic.name"/> </li>
					</s:iterator>
					</ul>
				
					
					<ul class="finishednationality list"  style="width: 15%;min-height:100px; height:auto;margin-left: 0px;float:left;">
					<s:iterator value="SubmitList" var="base">
					<s:set name="basic" value="#base.basicInfoApplication"></s:set>
				       <li  style=" height:31px;border-bottom:1.5px solid #ccc; border-right:1.5px solid #ccc;     text-align:center;">	<s:property value="#basic.nationality"/></li>
				    </s:iterator>
					</ul>
				
					
					<ul class="finishedtype list" style="width:25%;min-height:100px; height:auto;margin-left:0px;float:left;">
					<s:iterator value="SubmitList" var="base">
					<s:set name="basic" value="#base.basicInfoApplication"></s:set>
				        <li  style="   height:31px;border-bottom:1.5px solid #ccc; border-right:1.5px solid #ccc;   text-align:center;" ><s:property value="#basic.applicationType"/></li>
				        </s:iterator>
					</ul>
					
				
					<ul class="finishedeview list " style="width:10%;min-height:100px; height:auto;margin-left:0px;float:left;">
					<s:iterator value="SubmitList" var="base">
					<s:set name="basic" value="#base.basicInfoApplication"></s:set>
					<li  style="height:31px;border-bottom:1.5px solid #ccc; border-right:1.5px solid #ccc;   text-align:center;"><a class=' operation' style="    margin-left: 50px;" href='view.action?aid=<s:property value="#base.applyId"/>'target=_blank>view</a></li>
					
			     	</s:iterator>
					</ul>
						</div>
				</div>
				
			
					
			
				</div>
				
			</div>
		</div>
 </body>
</html>