

/*编辑用户*/
function editUser(index){  
    $('#dg').datagrid('selectRow',index);// 关键在这里  
    var row = $('#dg').datagrid('getSelected');  
    if (row){  
        $('#dlg').dialog('open').dialog('setTitle','修改学生信息');  
        $('#fm').form('load',row);  
        //url = '${ctx}updateStudent.do?id='+row.id;  
    }  
}  

/*删除用户*/
function deleteUser{
	
}