<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>员工信息管理</title>
		<link rel="stylesheet" type="text/css" href="../css/user.css"/>
		<script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>
	</head>
	<body>
		<div class="top">
			<img src="../images/coin01.png" class="icon1"/>
			<a href="aright.html" target="right">首页</a>
			<span>--餐厅管理--</span>
			<a href="user-list.jsp" target="right">员工管理</a>
		</div>
		<div class="add">
			<a href="<%=request.getContextPath()%>/admin/adduser.jsp" target="right">添加</a>	
			<form action="<%=request.getContextPath()%>/userAction-search" method="post">
				<input type="text" name="keyword" placeholder="请输入你要查询的员工姓名"/>
				<input type="submit" value="搜索"/>
			</form>
		</div>
		<div class="users">
			<table border="1" cellpadding="0" cellspacing="0" class="mytable">
				<tr>
					<th>编号</th>
					<th>账号</th>
					<th>密码</th>
					<th>姓名</th>
					<th>性别</th>
					<th>电话</th>
					<th>地址</th>
					<th>职位</th>
					<th>头像</th>
					<th>操作</th>
				</tr>
				<c:forEach var="user" items="${sessionScope.users }">
				<tr>
					<td>${user.id }</td>
					<td>${user.account }</td>
					<td>${user.pwd }</td>
					<td>${user.name }</td>
					<td>${user.sex }</td>
					<td>${user.phoneNumber }</td>
					<td>${user.address }</td>
					<td>${user.position.name }</td>
					<td><img alt="" src="${user.faceImg }" width="60px" height="60px"></td>
					<td>
						<a href="<%=request.getContextPath()%>/admin/updateuser.jsp?id=${user.id }" target="right">
							<img src="../images/update.png"/>
						</a>
						&nbsp;&nbsp;&nbsp;
						<a href="<%=request.getContextPath()%>/userAction-delete?id=${user.id }" target="right">
							<img src="../images/delete.png"/>
						</a>
					</td>
				</tr>
				</c:forEach>
			</table>
		</div>
		<div class="page">
			<a href="<%=request.getContextPath()%>/userAction-list?currentPage=1">首页</a>
			<a id="firstpage" href="<%=request.getContextPath()%>/userAction-list?currentPage=${sessionScope.currentPage-1 }">上一页</a>
			<a id="lastpage" href="<%=request.getContextPath()%>/userAction-list?currentPage=${sessionScope.currentPage+1 }">下一页</a>
			<a href="<%=request.getContextPath()%>/userAction-list?currentPage=${sessionScope.pageTotal }">尾页</a>
		</div>
		<div class="info">
			<span>当前是第${sessionScope.currentPage }页</span>
			<span>总共${sessionScope.pageTotal }页</span>
		</div>
	</body>
	<script type="text/javascript">
	
	</script>
</html>
