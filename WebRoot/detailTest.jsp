<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head>  
    <title>��ȡ���ݵ����� -- by jCuckoo</title>  
    <%request.setCharacterEncoding("gbk");
    String sb="<script type='text/javascript'>alert('I am an alert box!!')</script>";
     %>
     <%=sb %>  
  </head>  
  <body>  
      
    <%=request.getParameter("content")+sb %>  
  </body>  
</html>  