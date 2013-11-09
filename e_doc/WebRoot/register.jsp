<%@ page language="java" import="java.util.*" pageEncoding="GBK" contentType="text/html;charset=GBK"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    <title>注册</title>    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<link rel="stylesheet" href="css/form5.css" type="text/css" media="screen" title="no title" />

  </head>
  <body>
   
			
			<div id="wrapper">
				<div id="register" class="form animate">
					<form action="userregister.action" method="post" autocomplete="on">
						<h1><span style="font-size: 12px;">注册</span></h1>
						<div>
							<label for="username" class="uname" >用户名</label>
							<input type="text" name="username" placeholder="请输入用户名" required="required"  id="usernamesignup" />
						</div>			
						<div>
							<label for="password1" class="youpasswd" >登录密码</label>
							<input type="password" name="password1" required="required" placeholder="请输入密码" id="passwordsignup" />
						</div>	
						<div>
							<label for="password2"  class="youpasswd">确认密码</label>
							<input type="password" name="password2" required="required" placeholder="再次输入密码" id="passwordsignup_confirm" />
						</div>	
						<div class="signin button">
							<input type="submit" value="注册" />
						</div>	 	
						<div class="change_link">
							已经有账号了 ？ <a href="login.jsp" class="to_register">快来登录吧</a>
						</div>
					</form>
				</div>
				
				
				
			</div>

  </body>
</html>
