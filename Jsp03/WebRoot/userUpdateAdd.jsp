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
    
    <title>修改信息</title>
    
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
     out.println("ok");
     
     String subname=request.getParameter("subname");
     out.println(subname);
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
    int id=Integer.parseInt(request.getParameter("id"));
    DBoper db=new DBoper();
    int i=db.UpdatUser(user,id);
    if(i!=0)
    {
       out.println("<script language=javascript>alert('修改成功！');window.location.href='userDisplay.jsp';</script>");
    }
    else
       {
       out.println("<script language=javascript>alert('修改失败！');window.location.href='userDisplay.jsp';</script>");
    }
   
    
    
    
    
     %>
  </body>
</html>
