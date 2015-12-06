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
       
<<<<<<< HEAD
=======
<script type="text/javascript">
// Convert divs to queue widgets when the DOM is ready
	$(function() {
		$("#uploader").pluploadQueue({
			// General settings
			//strid:$('input[name=mstrid]').val(),
			runtimes : 'gears,flash,silverlight,browserplus,html5,html4',
			url : 'admin-upload.action',
			max_file_size : '10mb',
			unique_names : true,
			chunk_size: '2mb',
			// Specify what files to browse for
			filters : [
{title : "Image files", extensions : "jpg,gif,png"}
			],
	
			// Flash settings	
			flash_swf_url : '<%=basePath%>plupload/js/plupload.flash.swf',
			// Silverlight settings
			silverlight_xap_url : '<%=basePath%>plupload/js/plupload.silverlight.xap'
		});
	});

			function test() {
				//JavaScript判空，如果确定
				var editor_data = CKEDITOR.instances.content.getData();
				if(editor_data==null||editor_data==""){
					alert("数据为空不能提交");
				}else{
					if(confirm(editor_data)){
					document.myform.submit();
					}
				}		
			}
		
	
</script>
>>>>>>> branch 'master' of ssh://git@github.com/Francecil/ApplicationOnline.git

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
<<<<<<< HEAD
			
=======
			<form action="doTest.jsp" name="myform" method="post">
		      <ckfinder:setupCKEditor editor="content" basePath="ckfinder/" />   
		      <ckeditor:editor basePath="ckeditor/"    
		            editor="content" value="CKEditor Test......(此处的内容会在编辑器中显示)--by jCuckoo " />   
		      <input type="button" onclick="test()" value="提交数据"/>
	       </form>
>>>>>>> branch 'master' of ssh://git@github.com/Francecil/ApplicationOnline.git
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
