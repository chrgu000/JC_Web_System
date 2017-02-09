<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>主页面right_top部分</title>
    
    <style type="text/css">

body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.STYLE1 {font-size: 12px}
.STYLE3 {font-size: 12px; color: #FFFFFF; }

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
    <table width="100%" border="0" cellspacing="0" cellpadding="0" style="table-layout:fixed;">
  <tr>
    <td height="28" valign="bottom" background="images/right_03.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="1%" height="26" style="width:5px;">&nbsp;</td>
        <td width="99%" valign="bottom"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="102" height="26" valign="bottom"><table width="100" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td height="25" style="background:url(images/right_06.gif); border-left:solid 1px #82bcbd;border-top:solid 1px #82bcbd;border-right:solid 1px #82bcbd; cursor:"><div align="center"><img src="images/1.gif" width="9" height="9" /> <span class="STYLE1">填写基本信息</span></div></td>
              </tr>
            </table></td>
            <td width="102"><table width="100" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td height="25" style="background:url(images/right_061.gif); border-left:solid 1px #10637b;border-top:solid 1px #10637b;border-right:solid 1px #10637b;"><div align="center"><img src="images/2_1.gif" width="9" height="9" /> <span class="STYLE3">填写财务报表</span></div></td>
              </tr>
            </table></td>
            <td width="102"><table width="100" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td height="25" style="background:url(images/right_06.gif); border-left:solid 1px #82bcbd;border-top:solid 1px #82bcbd;border-right:solid 1px #82bcbd;"><div align="center"><img src="images/3.gif" width="9" height="9" /> <span class="STYLE1">定性指标测评</span></div></td>
              </tr>
            </table></td>
            <td width="102"><table width="100" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td height="25" style="background:url(images/right_06.gif); border-left:solid 1px #82bcbd;border-top:solid 1px #82bcbd;border-right:solid 1px #82bcbd;"><div align="center"><img src="images/4.gif" width="9" height="9" /> <span class="STYLE1">贷款担保状况</span></div></td>
              </tr>
            </table></td>
            <td width="102"><table width="100" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td height="25" style="background:url(images/right_06.gif); border-left:solid 1px #82bcbd;border-top:solid 1px #82bcbd;border-right:solid 1px #82bcbd;"><div align="center"><img src="images/5.gif" width="9" height="9" /> <span class="STYLE1">填写补充材料</span></div></td>
              </tr>
            </table></td>
            <td width="102"><table width="100" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td height="25" style="background:url(images/right_06.gif); border-left:solid 1px #82bcbd;border-top:solid 1px #82bcbd;border-right:solid 1px #82bcbd;"><div align="center"><img src="images/6.gif" width="9" height="9" /> <span class="STYLE1">完成添加操作</span></div></td>
              </tr>
            </table></td>
            <td> &nbsp;<img src="images/syb.gif" width="62" height="21" /> <img src="images/xyb.gif" width="62" height="21" /></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td background="images/right_09.gif" style="line-height:5px;">&nbsp;</td>
  </tr>
  <tr>
    <td height="25" background="images/right_10.gif" style="border-top:solid 1px #b2cdd2; border-bottom:solid 1px #b2cdd2 "><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="25"  style="width:5px;">&nbsp;</td>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="135" height="20"><div align="center"><img src="images/mini_icons_046.gif" width="10" height="10" /> <span class="STYLE1">[1] 财产权利抵质押</span></div></td>
            <td width="135"  style="background:url(images/right_12.gif); border:solid 1px #98b1c0;"><div align="center"><img src="images/mini_icons_046.gif" width="10" height="10" /> <span class="STYLE1">[2] 第三方信用担保</span></div></td>
            <td>&nbsp;</td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
</table>
  </body>
</html>
