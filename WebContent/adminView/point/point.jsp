<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	legend {
		text-align: center;
	}
	
	.container-b {
		margin: 0 auto;
		width: 500px;
	}
</style>
</head>
<body>
	<div class="container-b">
		<h1>포인트상점관리</h1>
		<fieldset style="width: 350px; height: 100px;">
			<legend>A등급</legend>
			<input type="checkbox" id="aitem1" checked>아이템1 <input
				type="checkbox" id="aitem2">아이템2 <input type="checkbox"
				id="aitem2">아이템3 <input type="checkbox" id="aitem2">아이템4
		</fieldset>
		<p>
		<fieldset style="width: 350px; height: 100px;">
			<legend>B등급</legend>
			<input type="checkbox" id="bitem1">아이템1 <input
				type="checkbox" id="bitem2">아이템2 <input type="checkbox"
				id="bitem2">아이템3 <input type="checkbox" id="bitem2">아이템4
		</fieldset>
		<p>
		<fieldset style="width: 350px; height: 100px;">
			<legend>C등급</legend>
			<input type="checkbox" id="citem1">아이템1 <input
				type="checkbox" id="citem2">아이템2 <input type="checkbox"
				id="citem2">아이템3 <input type="checkbox" id="citem2">아이템4
		</fieldset>
	</div>
</body>
</html>