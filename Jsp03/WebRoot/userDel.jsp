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
    
    <title>删除信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <%
    int id=Integer.parseInt(request.getParameter("id"));
    DBoper db=new DBoper();
    int i=db.DeleteUser(id);
    if(i!=0)
    {
     out.println("<script language=javascript>alert('删除成功！');window.location.href='userDisplay.jsp';</script>");
    }
    else
    {
     
     out.println("<script language=javascript>alert('删除失败！');window.location.href='userDisplay.jsp';</script>");
    
    }
    %>
  </body>
</html>
