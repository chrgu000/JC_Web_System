<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>Pages/common/themes/gray/easyui.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>Pages/common/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>Pages/common/css/admin.css">
<script type="text/javascript" charset="gb2312"
	src="<%=basePath%>Pages/common/js/jquery.min.js"></script>
<script type="text/javascript" 
	src="<%=basePath%>Pages/common/js/jquery.easyui.min.js"></script>
<script type="text/javascript" 
	src="<%=basePath%>Pages/common/js/easyui-lang-zh_CN.js"></script>
	
<%--<script type="text/javascript">
$(function(){
$('#dg').datagrid({  
    border:false,  
    fitColumns:true,  
    rownumbers:true,
    singleSelect: true,  
    url:'user!updateUserList.action',  
    columns:[[  
        {field:'userId',title:'userId',width:10%},  
        {field:'userLoginName',title:'userLoginName',width:10%},
        {field:'userName',title:'userName',width:20%},
        {field:'userPhoneNum',title:'userPhoneNum',width:20%},
        {field:'userEmail',title:'userEmail',width:20%},
        {field:'userType',title:'userType',width:10%},
        {field:'opt',title:'操作',width:10%,align:'center',  
            formatter:function(value,rec){
                var btn = '<a class="editcls" onclick="editRow(\''+rec.projectname+'\',\''+rec.projectpackage+'\')" href="javascript:void(0)">编辑</a>';  
                return btn;  
            }  
        }  
    ]],  
    onLoadSuccess:function(data){  
        $('.editcls').linkbutton({text:'编辑',plain:true,iconCls:'icon-edit'});  
    }  
}); 
});
</script>
  --%>
  <script type="text/javascript">
  function formatOper(val,row,index){  
	    
	    var str='<a style="text-decoration:none;border-style:solid;border-color:#BFEFFF; " href="javascript:void(0)" onclick="editUser('+index+')">修改</a>';  
	    str=str+'&nbsp;'+'<a style="text-decoration:none;border-style:solid;border-color:#FFE7BA; " href="javascript:void(0)" onclick="editUser('+index+')">删除</a>';
	    return str;
  } 
  </script>
  </head>
  
  <body>
 	<h2>用户列表页面</h2>
	<div style="margin:20px 0;">
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="addUser()">添加新用户</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="getSelected()">GetSelected</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="getSelections()">GetSelections</a>
	</div>
	<table id="dg" class="easyui-datagrid" style="width:100%;height:80%;"
		data-options="singleSelect:true,url:'user!updateUserList.action',rownumbers:true,
			autoRowHeight:false" >
		<thead >
			<tr >
				<th data-options="field:'userId'" style="width:10%;">用户ID</th>
				<th data-options="field:'userLoginName'" style="width:10%;">登录名</th>
				<th data-options="field:'userName'" style="width:20%;">用户姓名</th>
				<th data-options="field:'userPhoneNum'" style="width:20%;">手机号码</th>
				<th data-options="field:'userEmail'" style="width:20%;">电子邮件</th>
				<th data-options="field:'userType'" style="width:10%;">用户类型</th>
				<th data-options="field:'_operate',width:'10%',align:'center',formatter:formatOper">操作</th> 
			</tr>
		</thead>
	</table>
	<script type="text/javascript">
		function getSelected(){
			var row = $('#dg').datagrid('getSelected');
			if (row){
				$.messager.alert('Info', row.userId+":"+row.userLoginName+":"+row.userName);
			}
		}
		function getSelections(){
			var ss = [];
			var rows = $('#dg').datagrid('getSelections');
			for(var i=0; i<rows.length; i++){
				var row = rows[i];
				ss.push('<span>'+'Info', row.userId+":"+row.userLoginName+":"+row.userName+'</span>');
			}
			$.messager.alert('Info', ss.join('<br/>'));
		}
	</script>
 	
  </body>
</html>
