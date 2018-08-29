<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>客户信息管理</title>
		<link rel="stylesheet" type="text/css" href="../css/user.css"/>
		<script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>
	</head>
	<body>
		<div class="top">
			<img src="../images/coin01.png" class="icon1"/>
			<a href="aright.html" target="right">首页</a>
			<span>--餐厅管理--</span>
			<a href="customer-list.jsp" target="right">客户管理</a>
		</div>
		<div class="add">
			<a href="<%=request.getContextPath()%>/admin/addcustomer.jsp" target="right">添加</a>	
			<form action="<%=request.getContextPath()%>/customerAction-search" method="post">
				<input type="text" name="keyword" placeholder="请输入你要查询的员工姓名"/>
				<input type="submit" value="搜索"/>
			</form>
		</div>
		<div class="users">
			<table border="1" cellpadding="0" cellspacing="0" class="mytable">
				<tr>
					<th>编号</th>
					<th>姓名</th>
					<th>性别</th>
					<th>手机号</th>
					<th>消费次数</th>
					<th>消费总和</th>
					<th>操作</th>
				</tr>
				<c:forEach var="customer" items="${sessionScope.customers }">
				<tr>
					<td>${customer.id }</td>
					<td>${customer.name }</td>
					<td>${customer.sex }</td>
					<td>${customer.phoneNumber }</td>
					<td>${customer.dinningTimes }</td>
					<td>${customer.dinningSum }</td>
					<td>
						<a href="<%=request.getContextPath()%>/admin/updatecustomer.jsp?id=${customer.id }" target="right">
							<img src="../images/update.png"/>
						</a>
						&nbsp;&nbsp;&nbsp;
						<a href="<%=request.getContextPath()%>/customerAction-delete?id=${customer.id }" target="right">
							<img src="../images/delete.png"/>
						</a>
					</td>
				</tr>
				</c:forEach>
			</table>
		</div>
		<div class="page">
			<a href="<%=request.getContextPath()%>/customerAction-list?currentPage3=1">首页</a>
			<a id="firstpage" href="<%=request.getContextPath()%>/customerAction-list?currentPage3=${sessionScope.currentPage3-1 }">上一页</a>
			<a id="lastpage" href="<%=request.getContextPath()%>/customerAction-list?currentPage3=${sessionScope.currentPage3+1 }">下一页</a>
			<a href="<%=request.getContextPath()%>/customerAction-list?currentPage3=${sessionScope.pageTotal3 }">尾页</a>
		</div>
		<div class="info">
			<span>当前是第${sessionScope.currentPage3 }页</span>
			<span>总共${sessionScope.pageTotal3 }页</span>
		</div>
	</body>
	<script type="text/javascript">
	
	</script>
</html>
