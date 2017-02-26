<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import ="com.bean.SysUsers"%>
<% SysUsers currentUser=(SysUsers)session.getAttribute("currentUser"); %>
<% SysUsers editUser=(SysUsers)session.getAttribute("editUser"); %>


<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="<%=basePath%>/Pages/common/css/pintuer.css">
<link rel="stylesheet" href="<%=basePath%>/Pages/common/css/admin.css">
<script src="<%=basePath%>/Pages/common/js/jquery.js"></script>
<script src="<%=basePath%>/Pages/common/js/pintuer.js"></script>

<script>
$(document).ready(function(){
　　$("#selector").val("<%=editUser!=null?editUser.getUserType():-1 %>");
}); 
</script>

</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o">
  </span><%=editUser!=null?"编辑用户":"新增用户" %></strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="">  
        <div class="form-group">
        
       	<div style="width:100%">
          <div class="label" style="float:left">
            <label>用户类型：</label>
          </div>
           <div class="field" style="float:left;width:400px">
            <%-- <s:select list="#{-1:'请选择',0:'管理员',1:'用户'}" listKey="key" 
            listValue="value" value="<%=editUser!=null?editUser.getUserId():-1 %>" /> --%>
            <select name="cid" id="selector" class="input w50">
              <option value="-1" >--请选择--</option>
              <option value="0" >管理员</option>
              <option value="1" >用户</option>
            </select>
            
          </div>
        </div>
        
        
          <div class="label">
            <label>登录名：</label>
          </div>
          <div class="field" >
          <input type="text" class="input w50" value="<%=editUser!=null?editUser.getUserLoginName():"" %>" name="title" data-validate="required:请输入登录名" />
          <div class="tips"></div>
        </div>
          <div class="label">
            <label>登录密码：</label>
          </div>
          <div class="field">
          <input type="password" class="input w50" value="<%=editUser!=null?editUser.getUserPwd():"" %>" name="title" data-validate="required:请输入登录密码" />
          <div class="tips"></div>
          </div>
          <div class="label">
            <label>重复密码：</label>
          </div>
          <div class="field">
          <input type="password" class="input w50" value="" name="title" data-validate="required:重复密码" />
          <div class="tips"></div>
          </div>
          
          <div class="label">
            <label>姓名：</label>
          </div>
          <div class="field">
          <input type="text" class="input w50" value="<%=editUser!=null?editUser.getUserName():"" %>" name="title" data-validate="required:输入姓名" />
          <div class="tips"></div>
          </div>
          
          <div class="label">
            <label>手机号：</label>
          </div>
          <div class="field">
          <input type="text" class="input w50" value="<%=editUser!=null?editUser.getUserPhoneNum():"" %>" name="title" data-validate="required:输入手机号" />
          <div class="tips"></div>
          </div>
          
          
          <div class="label">
            <label>电子邮箱：</label>
          </div>
          <div class="field">
          <input type="text" class="input w50" value="<%=editUser!=null?editUser.getUserEmail():"" %>" name="title" data-validate="required:输入电子邮箱" />
          <div class="tips"></div>
          </div>
          
        </div>
       <% if(editUser!=null){ %>
       		<a class="button border-main icon-plus-square-o" href="userList!EditUser.action"> 
        		保存修改</a>
       <%}else{ %>
     		<a class="button border-main icon-plus-square-o" href="userList!AddUser.action"> 
        		添加用户</a>
       <%} %>
      
    </form>
  </div>
</div>

</body></html>