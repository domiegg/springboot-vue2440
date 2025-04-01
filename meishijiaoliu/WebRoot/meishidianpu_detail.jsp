<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>美食店铺详细</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>

  <body >

  美食店铺详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%' height=44>用户名：</td><td width='39%'>${meishidianpu.yonghuming}</td><td  rowspan=8 align=center><a href=${meishidianpu.dianzhao} target=_blank><img src=${meishidianpu.dianzhao} width=228 height=215 border=0></a></td></tr><tr><td width='11%' height=44>密码：</td><td width='39%'>${meishidianpu.mima}</td></tr><tr><td width='11%' height=44>店名：</td><td width='39%'>${meishidianpu.dianming}</td></tr><tr><td width='11%' height=44>主营：</td><td width='39%'>${meishidianpu.zhuying}</td></tr><tr><td width='11%' height=44>联系人：</td><td width='39%'>${meishidianpu.lianxiren}</td></tr><tr><td width='11%' height=44>联系电话：</td><td width='39%'>${meishidianpu.lianxidianhua}</td></tr><tr><td width='11%' height=44>店铺地址：</td><td width='39%'>${meishidianpu.dianpudizhi}</td></tr><tr><td width='11%' height=44>资格证明：</td><td width='39%'><a href="${meishidianpu.zigezhengming}">点此下载</a></td></tr><tr><td width='11%' height=100  >简介：</td><td width='39%' colspan=2 height=100 >${meishidianpu.jianjie}</td></tr><tr><td colspan=3 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

