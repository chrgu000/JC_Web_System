
/**<span style="font-size:14px;">
 * @author 胡根得 
 * 2015/12/08
 */

		//用户名：
		var  usernameRegex = /^\w{3,15}$/;
		//密码：
		var passwordRegex = /^\w{6,12}$/;
		//邮箱：
		var emailRegex = /^\w+@\w+(\.\w+)+$/;
		//真实姓名：
		var realNameRegex = /^[\u4e00-\u9fa5]{2,5}$/;
		//手机号码：
		var phoneNumRegex = /^1[3|4|5|8][0-9]\d{4,8}$/;
		//alert("222");
		function validateForm(){ //定义validateForm方法用于客户端校验
			var flag = true;
			//校验用户名
			var usernameNode = byId("username"); //获得ID值为username的节点对象
			var username = usernameNode.value;   //获得usernameNode节点的值，即用户在username文本框内填写的值
			if(!usernameRegex.test(username)){    //验证获得到的值是否符合正则表达式
				byId("username_span").style.color = "red"; //如果不符合，则将ID值为username_span的节点对象内容变为红色
				flag = false;        //返回false，不提交
			}
			
			//校验密码
			var passwordNode = byId("password");  //获得ID值为password的节点对象
			var password = passwordNode.value;
			if(!passwordRegex.test(password)){
				byId("password_span").style.color = "red";
				flag = false;
			}
			
			//确认密码
			var rePasswordNode = byId("rePassword");  //获得ID值为rePassword的节点对象
			var rePassword = rePasswordNode.value;
			if(!password==rePassword){
				byId("rePassword_span").style.color = "red";
				flag = false;
			}else if(!passwordRegex.test(rePassword)){
				byId("rePassword_span").style.color = "red";
				flag = false;
			}else{
				byId("rePassword_span").style.color = "green";
			}
			
			//校验邮箱
			var emailNode = byId("Email");  //获得ID值为Email的节点对象
			var email = emailNode.value;
			if(!emailRegex.test(email)){
				byId("Email_span").style.color = "red";
				flag = false;
			}
			
			//校验姓名
			var realNameNode = byId("realName");  //获得ID值为realName的节点对象
			var realName = realNameNode.value;
			if(!realNameRegex.test(realName)){
				byId("realName_span").style.color = "red";
				flag = false;
			}
			
			//校验手机号
			var phoneNumNode = byId("phoneNum");  //获得ID值为phoneNum的节点对象
			var phoneNum = phoneNumNode.value;
			if(!phoneNumRegex.test(phoneNum)){
				byId("phoneNum_span").style.color = "red";
				flag = false;
			}
			
			return flag;
		}
			
		function byId(id){  //自定义方法，用于获取传递过来的ID值对应的节点对象
			return document.getElementById(id);
		}
			
		function checkUsername(node){ //当鼠标离开节点时调用此方法，验证节点内容是否符合注册规范
			//校验用户名
			var username = node.value;  //得到传递过来的节点对象的值
			if(!usernameRegex.test(username)){  //验证是否符合节点对应的正则表达式
				byId("username_span").style.color = "red"; //不符合，相应内容变成红色
			}else{
				byId("username_span").style.color = "green";  //符合，相应内容变成绿色
			}
		}
		
		function checkPassword(node){  //当鼠标离开节点时调用此方法，验证节点内容是否符合注册规范
			//校验密码
			var password = node.value;
			//alert("111");
			if (!passwordRegex.test(password)) {
				byId("password_span").style.color = "red";
			}
			else {
				byId("password_span").style.color = "green";
			}
		}	
			
		function checkRePassword(node){  //当鼠标离开节点时调用此方法，验证节点内容是否符合注册规范
			//确认密码				
			var rePassword = node.value;
			var password = byId("password").value;
			//alert(repassword+"***"+password);			
			if(!password==rePassword){					
				byId("rePassword_span").style.color = "red";
			}else if(!passwordRegex.test(rePassword)){
				byId("rePassword_span").style.color = "red";
			}else{
				byId("rePassword_span").style.color = "green";
			}
		}		

		function checkEmail(node){  //当鼠标离开节点时调用此方法，验证节点内容是否符合注册规范
			//校验邮箱
			var email = node.value;
			if(!emailRegex.test(email)){
				byId("Email_span").style.color = "red";
			}else{
				byId("Email_span").style.color = "green";
			}
		}
			
		function checkName(node){  //当鼠标离开节点时调用此方法，验证节点内容是否符合注册规范
			var realName = node.value;
			if(!realNameRegex.test(realName)){
				byId("realName_span").style.color = "red";
			}else{
				byId("realName_span").style.color = "green";
			}
		}
		
		
		function checkPhoneNum(node){  //当鼠标离开节点时调用此方法，验证节点内容是否符合注册规范
			var phoneNum = node.value;
			if(!phoneNumRegex.test(phoneNum)){
				byId("phoneNum_span").style.color = "red";
			}else{
				byId("phoneNum_span").style.color = "green";
			}
		}
		

