
/**<span style="font-size:14px;">
 * @author ������ 
 * 2015/12/08
 */

		//�û�����
		var  usernameRegex = /^\w{3,15}$/;
		//���룺
		var passwordRegex = /^\w{6,12}$/;
		//���䣺
		var emailRegex = /^\w+@\w+(\.\w+)+$/;
		//��ʵ������
		var realNameRegex = /^[\u4e00-\u9fa5]{2,5}$/;
		//�ֻ����룺
		var phoneNumRegex = /^1[3|4|5|8][0-9]\d{4,8}$/;
		//alert("222");
		function validateForm(){ //����validateForm�������ڿͻ���У��
			var flag = true;
			//У���û���
			var usernameNode = byId("username"); //���IDֵΪusername�Ľڵ����
			var username = usernameNode.value;   //���usernameNode�ڵ��ֵ�����û���username�ı�������д��ֵ
			if(!usernameRegex.test(username)){    //��֤��õ���ֵ�Ƿ����������ʽ
				byId("username_span").style.color = "red"; //��������ϣ���IDֵΪusername_span�Ľڵ�������ݱ�Ϊ��ɫ
				flag = false;        //����false�����ύ
			}
			
			//У������
			var passwordNode = byId("password");  //���IDֵΪpassword�Ľڵ����
			var password = passwordNode.value;
			if(!passwordRegex.test(password)){
				byId("password_span").style.color = "red";
				flag = false;
			}
			
			//ȷ������
			var rePasswordNode = byId("rePassword");  //���IDֵΪrePassword�Ľڵ����
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
			
			//У������
			var emailNode = byId("Email");  //���IDֵΪEmail�Ľڵ����
			var email = emailNode.value;
			if(!emailRegex.test(email)){
				byId("Email_span").style.color = "red";
				flag = false;
			}
			
			//У������
			var realNameNode = byId("realName");  //���IDֵΪrealName�Ľڵ����
			var realName = realNameNode.value;
			if(!realNameRegex.test(realName)){
				byId("realName_span").style.color = "red";
				flag = false;
			}
			
			//У���ֻ���
			var phoneNumNode = byId("phoneNum");  //���IDֵΪphoneNum�Ľڵ����
			var phoneNum = phoneNumNode.value;
			if(!phoneNumRegex.test(phoneNum)){
				byId("phoneNum_span").style.color = "red";
				flag = false;
			}
			
			return flag;
		}
			
		function byId(id){  //�Զ��巽�������ڻ�ȡ���ݹ�����IDֵ��Ӧ�Ľڵ����
			return document.getElementById(id);
		}
			
		function checkUsername(node){ //������뿪�ڵ�ʱ���ô˷�������֤�ڵ������Ƿ����ע��淶
			//У���û���
			var username = node.value;  //�õ����ݹ����Ľڵ�����ֵ
			if(!usernameRegex.test(username)){  //��֤�Ƿ���Ͻڵ��Ӧ��������ʽ
				byId("username_span").style.color = "red"; //�����ϣ���Ӧ���ݱ�ɺ�ɫ
			}else{
				byId("username_span").style.color = "green";  //���ϣ���Ӧ���ݱ����ɫ
			}
		}
		
		function checkPassword(node){  //������뿪�ڵ�ʱ���ô˷�������֤�ڵ������Ƿ����ע��淶
			//У������
			var password = node.value;
			//alert("111");
			if (!passwordRegex.test(password)) {
				byId("password_span").style.color = "red";
			}
			else {
				byId("password_span").style.color = "green";
			}
		}	
			
		function checkRePassword(node){  //������뿪�ڵ�ʱ���ô˷�������֤�ڵ������Ƿ����ע��淶
			//ȷ������				
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

		function checkEmail(node){  //������뿪�ڵ�ʱ���ô˷�������֤�ڵ������Ƿ����ע��淶
			//У������
			var email = node.value;
			if(!emailRegex.test(email)){
				byId("Email_span").style.color = "red";
			}else{
				byId("Email_span").style.color = "green";
			}
		}
			
		function checkName(node){  //������뿪�ڵ�ʱ���ô˷�������֤�ڵ������Ƿ����ע��淶
			var realName = node.value;
			if(!realNameRegex.test(realName)){
				byId("realName_span").style.color = "red";
			}else{
				byId("realName_span").style.color = "green";
			}
		}
		
		
		function checkPhoneNum(node){  //������뿪�ڵ�ʱ���ô˷�������֤�ڵ������Ƿ����ע��淶
			var phoneNum = node.value;
			if(!phoneNumRegex.test(phoneNum)){
				byId("phoneNum_span").style.color = "red";
			}else{
				byId("phoneNum_span").style.color = "green";
			}
		}
		

