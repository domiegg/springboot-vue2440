﻿<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<div class="header">
	<div class="wrap">
		<div class="head_top">
			<div class="logo fl"><a href="#"><img src="qtimages/logo.gif" width="79" height="78"/></a></div>
			<div style="position:absolute; top:30px; margin-left:130px;">
				<div style="font-family:宋体; color:#666666; WIDTH: 100%; FONT-WEIGHT: bold; FONT-SIZE: 19pt; margin-top:5pt">
                    <div align="left">长诗圣地美食交流分享平台</div>
                </div>
			</div>
			<div style="float:right"> 
			
			<%
    if((String)request.getSession().getAttribute("username")==null || (String)request.getSession().getAttribute("username")==""){
     %>
               <a href="userlog.jsp">用户登陆</a> | <a href="userreg.jsp">用户注册</a>
				 <%
							}
				  else
				  {
				 %>
				当前用户:<%=request.getSession().getAttribute("username")%>,权限:<%=request.getSession().getAttribute("cx")%>; <a href="logout.jsp">退出</a>|<a href="main.jsp">个人后台</a>
				  <%
				  }
				  %>
				  
			
			
			</div>
			<div class="phone fr"><img src="qtimages/phone.jpg"/></div>
			<div class="clear"></div>
		</div>
	</div>
	<div class="nav_bar">
		<div class="wrap">
			<div class="nav">
				<ul>
					<li id="m4" class="m"><h3><a href="index.do">首页</a></h3></li>
					<%-- <li id="m4" class="m"><h3><a href="dx_detail.jsp?lb=系统简介">系统简介</a></h3></li> --%>
					<%-- <li id="m2" class="m">
						<h3><a>八大菜系</a></h3>
						<ul class="sub">
						  <li><a href="xwtzList.do?lb=八大菜系">A新闻</a></li>
						  <li><a href="xwtzList.do?lb=八大菜系">B新闻</a></li>
						
						</ul>
					</li>
					<li id="m3" class="m">
						<h3><a href="#">八大菜系</a></h3>
						<ul class="sub">
						  <li><a href="#">基础效果</a></li>
						  <li><a href="#">基础效果</a></li>
						  <li><a href="#">基础效果</a></li>
						  <li><a href="#">基础效果</a></li>
						</ul>
					</li> --%>
					<li id="m4" class="m"><h3><a href="xwtzList.do?lb=八大菜系">八大菜系</a></h3></li>
					<li id="m4" class="m"><h3><a href="xwtzList.do?lb=风俗小吃">风俗小吃</a></h3></li>
					<li id="m4" class="m"><h3><a href="sqmsList.do">社区美食</a></h3></li>
					<li id="m4" class="m"><h3><a href="dcllList.do">大厨来啦</a></h3></li>
					<li id="m4" class="m"><h3><a href="msdpList.do">美食店铺</a></h3></li>
					<%-- <li id="m2" class="m">
						<h3><a >在线留言</a></h3>
						<ul class="sub">
						  <li><a href="lyb.jsp">我要留言</a></li>
						  <li><a href="lybList.do">查看留言</a></li>

						</ul>
					</li> --%>
					<%-- <li id="m4" class="m"><h3><a href="userreg.jsp">用户注册</a></h3></li> --%>
					<li id="m4" class="m"><h3><a href="login.jsp">后台管理</a></h3></li>
				</ul>
			</div>
			<div class="search">
				<div class="s_pad">
					<form id="formsearch" name="formsearch" method="post" action="xwtzList.do">
						<input type="text" name="biaoti" id="biaoti" value="" class="ss_txt"/>
						<input type="submit" name="dl" id="button" value="" class="ss_bott"  hidefocus />
					</form>
				</div>
			</div>
			<div class="clear"></div>
		</div>
	</div>
</div>
