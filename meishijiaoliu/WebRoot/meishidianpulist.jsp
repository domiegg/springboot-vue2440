﻿<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html class="no-js">
<head>
<meta />
<title>美食店铺</title>

<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="qtimages/css/reset.css" rel="stylesheet" />
<link href="qtimages/css/main.css" rel="stylesheet"/>
<link href="qtimages/css/sub.css" rel="stylesheet"/>
<script src="qtimages/jquery.js"></script> 
<script src="js/jquery.SuperSlide.2.1.1.js"></script>

<script type="text/javascript" src="qtimages/inc.js"></script>
<link rel="stylesheet" href="qtimages/hsgbanner.css">
</head>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>

<%

%>

<body>
<jsp:include page="qttop.jsp"></jsp:include>

<div class="content">
	<div class="wrap">
		<div class="pad0">
			<div class="s_title">
				<div class="name">美食店铺</div>
				<div class="menu">
					
				</div>
			</div>
			<div class="det_con"> 
					
					
<form action="msdpList.do" name="myform" method="post">
									查询   店名：<input name="dianming" type="text" id="dianming" style='border:solid 1px #000000; color:#666666' size="12" />  主营：<input name="zhuying" type="text" id="zhuying" style='border:solid 1px #000000; color:#666666' size="12" />  店铺地址：<input name="dianpudizhi" type="text" id="dianpudizhi" style='border:solid 1px #000000; color:#666666' size="12" />
									<input type="submit" value="查询" /> <input type="button" name="Submit2" value="切换视图"  onClick="javascript:location.href='msdpListtp.do';" />
								</form>	

	
<br />
<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#ebf0f7">
                          <tr>
                            <td align="center" bgcolor="#ebf0f7" width="30px">序号</td>
                            <td bgcolor='#ebf0f7'>用户名</td>    <td bgcolor='#ebf0f7'>密码</td>    <td bgcolor='#ebf0f7'>店名</td>    <td bgcolor='#ebf0f7' width='90' align='center'>店招</td>    <td bgcolor='#ebf0f7'>主营</td>    <td bgcolor='#ebf0f7'>联系人</td>    <td bgcolor='#ebf0f7'>联系电话</td>    <td bgcolor='#ebf0f7'>店铺地址</td>    <td bgcolor='#ebf0f7'>资格证明</td>        
                            <td align="center" bgcolor="#ebf0f7" width="150px"> 添加时间 </td>
                            <td align="center" bgcolor="#ebf0f7" width="50px"> 操作 </td>
                          </tr>
                          <%
					int i=0;
				%>
                          <c:forEach items="${list}" var="u">
                            <%
					i++;
				%>
                            <tr align="center" bgcolor="#FFFFFF">
                              <td align="center"><%=i%></td>
                             <td>${u.yonghuming}</td>    <td>${u.mima}</td>    <td>${u.dianming}</td>    <td width='90'><a href='${u.dianzhao}' target='_blank'><img src='${u.dianzhao}' width=88 height=99 border=0 /></a></td>    <td>${u.zhuying}</td>    <td>${u.lianxiren}</td>    <td>${u.lianxidianhua}</td>    <td>${u.dianpudizhi}</td>    <td><a href='${u.zigezhengming}' target='_blank'>下载</a></td>        
                              <td align="center"> ${u.addtime} </td>
                              <td align="center"><a href="msdpDetail.do?id=${u.id}">详细</a></td>
                            </tr>
                          </c:forEach>
                        </table>
<br>

<p align="center"> <c:if test="${sessionScope.p==1 }">
		 <c:if test="${page.page>1}">
              <a href="msdpList.do?page=1" >首页</a>
             <a href="msdpList.do?page=${page.page-1 }"> 上一页</a>             </c:if>
    	     <c:if test="${page.page<page.totalPage}">
			<a href="msdpList.do?page=${page.page+1 }">下一页</a>
			<a href="msdpList.do?page=${page.totalPage }">末页</a>		    </c:if>		
	</c:if>
	</p>




					
			</div>	
		</div>
	</div>		
</div>
<jsp:include page="qtdown.jsp"></jsp:include>


</body>
</html>

