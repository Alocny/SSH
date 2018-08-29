<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>搜索结果显示</title>
		<link rel="stylesheet" type="text/css" href="../css/user.css"/>
		<script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>
	</head>
	<body>
		<div class="top">
			<img src="../images/coin01.png" class="icon1"/>
			<a href="admin.html" target="right">首页</a>
			<span>-- 餐厅管理 -- 菜品管理 -- 搜索结果</span>
		</div>
		<div class="add">
			<span>总共搜索到${sessionScope.countbykeydish }条信息</span>
		</div>
		<div class="users">
			<table border="1" cellpadding="0" cellspacing="0" class="mytable">
				<tr>
					<th>编号</th>
					<th>名称</th>
					<th>简述</th>
					<th>详述</th>
					<th>是否被推荐</th>
					<th>价格</th>
					<th>图片</th>
				</tr>
				<c:forEach var="dish" items="${sessionScope.showbykeydishes }">
				<tr>
					<td>${dish.id }</td>
					<td>${dish.name }</td>
					<td>${dish.description }</td>
					<td>${dish.txt }</td>
					<td>${dish.isRecommended }</td>
					<td>${dish.price }</td>
					<td><img alt="" src="${dish.img }" width="60px" height="60px"></td>
				</tr>
				</c:forEach>
			</table>
		</div>
	</body>
</html>
