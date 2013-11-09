<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
      <meta charset="utf-8">
    <title>Bootstrap 101 Template</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="../../assets/js/html5shiv.js"></script>
      <script src="../../assets/js/respond.min.js"></script>
    <![endif]-->
	<style>
	.universal_background {
 background: rgba(255, 255, 255,0.5);
   }
   .headtitle{font-weight:bold;
   font-size:18px;
   color:#e2e2e2;
   hover:color:#ffffff}
	</style>
  </head>
  <body style="background:#563d7c;background: url('seamless_polygon.jpg') repeat fixed center top #DFDFDF;
}">
  <nav class="navbar navbar-default " role="navigation" style="background:#563d7c">
  <!-- Brand and toggle get grouped for better mobile display -->
  <div class="navbar-header col-md-offset-2">
     <a class="navbar-brand" href="#"> <span class="glyphicon glyphicon-leaf" >
      </span> <span style="color:#E6DBC4 ;font-size:24px;" >Njust</span><span style="color:#e2e2e2;font-size:24px;">资料平台</span></a>
  </div>

  <!-- Collect the nav links, forms, and other content for toggling -->
  <div class="collapse navbar-collapse col-md-offset-5" id="bs-example-navbar-collapse-1">   
    <ul class="nav navbar-nav " style="font-weight:bold;font-size:18px;color:#0">
	<form class="navbar-form navbar-left form-inline" role="search">
      <div class="form-group form-inline">
        <input type="text" class=" input-sm well well-sm" style="background:#e2e2e2;border:0px" placeholder="搜索">
		  <button type="submit" class="btn btn-link"><span class="glyphicon glyphicon-search"></span></button>
      </div>
    
    </form>
      <li><a href="#" ><span   class="headtitle">首页</span></a></li>
	  <li><a href="#"   ><span   class="headtitle">分类</span></a></li>
	  <li><a href="#"   ><span   class="headtitle">发布</span></a></li>
 	  <li><a href="#"   ><span   class="headtitle">用户中心</span></a></li>
    </ul>
  </div><!-- /.navbar-collapse -->
  </nav>
 
 
 
  <div class=" container " style="width:980px;">
   <div class="row  " >
  
  <div class="col-md-8 ">
  <div class="panel panel-default universal_background" style="height:400px;margin=15px">  
  <div class="panel-heading">推荐置顶</div>
  <div class="panel-body">
    <p>...</p>
  </div></div></div> 
 
  <div class="col-md-4 "><div class="panel panel-default universal_background"  style="height:400px;margin=15px">  
  <div class="panel-heading">公告通知</div>
  <div class="panel-body">
    <p></p>
  </div></div></div>
</div>

 <div class="row  " >
<div class="col-md-6 " ><div class="panel panel-default universal_background" style="height:400px;margin=15px">  
  <div class="panel-heading">下载TOP10</div>
  <div class="panel-body">
     <p>...</p>
  </div></div></div>
  <div class="col-md-6 " ><div class="panel panel-default universal_background" style="height:400px;margin=15px">  
  <div class="panel-heading">评分TOP10</div>
  <div class="panel-body">
    <p>...</p>
  </div></div></div>
</div>
    <footer>
        <p>&copy; 2013 Company, Inc. &middot; <a href="#">Privacy</a> &middot; <a href="#">NJust软件项目管理</a></p>
      </footer>

</div>



    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery-1.8.3.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>