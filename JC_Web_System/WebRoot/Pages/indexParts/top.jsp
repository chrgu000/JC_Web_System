<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>主页面top部分</title>
	<style type="text/css">
		a:link {font-size:12px; text-decoration:none; color:#000000;}
		a:visited {font-size:12px; text-decoration:none; color:#000000;}
		a:hover {font-size:12px; text-decoration:none; color:#FF0000;}

		a.v1:link {font-size:12px; text-decoration:none; color:#03515d;}
		a.v1:visited {font-size:12px; text-decoration:none; color:#03515d;}
	</style>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="26" background="<%request.getContextPath();%>Pages/indexParts/images/main_03.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="227" height="26" background="<%request.getContextPath();%>Pages/indexParts/images/main_01.gif" >&nbsp;</td>
        <td>&nbsp;</td>
        <td width="60"><img src="<%request.getContextPath();%>Pages/indexParts/images/main_05.gif" width="60" height="26" /></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="64"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td width="227" height="64" background="<%request.getContextPath();%>Pages/indexParts/images/main_06.gif" nowrap="nowrap" >&nbsp;</td>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td height="26" background="<%request.getContextPath();%>Pages/indexParts/images/main_07.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td height="26"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="640" height="26"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td width="30"><div align="center"><img src="<%request.getContextPath();%>Pages/indexParts/images/top_1.gif" width="14" height="14" /></div></td>
                        <td  nowrap="nowrap" class="STYLE1">当前登录用户：Admin 用户角色：管理员</td>
                      </tr>
                    </table></td>
                  
                    <td width="352"><table width="46%" border="0" align="right" cellpadding="0" cellspacing="0">
                      <tr>
                        <td width="56"><table width="45" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                              <td width="21"><div align="center"><img src="<%request.getContextPath();%>Pages/indexParts/images/top_2.gif" width="14" height="14" /></div></td>
                              <td width="35"><div align="center" class="STYLE1"><a href="#">首页</a></div></td>
                            </tr>
                        </table></td>
                       
                        
                        <td width="10"><img src="<%request.getContextPath();%>Pages/indexParts/images/main_11.gif" width="6" height="26" /></td>
                        <td width="102"><table width="102" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                              <td width="22"><div align="center"><img src="<%request.getContextPath();%>Pages/indexParts/images/top_6.gif" width="14" height="14" /></div></td>
                              <td width="80"><div align="center" class="STYLE1"><a href="#">个人信息修改</a></div></td>
                            </tr>
                        </table></td>
                        <td width="10"><img src="<%request.getContextPath();%>Pages/indexParts/images/main_11.gif" width="6" height="26" /></td>
                        <td width="56"><table width="45" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                              <td width="21"><div align="center"><img src="<%request.getContextPath();%>Pages/indexParts/images/top_7.gif" width="14" height="14" /></div></td>
                              <td width="40"><div align="center" class="STYLE1"><a href="#">退出</a></div></td>
                            </tr>
                        </table></td>
                        </tr>
                    </table></td>
                  </tr>
                </table></td>
                <td width="12"><img src="<%request.getContextPath();%>Pages/indexParts/images/main_13.gif" width="12" height="26" /></td>
              </tr>
            </table></td>
          </tr>
          <tr>
            <td height="38" background="<%request.getContextPath();%>Pages/indexParts/images/main_15.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td height="38"><table border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="100" height="26" style="cursor:hand" onMouseOver="this.style.backgroundImage='url(<%request.getContextPath();%>Pages/indexParts/images/main_18.gif)';this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#adb9c2'; "onmouseout="this.style.backgroundImage='url()';this.style.borderStyle='none'"><table width="100%" border="0" cellpadding="0" cellspacing="0">
                      <tr>
                        <td><div align="center"><img src="<%request.getContextPath();%>Pages/indexParts/images/top_8.gif" width="16" height="16" /></div></td>
                        <td><div align="center"><span class="STYLE2"><a href="#" class="v1">农户基本信息</a></span></div></td>
                      </tr>
                    </table></td>
                    <td width="100" style="cursor:hand" onMouseOver="this.style.backgroundImage='url(<%request.getContextPath();%>Pages/indexParts/images/main_18.gif)';this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#adb9c2'; "onmouseout="this.style.backgroundImage='url()';this.style.borderStyle='none'"><table width="100%" border="0" cellpadding="0" cellspacing="0">
                      <tr>
                        <td><div align="center"><img src="<%request.getContextPath();%>Pages/indexParts/images/top_9.gif" width="20" height="20" /></div></td>
                        <td><div align="center"><span class="STYLE2"><a href="#" class="v1">基础信息图片</a></span></div></td>
                      </tr>
                    </table></td>
                    <td width="75" style="cursor:hand" onMouseOver="this.style.backgroundImage='url(<%request.getContextPath();%>Pages/indexParts/images/main_18.gif)';this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#adb9c2'; "onmouseout="this.style.backgroundImage='url()';this.style.borderStyle='none'"><table width="100%" border="0" cellpadding="0" cellspacing="0">
                      <tr>
                        <td><div align="center"><img src="<%request.getContextPath();%>Pages/indexParts/images/top_10.gif" width="20" height="20" /></div></td>
                        <td><div align="center"><span class="STYLE2"><a href="#" class="v1">家庭成员</a></span></div></td>
                      </tr>
                    </table></td>
                    <td width="90" style="cursor:hand" onMouseOver="this.style.backgroundImage='url(<%request.getContextPath();%>Pages/indexParts/images/main_18.gif)';this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#adb9c2'; "onmouseout="this.style.backgroundImage='url()';this.style.borderStyle='none'"><table width="100%" border="0" cellpadding="0" cellspacing="0">
                      <tr>
                        <td><div align="center"><img src="<%request.getContextPath();%>Pages/indexParts/images/top_14.gif" width="20" height="20" /></div></td>
                        <td><div align="center"><span class="STYLE2"><a href="#" class="v1">农户大纪事</a></span></div></td>
                      </tr>
                    </table></td>
                    <td width="100" style="cursor:hand" onMouseOver="this.style.backgroundImage='url(<%request.getContextPath();%>Pages/indexParts/images/main_18.gif)';this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#adb9c2'; "onmouseout="this.style.backgroundImage='url()';this.style.borderStyle='none'"><table width="100%" border="0" cellpadding="0" cellspacing="0">
                      <tr>
                        <td><div align="center"><img src="<%request.getContextPath();%>Pages/indexParts/images/top_13.gif" width="20" height="20" /></div></td>
                        <td><div align="center"><span class="STYLE2"><a href="#" class="v1">农户回访记录</a></span></div></td>
                      </tr>
                    </table></td>
                    </tr>
                </table></td>
                <td width="60" ><div align="right"><img src="<%request.getContextPath();%>Pages/indexParts/images/main_17.gif" width="60" height="38" /></div></td>
              </tr>
            </table></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
</table>
  </body>
</html>
