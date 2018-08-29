<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>登录页面</title>
	<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
	<style type="text/css">
		*{
			margin:0px;
			padding: 0px;
		}
		body{
			width: 100%;
			height: 100%;
			background: url("images/img_bg_1.jpg") no-repeat;
			background-size:cover;
		}
		.main{
			width: 350px;
			height: 420px;
			margin-top: 120px;
			margin-left: 65%;
			background: rgba(0,0,0,0.5);
			border-top: 10px solid #FBB448
		}
		.info{
			width: 200px;
			height: 50px;
			margin-top:10px;
			margin-left: 50px;
		}
		.info span{
			font-family: "微软雅黑";
			font-size: 30px;
			color: #fff;
		}
		form{
			margin-left: 50px;
		}
		form p{
			margin-top: 10px;
		}
		form p span{
			font-family: "微软雅黑";
			font-size: 18px;
			color: #fff;
		}
		
	
		form input[name="account"],input[name="pwd"]{
			width: 250px;
			height: 35px;
			background: rgba(0,0,0,0.5);
			color: #fff;
			font-size: 18px;
		}
		
		form input[name="codenum"]{
			width: 80px;
			height: 35px;
			background: rgba(0,0,0,0.5);
			color: #fff;
			font-size: 18px;
		}


		form input[type="submit"]{
			width: 250px;
			height: 35px;
			background-color: #FBB448;
			border:2px solid #FBB448;
			margin-top: 10px;
			font-family: "微软雅黑";
			font-size: 20px;
			color: #fff;
		}
		.verifycode{
			background-color: red;
		}
		.main .err{
			width: 320px;
			height: 50px;
			margin-top: 10px;
			margin-left: 50px;
		}
	</style>
</head>
<body>
	<div class="main">
		<div class="info">
			<span>点餐系统</span>
		</div>
		<form action="loginAction" method="post">
			<p>
				<span>账号</span>
			</p>
			<p>
				<input type="text" name="account"/>
			</p>
			<p>
				<span>密码</span>
			</p>
			<p>
				<input type="password" name="pwd"/>
			</p>
			<p>
				<span>验证码</span>
			</p>
			<p>
				<input type="text" name="codenum" class="codenum"/>
				<span>
					<img alt="加载失败" src="image.jsp" class="myimg" 
						style="position:relative;top:13px;left:15px;"
						onClick="this.src='image.jsp?' + new Date().getTime();" 
						title="点击更换验证码">
				<!-- IE会有缓存，如果同样的请求路径，有时候则不会重新请求，解决这个问题，只要换个请求路径即可。 -->
				</span>
				<span class="yes" style="position:relative;left:20px;display: none;">√√√</span>
				<span class="no" style="position:relative;left:20px;display: none;">×××</span>
			</p>
			<p>
				<input type="submit" value="登录"/>
			</p>
		</form>
		<div class="err" style="color:red;">
			 ${sessionScope.error }
		</div>
	</div>
</body>
<script type="text/javascript">
	var flag=false;
	function sleep(n){
		var start = new Date().getTime();
		while(true){
			if(new Date().getTime()-start>n){
				break;
			}
		}
	}
	$(".codenum").blur(function(){
		var codenum=$(".codenum").val();
		$.post(
			"verifycode",
			{"codeNum":codenum},
			function(msg){
				if(msg=="yes"){
					$(".yes").show();
					$(".no").hide();
					flag=true;
				}else{
					$(".no").show();
					$(".yes").hide();
					flag=false;
				}
			},
			"text"
		);
	});
	$("form").submit(function(){
		$(".codenum").blur();
		sleep(1000);
		var name = $("input[name='account']").val();
		var pass = $("input[name='pwd']").val();
		var codenum = $("input[name='codenum']").val();
		if ((name == null || name == "")||(pass==null||pass=="")||(codenum==null||codenum=="")||flag==false) {
			$(".err").html("请输入用户名、密码和验证码").css({"font-family":"微软雅黑","font-size":"18px","color":"red"});
			$("input[name='account']").val("");
			$("input[name='pwd']").val("");
			$("input[name='codenum']").val("");
			$("input[name='account']").focus();
			$(".myimg").click();
			return false;
		}
	});
	
</script>
</html>