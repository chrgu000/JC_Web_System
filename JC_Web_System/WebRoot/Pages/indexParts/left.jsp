<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>主页面left部分</title>
    
    <style type="text/css">

body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.STYLE1 {
	color: #FFFFFF;
	font-weight: bold;
	font-size: 12px;
}
.STYLE2 {
	font-size: 12px;
	color: #03515d;
}
a:link {font-size:12px; text-decoration:none; color:#03515d;}
a:visited{font-size:12px; text-decoration:none; color:#03515d;}

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
    <table width="156" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td align="center" valign="top"><table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td height="33" background="images/main_21.gif">&nbsp;</td>
      </tr>
      <tr>
        <td height="20" background="<%request.getContextPath();%>Pages/indexParts/images/main_25.gif">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="13%">&nbsp;</td>
            <td width="72%" height="20"><div align="center">
              <table width="78%" height="21" border="0" cellpadding="0" cellspacing="0">
                <tr>
                  <td><div align="center"><img src="<%request.getContextPath();%>Pages/indexParts/images/top_8.gif" width="16" height="16">
                  </div></td>
                  <td valign="middle"><div align="center" class="STYLE1">资料管理</div></td>
                </tr>
              </table>
            </div></td>
            <td width="15%">&nbsp;</td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td align="center" valign="top"><table width="145" border="0" align="center" cellpadding="0" cellspacing="0">
          
          <tr>
            <td><table width="130" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="41" height="35"><div align="center">
                  <img src="<%request.getContextPath();%>Pages/indexParts/images/left_1.gif" width="31" height="31">
                  </div></td>
                  <td width="89" height="35"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td height="23" style="cursor:hand" onMouseOver="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#adb9c2'; "onmouseout="this.style.backgroundImage='url()';this.style.borderStyle='none'">
                      <span class="STYLE2">&nbsp;<a href="#">客户资料维护</a></span></td>
                    </tr>
                  </table></td>
                </tr>
                <tr>
                  <td width="41" height="35"><div align="center">
                  <img src="<%request.getContextPath();%>Pages/indexParts/images/left_2.gif" width="31" height="31"></div></td>
                  <td height="35"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td height="23" style="cursor:hand" onMouseOver="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#adb9c2'; "onmouseout="this.style.backgroundImage='url()';this.style.borderStyle='none'">
                      <span class="STYLE2">&nbsp;<a href="#">系统信息公告</a></span></td>
                    </tr>
                  </table></td>
                </tr>
                <tr>
                  <td width="41" height="35"><div align="center">
                  <img src="<%request.getContextPath();%>Pages/indexParts/images/left_3.gif" width="31" height="31">
                  </div></td>
                  <td height="35"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td height="23" style="cursor:hand" onMouseOver="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#adb9c2'; "onmouseout="this.style.backgroundImage='url()';this.style.borderStyle='none'">
                      <span class="STYLE2">&nbsp;<a href="#">用户维护</a></span></td>
                    </tr>
                  </table></td>
                </tr>
                <tr>
                  <td width="41" height="35"><div align="center">
                  	<img src="<%request.getContextPath();%>Pages/indexParts/images/left_4.gif" width="31" height="31">
                  </div></td>
                  <td height="35"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td height="23" style="cursor:hand" onMouseOver="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#adb9c2'; "onmouseout="this.style.backgroundImage='url()';this.style.borderStyle='none'"><span class="STYLE2">&nbsp;<a href="#">系统维护</a></span></td>
                    </tr>
                  </table></td>
                </tr>
            </table></td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td height="22" background="<%request.getContextPath();%>Pages/indexParts/images/main_36.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="13%">&nbsp;</td>
            <td width="72%" height="20"><div align="center">
                <table width="78%" height="21" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td><div align="center">
                    <img src="<%request.getContextPath();%>Pages/indexParts/images/top_17.gif" width="16" height="16">
                    </div></td>
                    <td valign="middle"><div align="center"><span class="STYLE1">信用评分</span></div></td>
                  </tr>
                </table>
            </div></td>
            <td width="15%">&nbsp;</td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td height="22" background="<%request.getContextPath();%>Pages/indexParts/images/main_36.gif">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="13%">&nbsp;</td>
            <td width="72%" height="20"><div align="center">
                <table width="78%" height="21" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td><div align="center">
                    <img src="<%request.getContextPath();%>Pages/indexParts/images/top_16.gif" width="16" height="16"></div></td>
                    <td valign="middle"><div align="center"><span class="STYLE1">贷款管理</span></div></td>
                  </tr>
                </table>
            </div></td>
            <td width="15%">&nbsp;</td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td height="22" background="<%request.getContextPath();%>Pages/indexParts/images/main_36.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="13%">&nbsp;</td>
            <td width="72%" height="20"><div align="center">
                <table width="78%" height="21" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td><div align="center">
                    <img src="<%request.getContextPath();%>Pages/indexParts/images/top_18.gif" width="16" height="16"></div></td>
                    <td valign="middle"><div align="center" class="STYLE1">诚信管理</div></td>
                  </tr>
                </table>
            </div></td>
            <td width="15%">&nbsp;</td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td height="39" background="<%request.getContextPath();%>Pages/indexParts/images/main_37.gif">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
</table>
  </body>
</html>
