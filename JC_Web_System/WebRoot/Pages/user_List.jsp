<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@ page import ="com.bean.SysUsers"%>
<%@ page import ="java.util.*"%>
<% SysUsers currentUser=(SysUsers)session.getAttribute("currentUser"); %>
<% List<SysUsers> usersList=(List<SysUsers>)session.getAttribute("usersList"); %>
    

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
</head>
<body>
<form name="userList" action="userList.action" method="post">
  <div class="panel admin-panel">
    <div class="panel-head">
    <strong class="icon-reorder"> 
    <a href="userList.action">刷新用户列表</a>
    
    </strong> 
    </div>
    <div class="padding border-bottom">
      <ul class="search" style="padding-left:10px;">
        <li style="float:left;"> <a class="button border-main icon-plus-square-o" 
        	href="userList!gotoAddUser.action"> 添加用户</a> </li>
        <div style="float:right;">
         	 用户类型
          <select name="s_isvouch" class="input" onchange="changesearch()"  style="width:100px; line-height:17px;display:inline-block">
            <option value="">选择</option>
            <option value="1">管理员</option>
            <option value="2">普通用户</option>
          </select>
          
          <input type="text" placeholder="输入姓名查询" name="keywords" class="input" style="width:150px; line-height:17px;display:inline-block" />
          <a href="javascript:void(0)" class="button border-main icon-search" onclick="changesearch()" > 
          	搜索</a></li>
          </div>
      </ul>
    </div>
    <table class="table table-hover text-center">
      <tr>
        <th>
        	用户ID</th>
        <th>登录名</th>
        <th>姓名</th>
        <th>手机号</th>
        <th>电子邮箱</th>
        <th>用户类型</th>
        <th>操作</th>
      </tr>
     <%for(SysUsers user:usersList){ %>
        <tr>
          <td style="text-align:left; padding-left:20px;">
          <input type="checkbox" name="id[]" value="" />
          <%=user.getUserId()%>
          </td>
          <td><%=user.getUserLoginName() %></td>
          <td><font color="#00CC99"><%=user.getUserName()%></font></td>
          <td><%=user.getUserPhoneNum()%></td>
          <td><%=user.getUserEmail()%></td>
          <td><%=user.getUserType()==0?"管理员":"用户"%></td>
          <td><div class="button-group"> 
          <a class="button border-main" href="userList!gotoAddUser.action">
          <span class="icon-edit"></span>
          修改</a>
          <a class="button border-red" href="javascript:void(0)" onclick="return del(1,1,1)">
          <span class="icon-trash-o"></span> 
          删除</a> </div></td>
        </tr>
   		<%} %>
        
      <tr>
        <td style="text-align:left; padding:19px 0;padding-left:20px;"><input type="checkbox" id="checkall"/>
          全选 </td>
        <td colspan="7" style="text-align:left;padding-left:20px;">
        <a href="javascript:void(0)" class="button border-red icon-trash-o" style="padding:5px 15px;" onclick="DelSelect()">批量删除</a> 
        
         </td>
      </tr>
      <tr>
        <td colspan="8"><div class="pagelist"> <a href="">上一页</a> <span class="current">1</span><a href="">2</a><a href="">3</a><a href="">下一页</a><a href="">尾页</a> </div></td>
      </tr>
    </table>
  </div>
</form>
<script type="text/javascript">

//搜索
function changesearch(){	
		
}

//单个删除
function del(id,mid,iscid){
	if(confirm("您确定要删除吗?")){
		
	}
}

//全选
$("#checkall").click(function(){ 
  $("input[name='id[]']").each(function(){
	  if (this.checked) {
		  this.checked = false;
	  }
	  else {
		  this.checked = true;
	  }
  });
})

//批量删除
function DelSelect(){
	var Checkbox=false;
	 $("input[name='id[]']").each(function(){
	  if (this.checked==true) {		
		Checkbox=true;	
	  }
	});
	if (Checkbox){
		var t=confirm("您确认要删除选中的内容吗？");
		if (t==false) return false;		
		$("#listform").submit();		
	}
	else{
		alert("请选择您要删除的内容!");
		return false;
	}
}
</script>
</body>
</html>