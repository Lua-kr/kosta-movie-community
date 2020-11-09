<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/plugin1.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/plugin2.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/plugin3.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
	<script src="${pageContext.request.contextPath}/js/plugins.js"></script>
	<script src="${pageContext.request.contextPath}/js/plugins2.js"></script>
	<script src="${pageContext.request.contextPath}/js/custom.js"></script>
</head>
<body>
	<div class="row ipad-width">
							<div class="col-md-9 col-sm-12 col-xs-12">
								<div class="form-style-1 user-pro" action="#">
										<c:choose>
											<c:when test="${uid == null}">
											<form action="#" class="user">
												<h4>나의 프로필</h4>
												<div class="row">
													<div class="col-md-6 form-it">
														<h5 style="color: skyblue;">로그인이 필요합니다.</h5>
													</div>
												</div>
											</form>
										</c:when>
										
										
										<c:otherwise>
											<form method="post" action="${pageContext.request.contextPath}/app?k=user&v=updateUserNickname" class="user">
												<h4>나의 프로필</h4>
												<div class="row">
													<div class="col-md-6 form-it">
													
														<label>아이디</label> <input type="text"
															 value="${uid}" name="name">
													</div>
													<div class="col-md-6 form-it">
														<label>닉네임</label> <input type="text"
															 value="${nickname}" name="nickname">
													</div>
													<div class="col-md-6 form-it">
														<label>이메일</label> <input type="text"
															 value="${email}" name="email">
													</div>
		
													<div class="col-md-6 form-it">
														<label>가입일</label> <input type="text"
															 value="${joinDate}" name="joindate">
													</div>
													<div class="col-md-6 form-it">
														<label>활동점수</label> <input type="text" value="${points}" name="points">
													</div>
													<div class="col-md-6 form-it">
													<c:choose>
														<c:when test="${adult}">
															<label>성인 인증 여부</label> <input type="text"  value="성인" name="adult">
														</c:when>
														<c:otherwise>
															<label>성인 인증 여부</label> <input type="text"  value="미성년자" name="underage">
														</c:otherwise>
													</c:choose>
													</div>
												</div>
		
												<div class="row">
													<div class="col-md-2">
														<input class="submit" type="submit" value="save">
													</div>
												</div>
											</form>
										</c:otherwise>
									</c:choose>
								</div>
							</div>
						</div>
</body>
</html>