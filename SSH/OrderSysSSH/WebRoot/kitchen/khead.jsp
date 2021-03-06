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
		
		.msgdiv span{
			font-family: "微软雅黑";
			font-size: 15px;
			color: #333;
			line-height: 30px;
		}
		.msgdiv select{
			width: 60px;
			height: 30px;
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
	</style>
	<script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>
</head>
<body>
	<div class="logo">
		<img src="../images/logo.jpg">
	</div>
	<div class="msgdiv">
		<input type="text" name="msg" class="msg" placeholder="公告" readonly="readonly" />
	</div>
	<div class="user">
		<img src="../images/coin09.png" alt="">
		<span>当前身份：后厨</span>
		<span>账号：${sessionScope.kaccount }</span>
	</div>
	<div class="btn">
		<span><a href="" target="_parent">退出</a></span>
	</div>
</body>
<script type="text/javascript">
	$.ajaxSetup({
		contentType:"application/x-www-form-urlencoded; charset=utf-8"
	});
	setInterval(function(){
		$.post(
			"/OrderSysSSH/kitchenNoticeAction",
			{},
			function(data){
				$(".msg").val(data);
			},
			"text"
		);
	},1000);
</script>
</html>