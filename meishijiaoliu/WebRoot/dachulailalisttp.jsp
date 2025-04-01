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
<title>大厨来啦</title>

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

<%

%>

<body>
<jsp:include page="qttop.jsp"></jsp:include>

<div class="content">
	<div class="wrap">
		<div class="pad0">
			<div class="s_title">
				<div class="name">大厨来啦</div>
				<div class="menu">
					
				</div>
			</div>
			<div class="det_con"> 
					
					
<form action="dcllListtp.do" name="myform" method="post">
									查询   菜名：<input name="caiming" type="text" id="caiming" style='border:solid 1px #000000; color:#666666' size="12" /> 菜系：<select name='caixi' id='caixi' style='border:solid 1px #000000; color:#666666;'><option value="">所有</option><option value="川菜">川菜</option><option value="鲁菜">鲁菜</option><option value="粤菜">粤菜</option><option value="闽菜">闽菜</option><option value="淮扬菜">淮扬菜</option><option value="浙菜">浙菜</option><option value="湘菜">湘菜</option><option value="徽菜">徽菜</option></select>
									<input type="submit" value="查询" /> <input type="button" name="Submit2" value="切换视图"  onClick="javascript:location.href='dcllList.do';" />
								</form>	
<br />

<table width="100%" height="12%" border="0" align="center" cellpadding="0" cellspacing="0">
                          <tr>
                          <%
					int i=0;
				%>
				<c:forEach items="${list}" var="u">
				<%
					i++;
				%>
                            <td align="center"><table width="150" height="153" border="0" cellpadding="0" cellspacing="0">
                                <tr>
                                  <td height="126" align="center"><a href="dcllDetail.do?id=${u.id}"><img src="${u.zhutu}" width="109" height="126" border="0" /></a></td>
                                </tr>
                                <tr>
                                  <td height="26" align="center">${u.caiming}</td>
                                </tr>
                            </table></td>
							  <%
								if (i==4)
								{
									i=0;
									out.print("</tr><tr>");
								}
				  	
					
				  %>
							</c:forEach>
							
                          
                          </tr>
                        </table><br>

<p align="center"> <c:if test="${sessionScope.p==1}">
		 <c:if test="${page.page>1}">
              <a href="dcllListtp.do?page=1" >首页</a>
             <a href="dcllListtp.do?page=${page.page-1}"> 上一页</a>             </c:if>
    	     <c:if test="${page.page<page.totalPage}">
			<a href="dcllListtp.do?page=${page.page+1}">下一页</a>
			<a href="dcllListtp.do?page=${page.totalPage}">末页</a>		    </c:if>		
	</c:if>
	</p>
					
			</div>	
		</div>
	</div>		
</div>
<jsp:include page="qtdown.jsp"></jsp:include>


</body>
</html>

