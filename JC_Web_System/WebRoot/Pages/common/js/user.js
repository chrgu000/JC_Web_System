
//����
//function changesearch(){	
$("#u_search").click(function(){	
	var  IuserName=document.getElementById("i_userName").value;
	var  SuserType=document.getElementById("s_userType");
	var index=SuserType.selectedIndex; 
	var s_value=SuserType.options[index].value;
	window.location.href="userList!searchUserByT_N.action?userType="+s_value+"&userName="+IuserName; 
});


$(function($){
	//�����༭
	$("[id=user_edit]").click(function(){
		var userId = $(this).parent().parent().parent().find("td:eq(0)").text();
		window.location.href = "userList!gotoEditUser.action?userId="
			+userId; 
	});
	
	//���ҳ��
	$("#pageNumlist a").click(function(){
	 	alert(pageNow);
	 	var pageNum=$(this).text();
	 	alert(pageNow);
	 	if(pageNow==pageNum){
	 		return false;
	 	}
	 	$("#pageNumlist a").each(function(){
	 	  //alert(pageNum);
		  if ($(this).text()==pageNum) {
			 $(this).addClass("current");
			 $(this).removeAttr("href");
			 pageNow=pageNum;
			 updateUserTable(pageNow);
			 //alert(pageNow);
		  }
		  else {
			 $(this).removeClass("current");
			 $(this).attr("href","");
		  }
	  });
	});
 
	//����ɾ��
	$("[id=user_delete]").click(function(){
		if(confirm("��ȷ��Ҫɾ����?")){
			var userId = $(this).parent().parent().parent().find("td:eq(0)").text();
			
			window.location.href = "userList!DeleteUser.action?userId="
	    	+userId;
			
		}
	});
	
 
});

//�첽ˢ���û��������
function updateUserTable() {
	alert("2222");
	$("#registeredAddressTown").empty();//���
	//var zhuceid = document.getElementById("zhuceid").value;
	var url = "user!updateUserTable.action?pageNum=" + pageNow;
	$.ajax( {
		type : "POST",
		url : url,
		data : {},
		dataType : "JSON",
		success : function(jsonData) {
			//alert(jsonData);
			//dataΪ��̨���ص�Json��Ϣ
			rebuildUserTable(jsonData);//ˢ��users_table��
		}
	})
}

//����json���ݸ����û��б�users_table
function rebuildUserTable(var jsonData){
	for(var n=0;n<jsonData.length;n++){
	 		var ids=jsonData[n].userId;
	 		alert(ids);
			//var names=data[n].name;
			//$("#registeredAddressTown").append("<option id='"+ids+"' value='"+names+"'>"+names+"</option>");
	}
}



//ȫѡ
$("#checkall").click(function(){ 
  $("input[name='chk_list']").each(function(){
	  if (this.checked) {
		  this.checked = false;
	  }
	  else {
		  this.checked = true;
	  }
  });
})

//����ɾ��
function DelSelect(){
	var deleteUserList=new Array();
	var count=0;
	if(confirm("��ȷ��Ҫɾ��ѡ�е�������")){
    	$("input[name=chk_list]").each(function(i,d){
    		if(d.checked){
    			deleteUserList.push(d.value);
    			//window.alert(d.value); 
    			count++;
    		}
    	})
    	if(count<=0){window.alert("��ѡ��Ҫɾ�����û���"); return false;}
    	//var usersIdsJson=window.JSON.stringify(deleteUserList);
    	var str="";
    	for(var i=0;i<count;i++){str=str+deleteUserList[i]+",";}
    	//window.alert(str);
    	//window.alert(usersIdsJson); 
    	window.location.href = "userList!DeleteUserByIds.action?usersIds="
    	+str;
	}else{
		return false;
	}

}
