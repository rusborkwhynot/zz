<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="DB.*,Bean.*"  %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>课程总览</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body style="background-color:#eeeeee;">
  <% 
  int id=Integer.parseInt(request.getParameter("id")); 
  DBoper db=new DBoper(); 
  User user=db.Queryoneuser(id);   
  %>
  课程id：<%=user.getId() %> &nbsp;&nbsp;&nbsp;&nbsp;课程名：<%=user.getSubname() %>&nbsp;&nbsp;&nbsp;&nbsp;用户密码：<%=user.getSubpwd() %>
  <br> <br> 
 获取方式：<%=user.getOnoffline() %> &nbsp;&nbsp;&nbsp; 课程分类：<%=user.getSubclassification() %> &nbsp;&nbsp;&nbsp; 支付方式： <%=user.getSubpayment() %>
 <br> <br> 
  
  </body>
</html>
