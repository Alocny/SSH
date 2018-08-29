<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>头页面</title>
	<style type="text/css">
		*{
			margin:0px;
			padding: 0px;
		}
		body{
			background-color: #f9f9f9;
		}
		.btn{
			width: 60px;
			height: 30px;
			text-align: center;
			position: fixed;
			top:10px;	
			right: 20px;
		}
		.btn span{
			font-family: "微软雅黑";
			font-size: 15px;
			color: #2b70d7;
			line-height: 30px;
		}
		.btn span a{
			text-decoration: none;
			color:#2b70d7;
		}
		.btn:hover span{
			color: #8825ad;
			cursor: pointer;
		}
		.logo{
			margin-left: 80px;
			margin-top: 14px;
			width: 100px;
			float: left;
		}
		.logo img{
			width: 90px;
			height: 30px;
		}
		.msgdiv{
			width: 400px;
			margin:14px 80px;
			float: left;
		}
		.msgdiv input[type="text"]{
			width: 260px;
			height: 30px;

		}
		.msgdiv input[type="button"]{
			width: 100px;
			height: 33px;
			background-color: #46A7E4;
			border: 1px solid #2075D5;
			font-family: "微软雅黑";
			font-size: 18px;
			color: #fff;
		}
		.msgdiv input[type="button"]:hover{
			cursor: pointer;
			background-color: #317ED5;
		}

		.user{
			width: 300px;
			height: 30px;
			text-align: center;
			position: fixed;
			top:10px;	
			right: 60px;
			font-family: "微软雅黑";
			font-size: 15px;
			color: #333;
			line-height: 30px;
		}
		.user img{
			width: 18px;
			height: 18px;
			position: relative;
			top: 3px;
		}
		.send{
			position: relative;
			top:2px;
		}
	</style>
	<script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>
</head>
<body>
	<div class="logo">
		<img src="../images/logo.jpg">
	</div>
	<div class="msgdiv">
		<input type="text" name="msg" class="msg" placeholder="发布公告" />
		<input type="button" value="提交" class="send"/>
	</div>
	<div class="user">
		<img src="../images/coin09.png" alt="">
		<span>当前身份：管理员</span>
		<span>账号：${sessionScope.aacount }</span>
	</div>
	<div class="btn">
		<span><a href="" target="_parent">退出</a></span>
	</div>
</body>
<script type="text/javascript">
	$.ajaxSetup({
		contentType:"application/x-www-form-urlencoded; charset=utf-8"
	});
	$(".send").click(function(){
		var message=$(".msg").val();
		$.post(
			"/OrderSysSSH/managerNoticeAction",
			{"message":message},
			function(data){
				alert("公告发送成功！");
			},
			"text"
		);
	});
</script>
</html>