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
		<TITLE>修改美食店铺</TITLE>
	    
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
	document.location.href="meishidianpu_add.jsp?id=<%=id%>";
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
			<form action="updateMeishidianpu.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="20" colspan="2" background="images/table_header.gif">修改美食店铺<input type="hidden" name="id" value="${meishidianpu.id}" /></td>
						</tr>
						<tr ><td width="200">用户名：</td><td><input name='yonghuming' type='text' id='yonghuming' value='' onblur='hsgcheck()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelyonghuming' /></td></tr>		<tr ><td width="200">密码：</td><td><input name='mima' type='text' id='mima' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelmima' /></td></tr>		<tr ><td width="200">店名：</td><td><input name='dianming' type='text' id='dianming' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabeldianming' /></td></tr>		<tr ><td width="200">店招：</td><td><input name='dianzhao' type='text' id='dianzhao' size='50' value='' onblur='' style='border:solid 1px #000000; color:#666666' />&nbsp;<input type='button' value='上传' onClick="up('dianzhao')" style='border:solid 1px #000000; color:#666666'/></td></tr>		<tr ><td width="200">主营：</td><td><input name='zhuying' type='text' id='zhuying' value='' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr>		<tr ><td width="200">联系人：</td><td><input name='lianxiren' type='text' id='lianxiren' value='' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr>		<tr ><td width="200">联系电话：</td><td><input name='lianxidianhua' type='text' id='lianxidianhua' value='' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr>		<tr ><td width="200">店铺地址：</td><td><input name='dianpudizhi' type='text' id='dianpudizhi' value='' onblur='' size='50' style='border:solid 1px #000000; color:#666666' /></td></tr>		<tr ><td width="200">资格证明：</td><td><input name='zigezhengming' type='text' id='zigezhengming' size='50' value='' onblur='' style='border:solid 1px #000000; color:#666666' />&nbsp;<input type='button' value='上传' onClick="up('zigezhengming')" style='border:solid 1px #000000; color:#666666'/></td></tr>		<tr 0><td width="200">简介：</td><td><textarea name='jianjie' cols='50' rows='5' id='jianjie' onblur='' style='border:solid 1px #000000; color:#666666' ></textarea></td></tr>		
		
						<tr align='center'   height="22">
						    <td width="25%"  align="right">&nbsp;
						        
						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();"/>
						       <input type="reset" value="重置"/>&nbsp;
						    </td>
						</tr>
						<script language="javascript">document.form1.yonghuming.value='${meishidianpu.yonghuming}';</script>	<script language="javascript">document.form1.mima.value='${meishidianpu.mima}';</script>	<script language="javascript">document.form1.dianming.value='${meishidianpu.dianming}';</script>	<script language="javascript">document.form1.dianzhao.value='${meishidianpu.dianzhao}';</script>	<script language="javascript">document.form1.zhuying.value='${meishidianpu.zhuying}';</script>	<script language="javascript">document.form1.lianxiren.value='${meishidianpu.lianxiren}';</script>	<script language="javascript">document.form1.lianxidianhua.value='${meishidianpu.lianxidianhua}';</script>	<script language="javascript">document.form1.dianpudizhi.value='${meishidianpu.dianpudizhi}';</script>	<script language="javascript">document.form1.zigezhengming.value='${meishidianpu.zigezhengming}';</script>	<script language="javascript">document.form1.jianjie.value='${meishidianpu.jianjie}';</script>	
					 </table>
			</form>
   </body>
</html>






<script language=javascript >  
 
 function checkform(){  
 
	var yonghumingobj = document.getElementById("yonghuming"); if(yonghumingobj.value==""){document.getElementById("clabelyonghuming").innerHTML="&nbsp;&nbsp;<font color=red>请输入用户名</font>";return false;}else{document.getElementById("clabelyonghuming").innerHTML="  "; } 	var mimaobj = document.getElementById("mima"); if(mimaobj.value==""){document.getElementById("clabelmima").innerHTML="&nbsp;&nbsp;<font color=red>请输入密码</font>";return false;}else{document.getElementById("clabelmima").innerHTML="  "; } 	var dianmingobj = document.getElementById("dianming"); if(dianmingobj.value==""){document.getElementById("clabeldianming").innerHTML="&nbsp;&nbsp;<font color=red>请输入店名</font>";return false;}else{document.getElementById("clabeldianming").innerHTML="  "; } 	


return true;   
}   
popheight=450;
</script>  
