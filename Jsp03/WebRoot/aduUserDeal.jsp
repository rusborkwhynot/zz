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
    
    <title>添加信息</title>
    
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
     request.setCharacterEncoding("UTF-8");
     response.setCharacterEncoding("UTF-8");
     
     String subname=request.getParameter("subname");
     String subpwd=request.getParameter("subpwd");
     String onoffline=request.getParameter("onoffline");
     String subclassification=request.getParameter("subclassification");
     String []payment=request.getParameterValues("subpayment");
     String payments="";
     for(String i: payment)
     {
       payments=payments+i;
     }
     
    User user=new User();
    user.setSubname(subname);
    user.setSubpwd(subpwd);
    user.setOnoffline(onoffline);
    user.setSubclassification(subclassification);
    user.setSubpayment(payments);
    
    DBoper db=new DBoper();
    int i=db.Adduser(user);
    if(i!=0)
    {
      out.println("课程添加成功！");
    }
    else
       {
      out.println("课程添加失败！");
    }
   
    
    
    
    
     %>
  </body>
</html>
