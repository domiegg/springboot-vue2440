<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>


<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>
<script type="text/javascript" src="js/popup.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<TITLE>修改社区美食</TITLE>
	    <link rel="stylesheet" href="kindeditor_a5/themes/default/default.css" />
	<link rel="stylesheet" href="kindeditor_a5/plugins/code/prettify.css" />
	<script charset="utf-8" src="kindeditor_a5/kindeditor.js"></script>
	<script charset="utf-8" src="kindeditor_a5/lang/zh_CN.js"></script>
	<script charset="utf-8" src="kindeditor_a5/plugins/code/prettify.js"></script>
	<script>
		KindEditor.ready(function(K) {
			var editor1 = K.create('textarea[name="xiangqing"]', {
				cssPath : 'kindeditor_a5/plugins/code/prettify.css',
				uploadJson : 'kindeditor_a5/jsp/upload_json.jsp',
				fileManagerJson : 'kindeditor_a5/jsp/file_manager_json.jsp',
				allowFileManager : true,
				afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
				}
			});
			prettyPrint();
		});
	</script>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>
       
	</head>
<%
  String id="";
 
   %>
<script language="javascript">

function gows()
{
	document.location.href="shequmeishi_add.jsp?id=<%=id%>";
}
function hsgxia2shxurxu(nstr,nwbk)
{
	if (eval("form1."+nwbk).value.indexOf(nstr)>=0)
	{
		eval("form1."+nwbk).value=eval("form1."+nwbk).value.replace(nstr+"；", "");
	}
	else
	{
		eval("form1."+nwbk).value=eval("form1."+nwbk).value+nstr+"；";
	}
}
</script>
	<body>
			<form action="updateShequmeishi.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="20" colspan="2" background="images/table_header.gif">修改社区美食<input type="hidden" name="id" value="${shequmeishi.id}" /></td>
						</tr>
						<tr ><td width="200">编号：</td><td><input name='bianhao' type='text' id='bianhao' value='<%=connDbBean.getID()%>' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr>		<tr ><td width="200">菜名：</td><td><input name='caiming' type='text' id='caiming' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelcaiming' /></td></tr>		<tr ><td width="200">主图：</td><td><input name='zhutu' type='text' id='zhutu' size='50' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;<input type='button' value='上传' onClick="up('zhutu')" style='border:solid 1px #000000; color:#666666'/>&nbsp;*<label id='clabelzhutu' /></td></tr>		<tr ><td width="200">菜系：</td><td><select name='caixi' id='caixi'><option value="川菜">川菜</option><option value="鲁菜">鲁菜</option><option value="粤菜">粤菜</option><option value="闽菜">闽菜</option><option value="淮扬菜">淮扬菜</option><option value="浙菜">浙菜</option><option value="湘菜">湘菜</option><option value="徽菜">徽菜</option></select></td></tr>		<tr ><td width="200">特色：</td><td><input name='tese' type='text' id='tese' value='' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr>		<tr ><td width="200">详情：</td><td><textarea name="xiangqing" cols="100" rows="8" style="width:700px;height:200px;visibility:hidden;"></textarea></td></tr>		<tr ><td width="200">用户名：</td><td><input name='yonghuming' type='text' id='yonghuming' onblur='' style='border:solid 1px #000000; color:#666666' value='<%=(String)request.getSession().getAttribute("username")%>' readonly="readonly" /></td></tr>		
		
						<tr align='center'   height="22">
						    <td width="25%"  align="right">&nbsp;
						        
						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();"/>
						       <input type="reset" value="重置"/>&nbsp;
						    </td>
						</tr>
						<script language="javascript">document.form1.bianhao.value='${shequmeishi.bianhao}';</script>	<script language="javascript">document.form1.caiming.value='${shequmeishi.caiming}';</script>	<script language="javascript">document.form1.zhutu.value='${shequmeishi.zhutu}';</script>	<script language="javascript">document.form1.caixi.value='${shequmeishi.caixi}';</script>	<script language="javascript">document.form1.tese.value='${shequmeishi.tese}';</script>	<script language="javascript">document.form1.xiangqing.value='${shequmeishi.xiangqing}';</script>	<script language="javascript">document.form1.yonghuming.value='${shequmeishi.yonghuming}';</script>	
					 </table>
			</form>
   </body>
</html>






<script language=javascript >  
 
 function checkform(){  
 
	var caimingobj = document.getElementById("caiming"); if(caimingobj.value==""){document.getElementById("clabelcaiming").innerHTML="&nbsp;&nbsp;<font color=red>请输入菜名</font>";return false;}else{document.getElementById("clabelcaiming").innerHTML="  "; } 	var zhutuobj = document.getElementById("zhutu"); if(zhutuobj.value==""){document.getElementById("clabelzhutu").innerHTML="&nbsp;&nbsp;<font color=red>请输入主图</font>";return false;}else{document.getElementById("clabelzhutu").innerHTML="  "; } 	


return true;   
}   
popheight=450;
</script>  
