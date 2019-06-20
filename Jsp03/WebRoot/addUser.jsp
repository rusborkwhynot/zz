<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/displayusers.css">
    <base href="<%=basePath%>">
    
    <title>添加课程</title>
    
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
   <form action="aduUserDeal.jsp" method="post">
   <div style="width:400px;height:500px;margin-left:100px;margin-top:100px;">
   <table style="font-color:#000055;">
    <tr>
    <td > 课程名：</td>
    <td><input type="text" name="subname"></td>
   </tr>  
   <tr>
   <td>&nbsp;</td>
   <td></td>
   </tr>
   <tr>
    <td> 密码：</td>
    <td><input type="password" name="subpwd"></td>
   </tr>
   <tr>
   <td>&nbsp;</td>
   <td></td>
   </tr>
   <tr>
    <td> 获取方式：</td>
    <td> 线上 <input type="radio" name="onoffline" value="on">   线下 <input type="radio" name="onoffline" value="off"></td>
   </tr>
    <tr>
   <td>&nbsp;</td>
   <td></td>
   </tr>
    <tr>
    <td> 课程类：</td>
    <td>
    <select name="subclassification">
    <option value="古典音乐">古典音乐</option>
    <option value="流行音乐">流行音乐</option>
    <option value="民族音乐">民族音乐</option>
    </select>
    </td>
   </tr>
    <tr>
   <td>&nbsp;</td>
   <td></td>
   </tr>
    <tr>
    <td> 支付方式：</td>
    <td> 支付宝 <input type="checkbox" name="subpayment" value="支付宝">   微信 <input type="checkbox" name="subpayment"value="微信"> 银联 <input type="checkbox" name="subpayment" value="银联"> 金卡 <input type="checkbox" name="subpayment" value="金卡">  </td>
   </tr>
<tr>
   <td>&nbsp;</td>
   <td></td>
   </tr>
     <tr>
    <td> </td>
    <td><button type="submit">提交注册</button>   <button type="reset">重置</button> </td>
   </tr>
   </table>
  </div>
  
     
   </form>
  </body>
</html>

