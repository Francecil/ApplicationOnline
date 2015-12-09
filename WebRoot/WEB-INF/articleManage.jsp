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


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link href="<%=basePath%>css/articleCURD.css" media="all"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="<%=basePath%>js/jquery-1.11.1.min.js"></script>
<script>
	function deleteArticle(id){
		$(document).ready(function(){
		if(!confirm('是否删除该文章?'))return;
	$.ajax({
		type: "post",
		url: 'admin-deleteArticle.action?articleId='+id,
		async: true,
		success: function(data) {
//			alert(data);
			alert("删除文章成功");
			var par="#art"+id;
			$(par).remove();
		},
		error:function(data){
			alert("删除文章失败");
		}
		});
  		});
	}
	
</script>
</head>

<body>
	<span class="title"><h1>文章管理</h1></span>
	<form id="step2form">
		<div class="formcontent" style="width:90%;">
			<div class="">
				<a target="_blank" href="admin-editArticle.action" style="float:right;line-height:30px;">NEW</a>
				<div class="article-content"
					style="clear:both;height:40px;line-height:40px;margin-top:30px;">
					<div class="article-title" style="border-right:1px solid #fff;">
						标题</div>
					<div class="article-lanmu" style="border-right:1px solid #fff;">
						所属栏目</div>
					<div class="article-author" style="border-right:1px solid #fff;">
						作者</div>
					<div class="article-publishtime"
						style="border-right:1px solid #fff;">发布时间</div>
					<div class="Operation">操作</div>
				</div>
				<div class="table">
					<ul class="article" id="article" style="font-size:12px;">
						<s:iterator value="articleDTOs" var="adetail">
							<li id="art<s:property value="#adetail.article.id"/>">
								<div class="article-title ed_item">
									<s:property value="#adetail.article.title" />
								</div>
								<div class="article-lanmu  ed_item">
									<s:property value="#adetail.lanmuName" />
								</div>
								<div class="article-author ed_item">
									<s:property value="#adetail.article.author" />
								</div>
								<div class="article-publishtime ed_item">
									<s:property value="#adetail.article.publishTime" />
								</div>
								<div class="Operation">
									<a class='edit_2 operation'  href="admin-editArticle.action?articleID=<s:property value="#adetail.article.id"/>">edit</a>
									<a class='delete_2 operation'
										onclick="deleteArticle(<s:property value="#adetail.article.id"/>)">delete</a>
								</div> <input name='detailID' type='hidden'
								value='<s:property value="#adetail.article.id"/>' />
							</li>
						</s:iterator>
					</ul>
				</div>
			</div>
		</div>
	</form>
</body>

</html>
