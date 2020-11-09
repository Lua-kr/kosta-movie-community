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
<h1>upcomming result</h1><hr>
	<%
		Map<String, JsonObject> map = (Map<String, JsonObject>) request.getAttribute("map");
	Set<String> set = map.keySet();
	Iterator<String> keys = set.iterator();

	while (keys.hasNext()) {
		String key = keys.next();
		JsonObject jobj = map.get(key);
		//out.println(key + " = " + jobj + "<hr>");

		//////////////////////////////null 여부 확인//////////////////////////////
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

		//////////////////////////////화면 출력///////////////////////////////
		
		out.print("타이틀 =" + jobj.get("title") + "<br>");
		out.print("영화코드 =" + jobj.get("id") + "<br>");
		if( jobj.get("overview").getAsString().equals("")){
			out.print("줄거리 : ");out.print(" 존재하지 않습니다<br>");
		}else{
		out.print("줄거리= " + jobj.get("overview") + "<br>");
		}
		out.print("평점수 = " + jobj.get("vote_count") + "<br>");
		out.print("평점 = " + jobj.get("vote_average") + "<br>");
		if( jobj.get("release_date").getAsString().equals("")){
			out.print("개봉일 : ");out.print(" 미확인 <br>");
		}else{
		out.print("개봉일= " + jobj.get("release_date") + "<br>");
		}
		if( jobj.get("genre_ids").getAsJsonArray().size()<=0){
			out.print("장르코드 : ");out.print(" 존재하지 않습니다<br>");
		}else{
			JsonArray genre =(JsonArray)jobj.get("genre_ids");
			String genreName ="[ ";
			for(JsonElement num : genre){
				if(num.toString().equals("28")){
					genreName+= ("액션");
				}else if (num.toString().equals("12")){
					genreName+= ("   모험");
				}else if (num.toString().equals("16")){
					genreName+= ("   애니메이션");
				}else if (num.toString().equals("35")){
					genreName+= ("   코미디");
				}else if (num.toString().equals("80")){
					genreName+= ("   범죄");
				}else if (num.toString().equals("99")){
					genreName+= ("   다큐멘터리");
				}else if (num.toString().equals("18")){
					genreName+= ("   드라마");
				}else if (num.toString().equals("10751")){
					genreName+= ("   가족");
				}else if (num.toString().equals("14")){
					genreName+= ("   판타디");
				}else if (num.toString().equals("36")){
					genreName+= ("   역사");
				}else if (num.toString().equals("27")){
					genreName+= ("   공포");
				}else if (num.toString().equals("10402")){
					genreName+= ("   음악");
				}else if (num.toString().equals("9648")){
					genreName+= ("   미스터리");
				}else if (num.toString().equals("10749")){
					genreName+= ("   로맨스");
				}else if (num.toString().equals("878")){
					genreName+= ("   SF");
				}else if (num.toString().equals("10770")){
					genreName+= ("   TV 영화");
				}else if (num.toString().equals("53")){
					genreName+= ("   스틸러");
				}else if (num.toString().equals("10752")){
					genreName+= ("   전쟁");
				}else if (num.toString().equals("37")){
					genreName+= ("   서부");
				}
			}//for
			genreName+=" ]";
					
			out.print("장르코드= " +(JsonArray)jobj.get("genre_ids")+ "<br>");
			out.print("장르= " +genreName+ "<br>");
		}//else 
		
		out.print("<img src='https://image.tmdb.org/t/p/w300" + jobj.get("poster_path").getAsString() + "' alt='포스터가 없습니다'>"
		+ "<br>");
		out.print("<img src='https://image.tmdb.org/t/p/w300" + jobj.get("backdrop_path").getAsString() + "' alt='백드랍이 없습니다'>"
		+ "<br>");
		out.print("<hr>");
		// out.print(key +"="+ jobj.get("backdrop_path")+"<br>") ;
	}
	%>


</body>
</html>