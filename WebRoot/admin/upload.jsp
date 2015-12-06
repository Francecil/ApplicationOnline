<%@ page language="java" contentType="text/html;charset=utf8"  isELIgnored="true" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@taglib uri="http://ckeditor.com" prefix="ckeditor"%>
<%@taglib uri="http://cksource.com/ckfinder" prefix="ckfinder"%>
<%@taglib uri="/struts-tags" prefix="s" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<style type="text/css">
    *{margin:0;padding:0;}
    .selectList{width:200px;margin:50px auto;}
</style>
<script src="<%=basePath%>js/jquery-1.11.1.min.js" type="text/javascript"></script> 
<script type="text/javascript" src="<%=basePath%>js/select_topic.js"></script>
<script type="text/javascript" src="<%=basePath%>js/article_submit.js"></script>
<script type="text/javascript" src="<%=basePath%>ckeditor/ckeditor.js"></script>
 <script type="text/javascript" src="<%=basePath%>ckeditor/adapters/jquery.js"></script>
 <script type="text/javascript" src="<%=basePath%>ckfinder/ckfinder.js"></script>
       

</head>

<body>
	<div>
		<div style="width: 750px; margin: 0px auto">
		<form action="<%=basePath%>detailTest.jsp" name="myform" method="post">
		      <ckfinder:setupCKEditor editor="content" basePath="ckfinder/" />   
		      <ckeditor:editor basePath="ckeditor/"    
		            editor="content"  />   
		      <input type="submit"  value="提交数据"/>
	       </form>
			<form id="formId"  method="post">
				<div class="form-item textarea">
								<span>Article title:</span><input id="title" name="title" />
				</div>
				<div class="form-item textarea">
			
				</div>
		<div class="selectList">
		Select Topic
        <select id="one" name="one"class="province">
            <option value="-1">Please</option>
        </select>
        <select id ="tow" name="tow"class="city">
            <option value="-1">Please</option>
        </select>
        <select id="three" name="three" class="district">
            <option value="-1">Please</option>
        </select>
    </div>
				<input id="formbtn" type="button" value="提交"/>
			</form>
		</div>
	</div>
</body>

</html>