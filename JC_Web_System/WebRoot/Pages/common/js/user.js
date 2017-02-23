
//搜索
//function changesearch(){	
$("#u_search").click(function(){	
	var  IuserName=document.getElementById("i_userName").value;
	var  SuserType=document.getElementById("s_userType");
	var index=SuserType.selectedIndex; 
	var s_value=SuserType.options[index].value;
	window.location.href="userList!searchUserByT_N.action?userType="+s_value+"&userName="+IuserName; 
});


$(function($){
	//单个编辑
	$("[id=user_edit]").click(function(){
		var userId = $(this).parent().parent().parent().find("td:eq(0)").text();
		window.location.href = "userList!gotoEditUser.action?userId="
			+userId; 
	});
	
	//点击页码
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
 
	//单个删除
	$("[id=user_delete]").click(function(){
		if(confirm("您确定要删除吗?")){
			var userId = $(this).parent().parent().parent().find("td:eq(0)").text();
			
			window.location.href = "userList!DeleteUser.action?userId="
	    	+userId;
			
		}
	});
	
 
});

//异步刷新用户表格数据
function updateUserTable() {
	alert("2222");
	$("#registeredAddressTown").empty();//清空
	//var zhuceid = document.getElementById("zhuceid").value;
	var url = "user!updateUserTable.action?pageNum=" + pageNow;
	$.ajax( {
		type : "POST",
		url : url,
		data : {},
		dataType : "JSON",
		success : function(jsonData) {
			//alert(jsonData);
			//data为后台返回的Json信息
			rebuildUserTable(jsonData);//刷新users_table表
		}
	})
}

//根据json数据更新用户列表users_table
function rebuildUserTable(var jsonData){
	for(var n=0;n<jsonData.length;n++){
	 		var ids=jsonData[n].userId;
	 		alert(ids);
			//var names=data[n].name;
			//$("#registeredAddressTown").append("<option id='"+ids+"' value='"+names+"'>"+names+"</option>");
	}
}



//全选
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

//批量删除
function DelSelect(){
	var deleteUserList=new Array();
	var count=0;
	if(confirm("您确认要删除选中的内容吗？")){
    	$("input[name=chk_list]").each(function(i,d){
    		if(d.checked){
    			deleteUserList.push(d.value);
    			//window.alert(d.value); 
    			count++;
    		}
    	})
    	if(count<=0){window.alert("请选择要删除的用户！"); return false;}
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
