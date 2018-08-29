<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>菜品信息管理</title>
		<link rel="stylesheet" type="text/css" href="../css/user.css"/>
		<script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>
	</head>
	<body>
		<div class="top">
			<img src="../images/coin01.png" class="icon1"/>
			<a href="aright.html" target="right">首页</a>
			<span>--餐厅管理--</span>
			<a href="dish-list.jsp" target="right">菜品管理</a>
		</div>
		<div class="add">
			<a href="<%=request.getContextPath()%>/admin/adddish.jsp" target="right">添加</a>
			<a href="<%=request.getContextPath()%>/dishAction-export" target="right">导出菜品</a>
			<a href="javascript:void(0)" target="right" class="aimport">导入菜品</a>
			
			<form action="<%=request.getContextPath()%>/dishAction-search" method="post">
				<input type="text" name="keyword" placeholder="请输入你要查询的员工姓名"/>
				<input type="submit" value="搜索"/>
			</form>
		</div>
		<div class="users">
			<div class="dimport">
				<span>选择您要导入的Excel数据文件:</span>
				<form action="<%=request.getContextPath()%>/dishAction-dimport"
					method="post" enctype="multipart/form-data">
					<input type="file" name="myfile" class="filess"/>
					<input type="text" class="filetext"/>
					<button class="selectbtn" onclick="$('.filess').click();return false;">选择</button>
					<input type="submit" value="提交" class="mysubmit"/>
				</form>
			</div>
			<table border="1" cellpadding="0" cellspacing="0" class="mytable">
				<tr>
					<th>编号</th>
					<th>名称</th>
					<th>简述</th>
					<th>详述</th>
					<th>是否被推荐</th>
					<th>价格</th>
					<th>图片</th>
					<th>操作</th>
				</tr>
				<c:forEach var="dish" items="${sessionScope.dishes }">
				<tr>
					<td>${dish.id }</td>
					<td>${dish.name }</td>
					<td>${dish.description }</td>
					<td>${dish.txt }</td>
					<td>${dish.isRecommended }</td>
					<td>${dish.price }</td>
					<td><img alt="" src="${dish.img }" width="60px" height="60px"></td>
					<td>
						<a href="<%=request.getContextPath()%>/admin/updatedish.jsp?id=${dish.id }" target="right">
							<img src="../images/update.png"/>
						</a>
						&nbsp;&nbsp;&nbsp;
						<a href="<%=request.getContextPath()%>/dishAction-delete?id=${dish.id }" target="right">
							<img src="../images/delete.png"/>
						</a>
					</td>
				</tr>
				</c:forEach>
			</table>
		</div>
		<div class="page">
			<a href="<%=request.getContextPath()%>/dishAction-list?currentPage2=1">首页</a>
			<a id="firstpage" href="<%=request.getContextPath()%>/dishAction-list?currentPage2=${sessionScope.currentPage2-1 }">上一页</a>
			<a id="lastpage" href="<%=request.getContextPath()%>/dishAction-list?currentPage2=${sessionScope.currentPage2+1 }">下一页</a>
			<a href="<%=request.getContextPath()%>/dishAction-list?currentPage2=${sessionScope.pageTotal2 }">尾页</a>
		</div>
		<div class="info">
			<span>当前是第${sessionScope.currentPage2 }页</span>
			<span>总共${sessionScope.pageTotal2 }页</span>
		</div>
	
	</body>
	<script type="text/javascript">
		"<c:if test='${sessionScope.exportinfo !=null }'>"
			alert("${sessionScope.exportinfo}");
		"</c:if>"
		"<c:remove var='exportinfo' scope='session'/>"
		
	 $(".filess").change(function(){
	 	$(".filetext").val($(this).val());
	 });
	 
	 $(".aimport").click(function(){
	 	$(".dimport").toggle();
	 });
	</script>
</html>
