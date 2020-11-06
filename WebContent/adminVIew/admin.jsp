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
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/plugins.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<link href="assets/css/material-dashboard.css?v=2.1.2" rel="stylesheet" />

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#user").click(function() {
			$("#userList").slideToggle(500, function() {
				$("#userList").click(function() {
					center.location.href = "${pageContext.request.contextPath}/admin/user/userList.jsp";
				});//click
			});//slideToggle

			$("#blackList").slideToggle(500, function() {
				$("#blackList").click(function() {
					center.location.href = "${pageContext.request.contextPath}/admin/user/blackList.jsp";
				});//click
			});//slideToggle

		});//click

		$("#board").click(function() {
			$("#freeList").slideToggle(500, function() {
				$("#freeList").click(function() {
					center.location.href = "admin/board/freeboard.jsp";
				});//click
			});//slideToggle

			$("#reviewList").slideToggle(500, function() {
				$("#reviewList").click(function() {
					center.location.href = "admin/board/reviewboard.jsp";
				});//click
			});//slideToggle

			$("#delete").slideToggle(500, function() {
				$("#delete").click(function() {
					center.location.href = "admin/board/deleteboard.jsp";
				});//click
			});//slideToggle

		});//click

		$("#notice").click(function() {
			center.location.href = "admin/notice/notice.jsp";
		});//click

		$("#point").click(function() {
			center.location.href = "admin/point/point.jsp";
		});//click

	});//function
</script>


</head>
<body>
	<div class="wrapper ">
		<div class="sidebar" data-color="purple" data-background-color="white">
			<!--
      Tip 1: You can change the color of the sidebar using: data-color="purple | azure | green | orange | danger"

      Tip 2: you can also add an image using data-image tag
  -->
			<div class="logo">
				<a href="template.html" class="simple-text logo-mini"> 관리자 모드 </a> 
			</div>
			<div class="sidebar-wrapper">
				<div class="sidebar-inner-list">
				
				<ul class="nav" id="nav">
					<li class="nav-item active" id="li">
					<a class="nav-link" href="#0">
						<i class="material-icons">dashboard</i>
						<p id="user">회원관리</p>
						<p id="userList" style="display: none; margin-left: 62px;">유저List</p>
						<p id="blackList" style="display: none; margin-left: 62px;">블랙리스트</p>
					</a>
					</li>
					<li class="nav-item active" id="li">
					<a class="nav-link" href="#0">
						<i class="material-icons">dashboard</i>
						<p id="board">게시물관리</p>
						<p id="freeList" style="display: none; margin-left: 62px;">자유게시판</p>
						<p id="reviewList" style="display: none; margin-left: 62px;">리뷰게시판</p>
						<p id="delete" style="display: none; margin-left: 62px;">글삭제</p>
					</a>
					</li>
					<li class="nav-item active" id="li">
					<a class="nav-link" href="#0">
						<i class="material-icons">dashboard</i>
						<p id="notice">공지관리</p>
					</a>
					</li>
					<li class="nav-item active" id="li">
					<a class="nav-link" href="#0">
						<i class="material-icons">dashboard</i>
						<p id="point">포인트상점관리</p>
					</a>
					</li>
					
					
					<!-- your sidebar here -->
				</ul>
				</div>
			</div>
		</div>
		<div class="main-panel">
			<!-- Navbar -->
			<nav
				class="navbar navbar-expand-lg navbar-transparent navbar-absolute fixed-top ">
				<!-- <div class="container-fluid">
					<div class="navbar-wrapper">
						<a class="navbar-brand" href="javascript:;">Dashboard</a>
					</div>
					<button class="navbar-toggler" type="button" data-toggle="collapse"
						aria-controls="navigation-index" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="sr-only">Toggle navigation</span> <span
							class="navbar-toggler-icon icon-bar"></span> <span
							class="navbar-toggler-icon icon-bar"></span> <span
							class="navbar-toggler-icon icon-bar"></span>
					</button>
					<div class="collapse navbar-collapse justify-content-end">
						<ul class="navbar-nav">
							<li class="nav-item"><a class="nav-link" href="javascript:;">
									<i class="material-icons">notifications</i> Notifications
							</a></li>
							your navbar here
						</ul>
					</div>
				</div> -->
			</nav>
			<!-- End Navbar -->
			<div class="content">
				<div class="container-fluid">
					<!-- your content here -->
					<iframe src="admin/center.jsp" name="center" width="100%" height="100%" frameborder="0"></iframe>
				</div>
			</div>
			<footer class="footer">
				<!-- <div class="container-fluid">
					<nav class="float-left">
						<ul>
							<li><a href="#"> Creative Tim
							</a></li>
						</ul>
					</nav>
					<div class="copyright float-right">
						&copy;
						<script>
							document.write(new Date().getFullYear())
						</script>
						, made with <i class="material-icons">favorite</i> by 
						<a href="#" target="_blank">Creative
							Tim</a> for a better web.
					</div>
					your footer here
				</div> -->
			</footer>
		</div>
	</div>
</body>

<!-- userprofile_light16:31-->
</html>