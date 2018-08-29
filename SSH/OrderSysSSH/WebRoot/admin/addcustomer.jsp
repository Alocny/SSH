<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>增加客户信息</title>
		<style type="text/css">
			*{
				margin: 0px;
				padding: 0px;
			}
			.top{
				width: 100%;
				height: 60px;
				background-color: #ddd;
			}
			.top a,span{
				font-family: "微软雅黑";
				font-size: 18px;
				line-height: 60px;
			}
			.top a{
				text-decoration: none;
				color: #3695CC;
			}
			.top img{
				margin-left: 30px;
				position: relative;
				top: 3px;
				padding-right: 10px;
			}
			
			.updateuser{
				width: 96%;
				height: 600px;
				border: 2px solid #ddd;
				margin: 20px 30px;
			}
			.updateuser form{
				margin-left: 60px;
			}
			.updateuser form span{
				font-family: "微软雅黑";
				font-size: 20px;
				line-height: 30px;
			}
			.updateuser form input[type="text"]{
				width: 300px;
				height: 30px;
			}
			.updateuser p{
				margin-top: 15px;
			}
			.updateuser form input[type='submit']{
				font-family: "微软雅黑";
				font-size:20px;
				color: #333;
				width: 135px;
				height: 40px; 
				margin-top: 10px;
				background-color: #3695CC;
				border: none;
				color: #fff;
			}
			.updateuser form input[type='reset']{
				font-family: "微软雅黑";
				font-size:20px;
				color: #333;
				width: 135px;
				height: 40px; 
				margin-top: 10px;
				margin-left: 80px;
				background-color: #3695CC;
				border: none;
				color: #fff;
			}
			
			.updateuser form select{
				width: 303px;
				height: 33px;
			}
			
			.updateuser form input[type="file"]{
				width: 300px;
				height: 30px;
				border: 1px solide #ccc;
			}
		</style>
		<script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>
	</head>
	<body>
		<div class="top">
			<img src="../images/coin01.png" class="icon1"/>
			<a href="admin.html" target="right">首页</a>
			<span>--餐厅管理--客户管理--增加客户信息</span>
		</div>
		<div class="updateuser">
			<!-- ${param.id }取得上一个页面的参数id的值 -->
			<form action="<%=request.getContextPath()%>/customerAction-add" 
				method="post">
				<p>
					<span>客户姓名:</span>
					<input type="text" name="name" />
				</p>
				<p>
					<span>客户性别:</span>
					<input type="text" name="sex" />
				</p>
				<p>
					<span>手机号码:</span>
					<input type="text" name="phoneNumber" />
				</p>
				<p>
					<span>消费次数:</span>
					<input type="text" name="dinningTimes" />
				</p>
				<p>
					<span>消费总和:</span>
					<input type="text" name="dinningSum" />
				</p>							
				<p>
					<input type="submit" value="增加"/>
					<input type="reset" value="取消"/>
				</p>
			</form>
		</div>
	</body>
	<script type="text/javascript">

	</script>
</html>
