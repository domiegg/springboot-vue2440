<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="dachulailahsgb" scope="page" class="com.bean.DachulailaBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=dachulaila.xls");
%>
<html>
  <head>
    <title>大厨来啦</title>
  </head>

  <body >
 <%
			String sql="select * from dachulaila  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center'>编号</td>    <td align='center'>菜名</td>    <td  width='90' align='center'>主图</td>    <td align='center'>菜系</td>    <td align='center'>特色</td>        <td align='center'>用户名</td>    <td  width='80' align='center'>是否审核</td>
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=dachulailahsgb.getAllDachulaila(10);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.bianhao}</td>    <td>${u.caiming}</td>    <td width='90' align='center'><a href='${u.zhutu}' target='_blank'><img src='${u.zhutu}' width=88 height=99 border=0 /></a></td>    <td>${u.caixi}</td>    <td>${u.tese}</td>        <td>${u.yonghuming}</td>    <td align='center'>${u.issh} <input type="button" value="审核" onclick="javascript:location.href='sh.jsp?id=${u.id}&yuan=${u.issh}&tablename=dachulaila'"/></td>
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

