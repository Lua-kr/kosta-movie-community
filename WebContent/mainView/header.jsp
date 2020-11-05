<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<header class="ht-header">
	<div class="container">
		<nav class="navbar navbar-default navbar-custom">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header logo">
				    <div class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					    <span class="sr-only">Toggle navigation</span>
					    <div id="nav-icon1">
							<span></span>
							<span></span>
							<span></span>
						</div>
				    </div>
				    <a href="${pageContext.request.contextPath}/index.html"><img class="logo" src="${pageContext.request.contextPath}/images/logo1.png" alt="" width="119" height="58"></a>
			    </div>
				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse flex-parent" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav flex-child-menu menu-left">
						<li class="hidden">
							<a href="#page-top"></a>
						</li>
						<li>
							<a href="${pageContext.request.contextPath}/index.html" class="btn btn-default dropdown-toggle lv1" >
							Home 
							</a>
						</li>
						<li class="dropdown first">
							<a class="btn btn-default dropdown-toggle lv1" data-toggle="dropdown" data-hover="dropdown">
							영화<i class="fa fa-angle-down" aria-hidden="true"></i>
							</a>
							<ul class="dropdown-menu level1">
								<li><a href="${pageContext.request.contextPath}/mainView/movie/movielist.jsp">박스 오피스</a></li>
								<li><a href="${pageContext.request.contextPath}/mainView/movie/moviesingle.jsp">개봉예정작</a></li>
							</ul>
						</li>
						<li class="dropdown first">
							<a href="#" class="btn btn-default dropdown-toggle lv1" data-toggle="dropdown" data-hover="dropdown">
							커뮤니티 <i class="fa fa-angle-down" aria-hidden="true"></i>
							</a>
							<ul class="dropdown-menu level1">
								<li><a href="${pageContext.request.contextPath}/mainView/community/freeBoard.jsp">자유게시판</a></li>
								<li><a href="${pageContext.request.contextPath}/mainView/community/reviewBoard.jsp">리뷰게시판</a></li>
								<li><a href="${pageContext.request.contextPath}/mainView/community/userFavoritelist.jsp">즐겨찾기</a></li>
								<li class="it-last"><a href="${pageContext.request.contextPath}/mainView/community/userRate.jsp">나의 평점</a></li>
								
							</ul>
						</li>
						<li class="dropdown first">
							<a href="#" class="btn btn-default dropdown-toggle lv1" data-toggle="dropdown" data-hover="dropdown">
							내정보 <i class="fa fa-angle-down" aria-hidden="true"></i>
							</a>
							<ul class="dropdown-menu level1">
								<li><a href="${pageContext.request.contextPath}/mainView/profile/manageMyProfile.jsp">프로필관리</a></li>
								<li><a href="${pageContext.request.contextPath}/mainView/profile/checkActiving.jsp">활동내역확인</a></li>
								<li><a href="${pageContext.request.contextPath}/mainView/profile/manageitem.jsp">아이템관리</a></li>
								
							</ul>
						</li>
					</ul>
					<ul class="nav navbar-nav flex-child-menu menu-right">
						<li class="btn signupLink"><a href="#">로그인</a></li>
					</ul>
				</div>
			<!-- /.navbar-collapse -->
	    </nav>
	    
	    <!-- top search form -->
	    <div class="top-search">
	    	<select>
				<option value="name">영화제목</option>
				<option value="genre">장르</option>
				<option value="country">국가</option>
			</select>
			<input type="text" placeholder="검색어 입력">
	    </div>
	</div>
</header>
</body>
</html>