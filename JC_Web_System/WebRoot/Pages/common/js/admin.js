

/*�༭�û�*/
function editUser(index){  
    $('#dg').datagrid('selectRow',index);// �ؼ�������  
    var row = $('#dg').datagrid('getSelected');  
    if (row){  
        $('#dlg').dialog('open').dialog('setTitle','�޸�ѧ����Ϣ');  
        $('#fm').form('load',row);  
        //url = '${ctx}updateStudent.do?id='+row.id;  
    }  
}  

/*ɾ���û�*/
function deleteUser{
	
}