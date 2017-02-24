
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="com.bean.SysUsers"%>
<%@ page import="com.bean.PageBean"%>
<%@ page import="java.util.*"%>
<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="<%=basePath%>/Pages/common/css/user.css">

</head>
<body>
	<form name="userList" action="userList.action" method="post">
		<div class="admin">
			<div class="panel-head">djfksjkdf
				
			</div>
		
		</div>
	</form>
</body>
</html>