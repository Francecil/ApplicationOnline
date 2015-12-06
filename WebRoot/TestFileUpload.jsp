<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>ajax文件上传</title>
    
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
    <meta http-equiv="expires" content="0">    
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <script type="text/javascript" src="<%=basePath%>js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/ajaxfileUpload.js" ></script>
    <script type="text/javascript">
    $(function(){
       //上传图片
       $("#btnUpload1").click(function() {
               ajaxFileUpload("upload1");
       });
       $("#btnUpload2").click(function() {
               ajaxFileUpload("upload2");
       });
    });
    function ajaxFileUpload(upname) {
        var elementIds=["flag"]; //flag为id、name属性名
        $.ajaxFileUpload({
            url: 'fileAction-upload.action', 
            type: 'post',
            secureuri: false, //一般设置为false
            fileElementId: upname, // 上传文件的id、name属性名
            dataType: 'json', //返回值类型，一般设置为json、application/json
            elementIds: elementIds, //传递参数到服务器
            success: function(data, status){  
                alert(data);
            },
            error: function(data, status, e){ 
                alert(e);
            }
        });
        //return false;
    }
    </script>
  </head>
  
  <body>
    <div id="wait_loading" style="padding: 50px 0 0 0;display:none;">
        <br></br>
        <div style="width: 103px;margin: 0 auto;"><span>请稍等...</span></div>
        <br></br>
    </div>
    <input type="text"/>
    <input type="file" id="upload1" name="upload"><br/>
    <input type="file" id="upload2" name="upload"><br/>
    <input type="hidden" id="flag" name="flag" value="ajax文件上传"/>
    <input type="button" id="btnUpload1" value="上传图片" />
    <input type="button" id="btnUpload2" value="上传pdf" />
  </body>
</html>