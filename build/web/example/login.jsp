<%-- 
    Document   : login
    Created on : Nov 25, 2020, 9:01:57 PM
    Author     : thai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "s" uri = "/struts-tags"%>
<!DOCTYPE html>


<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="./login_style/images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="./login_style/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="./login_style/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="./login_style/vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="./login_style/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="./login_style/vendor/select2/select2.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="./login_style/css/util.css">
	<link rel="stylesheet" type="text/css" href="./login_style/css/main.css">
<!--===============================================================================================-->
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<div class="login100-pic js-tilt" data-tilt>
					<img src="./login_style/images/img-01.png" alt="IMG">
				</div>

                            <s:form action="loginAction" method="post" class="login100-form validate-form">
					<span class="login100-form-title">
						Member Login
					</span>

					<div class="wrap-input100 validate-input" data-validate = "Valid email is required: ex@abc.xyz">
						<input class="input100" type="text" name="username" placeholder="Username">
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-envelope" aria-hidden="true"></i>
						</span>
					</div>

					<div class="wrap-input100 validate-input" data-validate = "Password is required">
						<input class="input100" type="password" name="password" placeholder="Password">
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-lock" aria-hidden="true"></i>
						</span>
					</div>
					
					<div class="container-login100-form-btn">
                                            <button id="btnLogin" type="submit" class="login100-form-btn">
							Login
						</button>
					</div>

					<div class="text-center p-t-12">
						<span class="txt1">
                                                    <div id="divThongBao"></div>
						</span>
						<a class="txt2" href="#">
							<!--Username / Password?-->
						</a>
					</div>

					<div class="text-center p-t-136">
						<a class="txt2" href="#">
							<!--Create your Account-->
							<!--<i class="fa fa-long-arrow-right m-l-5" aria-hidden="true"></i>-->
						</a>
					</div>
				</s:form>
			</div>
		</div>
	</div>
	
	

	
<!--===============================================================================================-->	
	<script src="./login_style/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="./login_style/vendor/bootstrap/js/popper.js"></script>
	<script src="./login_style/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="./login_style/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="./login_style/vendor/tilt/tilt.jquery.min.js"></script>
	<script >
		$('.js-tilt').tilt({
			scale: 1.1
		})
	</script>
<!--===============================================================================================-->
<script src="example/javascript/loginJS.js" type="text/javascript"></script>
	<script src="./login_style/js/main.js"></script>
    </body>
</html>
