<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<%
	//HttpSession s = request.getSession(); 
	//String userId=s.getAttribute("CURRENT_USER_ID").toString();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>后台管理中心</title>
<link rel="stylesheet"
	href="<%=basePath%>/Pages/common/css/pintuer.css">
<link rel="stylesheet" href="<%=basePath%>/Pages/common/css/admin.css">
<script src="<%=basePath%>/Pages/common/js/jquery.js"></script>
<script type="text/javascript">
$(function(){
  $(".leftnav h2").click(function(){
	  $(this).next().slideToggle(200);	
	  $(this).toggleClass("on"); 
  })
  $(".leftnav ul li a").click(function(){
	    $("#a_leader_txt").text($(this).text());
  		$(".leftnav ul li a").removeClass("on");
		$(this).addClass("on");
  })
});
</script>
</head>
<body style="background-color:#f2f9fd;">
	<div class="header bg-main">
		<div class="logo margin-big-left fadein-top">
			<h1>
				<img src="<%=basePath%>/Pages/common/images/y.jpg"
					class="radius-circle rotate-hover" height="50" alt="" />后台管理中心
			</h1>
		</div>
		<div class="head-l">
			<a class="button button-little bg-green" href="##"><span
				class="icon-power-off"></span> 退出登录</a>
		</div>
	</div>
	<div class="leftnav">
		<div class="leftnav-title">
			<strong><span class="icon-list"></span>操作台</strong>
		</div>
		<h2>
			<span class="icon-user"></span>用户管理
		</h2>
		<ul style="display:block">
			<li><a href="Pages/error.jsp" target="right"><span
					class="icon-caret-right"></span>系统用户管理</a></li>
			<li><a href="Pages/error.jsp" target="right"><span
					class="icon-caret-right"></span>权限管理</a>
			</li>
			
		</ul>

		<h2>
			<span class="icon-pencil-square-o"></span>案卷管理
		</h2>
		<ul style="display:block">
			<li><a href="Pages/error.jsp" target="right"><span
					class="icon-caret-right"></span>新建案卷</a></li>
			<li><a href="Pages/error.jsp" target="right"><span
					class="icon-caret-right"></span>历史案卷</a></li>
		</ul>
		<h2>
			<span class="icon-wrench"></span>系统管理
		</h2>
		<ul style="display:block">
			<li><a href="Pages/error.jsp" target="right"><span
					class="icon-caret-right"></span>查看系统运行数据</a></li>
			<li><a href="Pages/error.jsp" target="right"><span
					class="icon-caret-right"></span>关闭系统服务器</a></li>
		</ul>
		
	</div>
	<ul class="bread">
		<li><a href="Pages/error.jsp" target="right" class="icon-home"> 回到首页</a>
		</li>
	</ul>
	<div class="admin">
		<iframe scrolling="auto" rameborder="0" src="Pages/user_List.jsp" name="right"
			width="100%" height="100%"></iframe> 
			
	</div>
	<div style="text-align:center;">
		<p>
			来源:<a href="http://www.mycodes.net/" target="_blank">源码之家</a>
		</p>
	</div>
</body>
</html>
