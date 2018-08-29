<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>餐桌信息管理</title>
		<link rel="stylesheet" type="text/css" href="../css/user.css"/>
		<script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>
	</head>
	<body>
		<div class="top">
			<img src="../images/coin01.png" class="icon1"/>
			<a href="aright.html" target="right">首页</a>
			<span>--餐厅管理--</span>
			<a href="table-list.jsp" target="right">餐桌管理</a>
		</div>
		<div class="add">
			<a href="<%=request.getContextPath()%>/admin/addtable.jsp" target="right">添加</a>	
		</div>
		<div class="users">
			<table border="1" cellpadding="0" cellspacing="0" class="mytable">
				<tr>
					<th>编号</th>
					<th>是否空闲</th>
					<th>餐桌大小</th>
					<th>操作</th>
				</tr>
				<c:forEach var="table" items="${sessionScope.tables }">
				<tr>
					<td>${table.id }</td>
					<td>${table.isFree }</td>
					<td>${table.size }</td>
					<td>
						<a href="<%=request.getContextPath()%>/admin/updatetable.jsp?id=${table.id }" target="right">
							<img src="../images/update.png"/>
						</a>
						&nbsp;&nbsp;&nbsp;
						<a href="<%=request.getContextPath()%>/tableAciton-delete?id=${table.id }" target="right">
							<img src="../images/delete.png"/>
						</a>
					</td>
				</tr>
				</c:forEach>
			</table>
		</div>
		<div class="page">
			<a href="<%=request.getContextPath()%>/tableAciton-list?currentPage5=1">首页</a>
			<a id="firstpage" href="<%=request.getContextPath()%>/tableAciton-list?currentPage5=${sessionScope.currentPage5-1 }">上一页</a>
			<a id="lastpage" href="<%=request.getContextPath()%>/tableAciton-list?currentPage5=${sessionScope.currentPage5+1 }">下一页</a>
			<a href="<%=request.getContextPath()%>/tableAciton-list?currentPage5=${sessionScope.pageTotal5 }">尾页</a>
		</div>
		<div class="info">
			<span>当前是第${sessionScope.currentPage5 }页</span>
			<span>总共${sessionScope.pageTotal5 }页</span>
		</div>
	</body>
	<script type="text/javascript">
	
	</script>
</html>
