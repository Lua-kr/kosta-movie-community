<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../../js/jquery-3.5.1.min.js"></script>
</head>
<body>
<h1>${requestScope.title } 's detail</h1>
포스터 :<img src="https://image.tmdb.org/t/p/w300${requestScope.poster_path }" alt="포스터 없음"><br>
제   목 : ${requestScope.title }<br>
원제목 : ${requestScope.original_title }<br>
줄거리 : ${requestScope.overview }<br>
개봉일 : ${requestScope.release_date }<br>
예	   산 : $<fmt:formatNumber value="${requestScope.budget }"/><br>
수	   익 : $<fmt:formatNumber value="${requestScope.revenue }"/><br>
런타임 : ${requestScope.runtimes }분<br>
슬로건 : ${requestScope.tagline }<br>
총평점 : ${requestScope.vote_average }<br>
평점수 : ${requestScope.vote_count }<br>
인기도 : ${requestScope.popularity }<br>
<hr>
</body>
</html>