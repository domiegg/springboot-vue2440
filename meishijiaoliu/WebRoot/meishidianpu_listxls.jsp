<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="meishidianpuhsgb" scope="page" class="com.bean.MeishidianpuBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=meishidianpu.xls");
%>
<html>
  <head>
    <title>美食店铺</title>
  </head>

  <body >
 <%
			String sql="select * from meishidianpu  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center'>用户名</td>    <td align='center'>密码</td>    <td align='center'>店名</td>    <td  width='90' align='center'>店招</td>    <td align='center'>主营</td>    <td align='center'>联系人</td>    <td align='center'>联系电话</td>    <td align='center'>店铺地址</td>    <td  width='90' align='center'>资格证明</td>        <td  width='80' align='center'>是否审核</td>
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=meishidianpuhsgb.getAllMeishidianpu(13);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.yonghuming}</td>    <td>${u.mima}</td>    <td>${u.dianming}</td>    <td width='90' align='center'><a href='${u.dianzhao}' target='_blank'><img src='${u.dianzhao}' width=88 height=99 border=0 /></a></td>    <td>${u.zhuying}</td>    <td>${u.lianxiren}</td>    <td>${u.lianxidianhua}</td>    <td>${u.dianpudizhi}</td>    <td width='90' align='center'><a href='${u.zigezhengming}' target='_blank'>下载</a></td>        <td align='center'>${u.issh} <input type="button" value="审核" onclick="javascript:location.href='sh.jsp?id=${u.id}&yuan=${u.issh}&tablename=meishidianpu'"/></td>
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

