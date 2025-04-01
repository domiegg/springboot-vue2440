<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>社区美食详细</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>

  <body >

  社区美食详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%' height=44>编号：</td><td width='39%'>${shequmeishi.bianhao}</td><td  rowspan=5 align=center><a href=${shequmeishi.zhutu} target=_blank><img src=${shequmeishi.zhutu} width=228 height=215 border=0></a></td></tr><tr><td width='11%' height=44>菜名：</td><td width='39%'>${shequmeishi.caiming}</td></tr><tr><td width='11%' height=44>菜系：</td><td width='39%'>${shequmeishi.caixi}</td></tr><tr><td width='11%' height=44>特色：</td><td width='39%'>${shequmeishi.tese}</td></tr><tr><td width='11%' height=44>用户名：</td><td width='39%'>${shequmeishi.yonghuming}</td></tr><tr><td width='11%' height=100  >详情：</td><td width='39%' colspan=2 height=100 >${shequmeishi.xiangqing}</td></tr><tr><td colspan=3 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

