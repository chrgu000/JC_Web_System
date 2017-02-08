<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>用户登录</title>

<link rel="stylesheet" type="text/css"
	href="./Pages/css/style_login.css">
</head>

<body class="login" mycollectionplug="bind">
	<form name="userLogin" action="userLogin.action" method="post">
	<div class="login_m">
		<blockquote>
			<div class="login_logo">
				<img height="46" width="196" src="./Pages/pic/logo.png">
			</div>
		</blockquote>
		<div class="login_boder">

			<div class="login_padding" id="login_model">

				<h2>用户名</h2>
				<label> <input type="text" name="username"
					class="txt_input"
					onfocus="if (this.value =='输入账号'){value =''}"
					onblur="if (value ==''){value='输入账号'}" value="输入账号"> </label>
				<h2>密码</h2>
				<label> <input type="password" name="password" 
					class="txt_input"
					onfocus="if (value =='******'){value =''}"
					onblur="if (value ==''){value='******'}" value="******"> </label> <br>
				<br>

				<div class="rem_sub">

					<a  href="./Pages/regist.jsp"><input type="button" class="reg_button" value="注册"></a> 
						<input type="submit"
						class="sub_button"  value="登录">
				</div>
				</form>
</body>
</html>