<%@ page language="java" contentType="text/html;charset=utf8"
	isELIgnored="true" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<%@taglib uri="http://ckeditor.com" prefix="ckeditor"%>
<%@taglib uri="http://cksource.com/ckfinder" prefix="ckfinder"%>
<%@taglib uri="/struts-tags" prefix="s"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

.selectList {
	width: 200px;
	margin: 50px auto;
}
</style>
<script src="<%=basePath%>js/jquery-1.11.1.min.js"
	type="text/javascript"></script>
<script type="text/javascript" src="<%=basePath%>ckeditor/ckeditor.js"></script>
<script type="text/javascript"
	src="<%=basePath%>ckeditor/adapters/jquery.js"></script>
<script type="text/javascript" src="<%=basePath%>ckfinder/ckfinder.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
						$("#formBtn").click(function() {
							var one = $("#one");
           	 				var two =$("#two");
           	 				var three = $("#three");
											var editor_data = CKEDITOR.instances.content
													.getData();
											if (editor_data == null
													|| editor_data == "") {
												alert("数据为空不能提交");
											} else {
												if (!confirm("是否确认提交")) {
													return;
												}
											}
											var option;
											if(three.css('display')=="none"){
												if(two.css('display')=="none"){
													if(one.css('display')=="none"){
														option=1;
													}
													else option=one.val();
												}
												else{
												option=two.val();
												}
											}
											else{
												option=three.val();
											}
											$.ajax({
														type : "post",
														url : 'admin-articleSubmit.action',
														async : true,
														data : {
															"content" : editor_data,
															"title" : $(
																	"#title")
																	.val(),
															"lanmuid" : option
														},
														success : function(data) {
															if (confirm("保存成功,是否继续发表?")) {
																window.location = 'admin-editArticle.action';
															} else {
																window.location = 'admin-articleManage.action';
															}
														},
														error : function(data) {
															alert("保存失败");
														}
													});
										});
					});
</script>

<script type="text/javascript">
$(document).ready(function(){
        $(".selectList").each(function(){
//            var url = "/ApplicationOnline/json/area2.json";
        	var url="news-showRootLanmu.action";
            var areaJson;
            var temp_html;
            var oProvince = $(this).find(".province");
            var oCity = $(this).find(".city");
            var oDistrict = $(this).find(".district");
            var lanmuLen;
            var isChange = false;
            var lanmus=new Array();
            var province = function(){
                $.each(areaJson,function(i,province){
                    temp_html+="<option value='"+province.id+"'>"+province.name+"</option>";
                });
                oProvince.html(temp_html);
                var lanmuSplit="<s:property value="lanmuSplit"/>";
                lanmus=lanmuSplit.split("|");
                var lanmuID="<s:property value="editArticle.topicID"/>";
				//alert(lanmuID);
				lanmuLen=lanmus.length;
				if(!isChange){
                if(lanmuLen>1)
				$("#one").val(lanmus[1]);
				}
				
                city();
            };
            var city = function(){
                temp_html = ""; 
                var n = oProvince.get(0).selectedIndex;
                if((areaJson[n].children).length==0){
                    oCity.css("display","none");
                }else{
                 oCity.css("display","inline");
                 $.each(areaJson[n].children,function(i,city){
                    temp_html+="<option value='"+city.id+"'>"+city.name+"</option>";
                });
                oCity.html(temp_html);
                };
                if(!isChange){
                if(lanmuLen>2)
				$("#two").val(lanmus[2]);
				}
                district();
            };
            var district = function(){
                temp_html = ""; 
                var m = oProvince.get(0).selectedIndex;
                var n = oCity.get(0).selectedIndex;
                if(typeof(areaJson[m].children[n]) == "undefined"||(areaJson[m].children[n].children).length==0||typeof(areaJson[m].children[n].children) == "undefined"){
                    oDistrict.css("display","none");
                }else{
                    oDistrict.css("display","inline");
                    $.each(areaJson[m].children[n].children,function(i,district){
                        temp_html+="<option value='"+district.id+"'>"+district.name+"</option>";
                    });
                    oDistrict.html(temp_html);
                };
                if(!isChange){
                isChange=true;
                if(lanmuLen>3)
				$("#three").val(lanmus[3]);
				}
            };
            oProvince.change(function(){
                city();
            });
            oCity.change(function(){
                district();
            });
            $.getJSON(url,function(data){
                areaJson = data.children;
                province();
            });
        });
});
</script>
</head>

<body>
	<div>
		<div style="width: 750px; margin: 0px auto">
			<form name="myform" id="myform" method="post">
				<div class="form-item textarea">
					<span>新闻标题</span><input id="title"
						value="<s:property value="editArticle.title"/>" name="title" />
				</div>
				<ckfinder:setupCKEditor editor="content" basePath="ckfinder/" />
				<textarea class="ckeditor" cols="80" id="content" name="content"
					rows="10">     
         			<s:property value='editArticle.content' />
         			</textarea>
         			<ckeditor:replace replace="content" basePath="ckeditor/" />  
				<div class="selectList">
					选择一个栏目<select id="one" name="one" class="province">
						<option value="-1">请选择</option>
					</select> <select id="two" name="two" class="city">
						<option value="-1">请选择</option>
					</select> <select id="three" name="three" class="district">
						<option value="-1">请选择</option>
					</select>
				</div>
				<input type="button" id="formBtn" value="发表文章" />
			</form>
		</div>
	</div>
</body>

</html>
