<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="meishidianpuhsgb" scope="page" class="com.bean.MeishidianpuBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=meishidianpu.xls");
%>
<html>
  <head>
    <title>��ʳ����</title>
  </head>

  <body >
 <%
			String sql="select * from meishidianpu  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">���</td>
    <td align='center'>�û���</td>    <td align='center'>����</td>    <td align='center'>����</td>    <td  width='90' align='center'>����</td>    <td align='center'>��Ӫ</td>    <td align='center'>��ϵ��</td>    <td align='center'>��ϵ�绰</td>    <td align='center'>���̵�ַ</td>    <td  width='90' align='center'>�ʸ�֤��</td>        <td  width='80' align='center'>�Ƿ����</td>
	
    <td width="120" align="center" bgcolor="CCFFFF">���ʱ��</td>
    
  </tr>
   <%		
				List pagelist3=meishidianpuhsgb.getAllMeishidianpu(13);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.yonghuming}</td>    <td>${u.mima}</td>    <td>${u.dianming}</td>    <td width='90' align='center'><a href='${u.dianzhao}' target='_blank'><img src='${u.dianzhao}' width=88 height=99 border=0 /></a></td>    <td>${u.zhuying}</td>    <td>${u.lianxiren}</td>    <td>${u.lianxidianhua}</td>    <td>${u.dianpudizhi}</td>    <td width='90' align='center'><a href='${u.zigezhengming}' target='_blank'>����</a></td>        <td align='center'>${u.issh} <input type="button" value="���" onclick="javascript:location.href='sh.jsp?id=${u.id}&yuan=${u.issh}&tablename=meishidianpu'"/></td>
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

