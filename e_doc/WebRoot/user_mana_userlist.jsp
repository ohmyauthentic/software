<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">  
<title>Bootstrap 101 Template</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<link rel="stylesheet" type="text/css" href="css/user_mana_style.css">
<link rel="stylesheet" type="text/css" href="css/user_mana_button.css">
<link href="css/tableList.css" rel="stylesheet" media="screen">	
<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
	
      <script src="../../assets/js/html5shiv.js"></script>
      <script src="../../assets/js/respond.min.js"></script>
    <![endif]-->

<style>
.universal_background {
	background: rgba(255, 255, 255, 0.5);
}

.headtitle {
	font-weight: bold;
	font-size: 18px;
	color: #e2e2e2;
}

.headtitle:hover {
	color: #ffffff;
}
</style>
</head>
<body
	style="background:#563d7c;background: url('images/seamless_polygon.jpg') repeat fixed center top #DFDFDF;}">
	<nav class="navbar navbar-default " role="navigation"
		style="background:#563d7c">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header col-md-offset-2">
			<a class="navbar-brand" href="#"> <span
				class="glyphicon glyphicon-leaf"> </span> <span
				style="color:#F7E66A ;font-size:24px;">Njust</span><span
				style="color:#fff;font-size:24px;">资料平台</span>
			</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse col-md-offset-5"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav "
				style="font-weight:bold;font-size:18px;color:#0">
				<form class="navbar-form navbar-left form-inline" role="search">
					<div class="form-group form-inline">
						<input type="text" class=" input-sm"
							style="background:#e2e2e2;border:0px" placeholder="搜索">
						<button type="submit" class="btn btn-link">
							<span class="glyphicon glyphicon-search"></span>
						</button>
					</div>

				</form>
				<li><a href="home.html"><span class="headtitle ">首页</span>
				</a>
				</li>
				<li><a href="#"><span class="headtitle">分类</span>
				</a>
				</li>
				<li><a href="post.html"><span class="headtitle">发布</span>
				</a>
				</li>
				<li><a href="#" data-toggle="modal" data-target="#login"><span
						class="headtitle">用户中心</span>
				</a>
				</li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</nav>

	<!--下面添加内容-->

	<div class="right">
    	<h2 align="center"><span>菜单</span> </h2>
          <ul>
            <li><a href="#"> 主页</a></li>
            <li ><a href="UserList.action?page=1" style="color: rgb(28, 108, 122);">用户列表</a></li>
            <li><a href="user_mana_psword.jsp" >修改密码</a></li>
            <li> <a href="manlogout.action">注销</a></li>
            
          </ul>
    </div>
    <div class="userlist">
		<center><h1>用户列表</h1></center>
		<form name="form1" action="delAndModUser.action" method="post" onsubmit="return listState();">
		<table class="table table-bordered">
			<tr >
			    <th>选中</th><th>用户名</th><th>经验值</th><th>等级</th>
			</tr>
			<s:iterator value="pageBean.list" status="st">
				<tr <s:if test="#st.odd"> class="warning"</s:if> <s:else> class="info"</s:else>>
					<td><input style="width: 20;" type="checkbox" name="choice" value="<s:property value="username" />"></td>
					<td><s:property value="username" /></td>
					<td><s:property value="experience" /></td>
					<td><s:property value="rank" /></td>
				</tr>
			</s:iterator>
		</table>
    	<button id="tianjia" class="btn  btn-primary" style="margin-left: 100px;margin-top: 50px;width:100px;" type="button"><span class="glyphicon glyphicon-plus"  ></span>添加</button>
        <button id="xiugai" class="btn  btn-primary" style="margin-left: 100px;margin-top: 50px;width:100px;" type="submit" onclick="Modify()"><span class="glyphicon glyphicon-edit"  ></span>修改</button>
        <button id="shanchu" class="btn  btn-primary" style="margin-left: 100px;margin-top: 50px;width:100px;" type="submit" onclick="ProDelete()" ><span class="glyphicon glyphicon-trash"  ></span>删除</button>
        <input type="hidden" name="tag"/>
      </form>
      <center>
		 共<s:property value="pageBean.allRow" />	条记录
		 共<s:property value="pageBean.totalPage"/>页 
		 当前第<s:property value="pageBean.currentPage" />页<br /><br>
		<s:if test="%{pageBean.currentPage == 1}">  第一页 上一页   </s:if>
		<s:else>
			<a href="UserList.action?page=1">第一页</a>
			<a href="UserList.action?page=<s:property value="%{pageBean.currentPage-1}"/> ">上一页</a>
		</s:else>
		<s:if test="%{pageBean.currentPage != pageBean.totalPage}">
			<a href="UserList.action?page=<s:property value="%{pageBean.currentPage+1}"/> ">下一页</a>
			<a href="UserList.action?page=<s:property value="pageBean.totalPage"/> ">最后一页</a>
		</s:if>
		<s:else> 下一页  最后一页  </s:else>
      </center>
    </div>
  <div id="tianjiauser" class="white_content">
  <form action="adduser.action" method="post">
  		<div class="container_input" style="margin-top: 50px;">
    		<label for="uername">用户名：</label>
    		<input id="username" type="text" placeholder="用户名" name="username">
    	</div>
    	<div class="container_input" style="margin-top: 50px;" >
    		<label for="psword1">密码：</label>
    		<input id="psword1" type="password" placeholder="密码" name="password1">
    	</div>
    	<div class="container_input" style="margin-top: 50px;">
    		<label for="psword2">确认密码：</label>
    		<input id="psword2" type="password" placeholder="确认密码" name="password2">
    	</div>
    	<input id="tqueding" class="btn  btn-primary" type="submit" value="确定" style="margin-left: 150px;margin-top: 50px;width:100px;">
    	<input id="tquxiao" class="btn  btn-primary" type="reset" value="取消" style="margin-left: 100px;margin-top: 50px;width:100px;">
  </form>
  </div>
  <div id="xiugaiuser" class="white_content">
  
  </div>
  <div id="fade" class="black_overlay"></div>




	<div id="footer">
		<p>
			&copy; 2013 Company, Inc. &middot; <a href="#">Privacy</a> &middot; <a
				href="#">NJust软件项目管理</a>
		</p>
	</div>

	<div class="modal fade" id="login" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<form class="form-signin ">
			<div class="modal-dialog" style="width:400px">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true" backdrop="false">&times;</button>
						<h4 class="modal-title" id="myModalLabel">登入</h4>
					</div>
					<div class="modal-body ">

						<h2 class="form-signin-heading">请登入</h2>

						<input type="text" class="form-control" placeholder="用户名"
							autofocus=""> <br /> <input type="password"
							class="form-control" placeholder="密码"> <label
							class="checkbox"> <input type="checkbox"
							value="remember-me">记住我 </label> <a data-toggle="modal"
							data-target="#register">没有账号？注册</a>
					</div>
					<div class="modal-footer">
						<button class="btn btn-lg btn-primary " type="submit">登入</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</form>
	</div>
	<!-- /.modal -->
	<div class="modal fade" id="register" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<form class="form-signin ">
			<div class="modal-dialog" style="width:400px">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true" backdrop="false">&times;</button>
						<h4 class="modal-title" id="myModalLabel">注册</h4>
					</div>
					<div class="modal-body ">

						<h2 class="form-signin-heading">注册</h2>

						<input type="text" class="form-control" placeholder="用户名"
							autofocus=""> <br /> <input type="password"
							class="form-control" placeholder="密码"> <br /> <input
							type="password" class="form-control" placeholder="确认密码">



					</div>
					<div class="modal-footer">
						<button class="btn btn-lg btn-primary " type="submit">注册</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</form>
	</div>
	<!-- /.modal -->
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="js/jquery-1.8.3.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>
	<script type="text/javascript">
  	$(document).ready(function(){
  		$("#fade").css("height",Math.max(document.documentElement.scrollHeight, document.documentElement.clientHeight));
    	$("#fade").css("width",document.documentElement.scrollWidth);
  		$("#tianjia").mousedown(function(){
  			
	    	 	
	    });
	    $("#tianjia").mouseup(function(){
	    	
	    	$("#fade").css("display","block");
	    	$("#tianjiauser").slideDown(800);
	    });
	    $("#xiugai").mousedown(function(){
  			
	    	  	
	    });
	    $("#xiugai").mouseup(function(){
	    	
	    	$("#fade").css("display","block");
	    	$("#xiugaiuser").slideDown(800);
	    });
	    $("#shanchu").mousedown(function(){
  			
	    	    	
	    });
	    $("#shanchu").mouseup(function(){
	    	
	    });
	    $("#tqueding").mousedown(function(){
  			
	    	  	
	    });
	    $("#tquxiao").mousedown(function(){
  			
	    	    	
	    });
	    $("#tquxiao").mouseup(function(){
	    	
	    	$("#tianjiauser").hide();   	
	    	$("#fade").css("display","none");
	    });
	    $("#xqueding").mousedown(function(){
  			
	    	    	
	    });
	    $("#xquxiao").mousedown(function(){
  			
	    	    	
	    });
	    $("#xquxiao").mouseup(function(){
	    	
	    	$("#tianjiauser").hide();   	
	    	$("#fade").css("display","none");
	    });
  	});
  </script>
  
  <script type="text/javascript">
       var t;
	   function Modify() {
		  var b = document.getElementsByName("choice");
		  var fg = false;
		  //判断是否选中多选按钮
		  var count=0;
		  for ( var i = 0; i < b.length; i++) {
			if (b[i].checked) {
				count++;
			 }
		  }
		  if(count==0){
			 t=false;
			 alert("请选择要修改的用户!");	
		  }
		  else if(count>1){
			  t=false;
			  alert("一次只能修改一个用户!");	
		  }
		  else{
			  var tag =1;t=true;
		      form1.tag.value = tag;		
		  }
	   }
	   function ProDelete() {
		   var b = document.getElementsByName("choice");
		   var fg = false;
		   //判断是否选中多选按钮
		   for ( var i = 0; i < b.length; i++) {
			   if (b[i].checked) {
				  fg = true; break;
			    }
		   }
		   if (fg) {
			  if (confirm("确认删除?")) {
				  var tag = 2;t=true;
				  form1.tag.value = tag;
			  }
		   } 
		   else {
		    	t=false; alert("请选择要删除的用户!");
		   }
	   }
	   function listState(){
		   if(t) return true;
		   else return false;
	   }	   
  </script> 
</body>
</html>