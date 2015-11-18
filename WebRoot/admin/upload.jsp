<%@ page language="java" contentType="text/html;charset=utf8"  isELIgnored="true" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<style type="text/css">
    *{margin:0;padding:0;}
    .selectList{width:200px;margin:50px auto;}
</style>
	<style type="text/css">@import url(<%=basePath%>plupload/js/jquery.plupload.queue/css/jquery.plupload.queue.css);</style>
<script src="<%=basePath%>js/jquery-1.11.1.min.js" type="text/javascript"></script> 
<script type="text/javascript" src="<%=basePath%>plupload/js/plupload.full.js"></script>
<script type="text/javascript" src="<%=basePath%>plupload/js/jquery.plupload.queue/jquery.plupload.queue.js"></script>
<script type="text/javascript" src="<%=basePath%>plupload/js/i18n/cn.js"></script>
<script type="text/javascript" src="<%=basePath%>js/select_topic.js"></script>
<script type="text/javascript" src="<%=basePath%>js/article_submit.js"></script>
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
	
	
</script>

</head>

<body>
	<div>
		<div style="width: 750px; margin: 0px auto">
			<form id="formId"  method="post">
				<div class="form-item textarea">
								<span>Article title:</span><input id="title" name="title" />
				</div>
				<div class="form-item textarea">
								<span>Article content:</span><textarea id="content"  name="content" rows="6" cols="60" ></textarea>
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
				<div id="uploader">
					<p>您的浏览器未安装 Flash, Silverlight, Gears, BrowserPlus 或者支持 HTML5 .</p>
				</div>
				<input id="formbtn" type="button" value="提交"/>(若有图片请先点击添加、开始上传按钮)
			</form>
		</div>
	</div>
</body>

</html>