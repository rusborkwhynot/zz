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
    
    <title>课程首页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/displayusers.css">

  </head>
  
  <body>
     <br>
     <div><a href="addUser.jsp"><button style="width:100px;height:30px;background-color:#dddddd;color:aaaaaa; font-size:16px;font-weight:bold">添加课程</button></a></div>
     <br>
     
     <div>
     <table id="customers" height="228" align="center" cellspacing="0" cellpadding="0">
    <tr>
    <th>课程id</th>
    <th>课程名</th>
    <th>课程密码</th>
    <th>获取方式</th>
    <th>课程分类</th>
    <th>支付方式</th>
    <th>删除操作</th>
    <th>修改操作</th>
    <th>查看详情</th>
    </tr>
    <%
    DBoper db=new DBoper();
     ArrayList<User> list=db.QueryallusersAL();
     Iterator<User> it=list.iterator();
     while(it.hasNext())
     {
       User user=it.next(); 
    %>
    <tr>
    <td><%=user.getId() %></td>
    <td><%=user.getSubname() %></td>
    <td><%=user.getSubpwd() %></td>
    <td><%=user.getOnoffline() %></td>
    <td><%=user.getSubclassification() %></td>
    <td><%=user.getSubpayment() %></td>
    <td><a href="userDel.jsp?id=<%=user.getId()%>">删除</a></td>
    <td><a href="<%=basePath%>userUpdate.jsp?id=<%=user.getId()%>">修改</a></td>
    <td><a href="<%=basePath%>userDetail.jsp?id=<%=user.getId()%>">查看详情</a></td>
    </tr>
    <%
     }
     %>
    </table>
     
     </div>
  </body>
</html>
