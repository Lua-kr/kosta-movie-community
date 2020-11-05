<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--[if IE 7]>
<html class="ie ie7 no-js" lang="en-US">
<![endif]-->
<!--[if IE 8]>
<html class="ie ie8 no-js" lang="en-US">
<![endif]-->
<!--[if !(IE 7) | !(IE 8)  ]><!-->
<html lang="en" class="no-js">

<!-- userprofile_light16:31-->
<head>
<!-- Basic need -->
<title>Open Pediatrics</title>
<meta charset="UTF-8">
<meta name="description" content="">
<meta name="keywords" content="">
<meta name="author" content="">
<link rel="profile" href="#">

<!--Google Font-->
<link rel="stylesheet"
	href='http://fonts.googleapis.com/css?family=Dosis:400,700,500|Nunito:300,400,600' />
<!-- Mobile specific meta -->
<meta name=viewport content="width=device-width, initial-scale=1">
<meta name="format-detection" content="telephone-no">

<!-- CSS files -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/plugins.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">


<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	
</script>


</head>
<body>
	<!--login form popup-->
	<div class="login-wrapper" id="signup-content">
		<div class="login-content">
			<a href="#" class="close">x</a>
			<h3>Login</h3>
			<div class="row">
				<div class="social-btn-2">
					<a class="fb" href="#"><i class="ion-social-facebook"></i>Facebook</a>
				</div>
			</div>
			<div class="row">
				<div class="social-btn-2">
					<a class="tw" href="#"><i class="ion-social-twitter"></i>twitter</a>
				</div>
			</div>
		</div>
	</div>
	<!--end of login form popup-->

	<!-- BEGIN | Header -->
	<%@include file="../header.jsp"%>
	<!-- END | Header -->

	<div class="hero user-hero">
		<div class="container">
			<div class="row">
				<div class="col-md-12"></div>
			</div>
		</div>
	</div>
	<div class="buster-light">
		<div class="page-single">
			<div class="container">
				<div class="row ipad-width">
					<div class="col-md-3 col-sm-12 col-xs-12">
						<div class="sidebar" data-color="purple"
							data-background-color="white">
							<a href="#" id="" class="simple-text logo-mini"><h3>즐겨찾기</h3></a><br>
							<div class="sidebar-wrapper">
								<div class="sidebar-inner-list">
									<ul class="nav" id="nav">
										<li class="nav-item active" id="li">
											<!-- your sidebar here -->
									</ul>

								</div>
							</div>
						</div>
					</div>
					
					<!-- your content here -->
					<iframe
						src="${pageContext.request.contextPath}/mainView/community/userFavoritelistCenter.jsp"
						name="center" width="1150px;" height="700px;" frameborder="0"></iframe>
						
				</div>
			</div>
		</div>
	</div>
	<!-- footer section-->
	<%@include file="../footer.jsp"%>
	<!-- end of footer section-->

	<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
	<script src="${pageContext.request.contextPath}/js/plugins.js"></script>
	<script src="${pageContext.request.contextPath}/js/plugins2.js"></script>
	<script src="${pageContext.request.contextPath}/js/custom.js"></script>
</body>

<!-- userprofile_light16:31-->
</html>