<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript"  src="http://localhost:8081/static/public/js/jquery-1.11.1.js"></script>
<script type="text/javascript"  src="http://localhost:8081/static/member/js/login.js"></script>

<link rel="stylesheet" type="text/css" media="screen"
	href="http://localhost:8081/static/public/css/layout.css" />
<link rel="stylesheet" type="text/css" media="screen"
	href="http://localhost:8081/static/public/css/login.css" />
<body>
	<div class="header"></div>
	<div class="main">
		<div class="container container-custom">
			<div class="row wrap-login">
				<div
					class="login-banner col-xs-6 col-sm-6 col-md-6 col-lg-6 hidden-xs">

				</div>
				<div class="login-user col-xs-12 col-sm-6 col-md-6 col-lg-5">
					<div class="login-part">
						<h3>帐号登录</h3>
						<div class="user-info">
							<div class="user-pass">

								<form id="fm1"
									action="/account/login;jsessionid=2BDCB5B6039F3F54712A3035A159AA66.tomcat1"
									method="post">

									<input  name="userName" tabindex="1"
										placeholder="输入用户名/邮箱" class="user-name" type="text" value="">
									<input  name="userPwd" tabindex="2"
										placeholder="输入密码" class="pass-word" type="password" value=""
										autocomplete="off">

									<div class="error-mess" style="display: none;">
										<span class="error-icon"></span><span id="error-message"></span>
									</div>
									<input class="logging"   value="登 录" tabindex="5" id="loginBtn"
										type="button">

								</form>
							</div>
						</div>
						<div class="line"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>