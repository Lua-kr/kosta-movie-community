<%@page import="java.util.Iterator"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Map,com.google.gson.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.5.1.min.js"></script>
</head>
<body>
	<h1>API 결과를 출력해 보아요</h1>
	<div id="a"></div>
	<%
		Map<String, JsonObject> map = (Map<String, JsonObject>) request.getAttribute("map");
	Set<String> set = map.keySet();
	Iterator<String> keys = set.iterator();

	while (keys.hasNext()) {
		String key = keys.next();
		JsonObject jobj = map.get(key);
		//out.println(key + " = " + jobj + "<hr>");

		if ( jobj.get("title").isJsonNull()) {
			jobj.addProperty("title", "null");
		}
		if ( jobj.get("id").isJsonNull()) {
			jobj.addProperty("id", "null");
		}
		if (jobj.get("vote_count").isJsonNull()) {
			jobj.addProperty("vote_count", "null");
		}
		if ( jobj.get("overview").isJsonNull()) {
			jobj.addProperty("overview", "null");
		}
		if (jobj.get("vote_average").isJsonNull()) {
			jobj.addProperty("vote_average", "null");
		}
		if ( jobj.get("release_date").isJsonNull()) {
			jobj.addProperty("release_date", "null");
		}
		if ( jobj.get("genre_ids").isJsonNull()) {
			jobj.addProperty("genre_ids", "null");
		}
		if ( jobj.get("popularity").isJsonNull()) {
			jobj.addProperty("popularity", "null");
		}
		if ( jobj.get("poster_path").isJsonNull()) {
			jobj.addProperty("poster_path", "null");
		}
		if ( jobj.get("backdrop_path").isJsonNull()) {
			jobj.addProperty("backdrop_path", "null");
		}

		out.print("타이틀 =" + jobj.get("title") + "<br>");
		out.print("영화코드 =" + jobj.get("id") + "<br>");
		out.print("줄거리= " + jobj.get("overview") + "<br>");
		out.print("평점수 = " + jobj.get("vote_count") + "<br>");
		out.print("평점 = " + jobj.get("vote_average") + "<br>");
		out.print("개봉일 = " + jobj.get("release_date") + "<br>");
		out.print("장르코드 = " + jobj.get("genre_ids") + "<br>");

		out.print("<img src='https://image.tmdb.org/t/p/w300" + jobj.get("poster_path").getAsString() + "' alt='포스터'>"
		+ "<br>");
		out.print("<img src='https://image.tmdb.org/t/p/w300" + jobj.get("backdrop_path").getAsString() + "' alt='백드랍'>"
		+ "<br>");
		out.print("<hr>");
		// out.print(key +"="+ jobj.get("backdrop_path")+"<br>") ;
	}
	%>


</body>
</html>