<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../js/jquery-3.5.1.min.js"></script>
</head>
<body>

	<table align="center" border="1" cellpadding="2" cellspacing="2"
		width="60%" bordercolordark="white" bordercolorlight="black">
		<caption>자유 게시판</caption>
		<colgroup>
			<col width="10%" />
			<col width="40%" />
			<col width="15%" />
		</colgroup>

		<tr>
			<td bgcolor="purple">
				<p align="center">
					<font color="white"><b><span style="font-size: 9pt;">번호</span></b></font>
				</p>
			</td>
			<td bgcolor="purple">
				<p align="center">
					<font color="white"><b><span style="font-size: 9pt;">제목</span></b></font>
				</p>
			</td>
			<td bgcolor="purple">
				<p align="center">
					<font color="white"><b><span style="font-size: 9pt;">글쓴이</span></b></font>
				</p>
			</td>
			<td bgcolor="purple">
				<p align="center">
					<font color="white"><b><span style="font-size: 9pt;">등록일</span></b></font>
				</p>
			</td>

			<td bgcolor="purple">
				<p align="center">
					<font color="white"><b><span style="font-size: 9pt;">조회수</span></b></font>
				</p>
			</td>

			<td bgcolor="purple">
				<p align="center">
					<font color="white"><b><span style="font-size: 9pt;">삭제</span></b></font>
				</p>
			</td>

		</tr>

		<tr>
			<td colspan="7" style="text-align: center;">
				<form>
					<select>
						<option>--선택--</option>
						<option>닉네임</option>
						<option>제목</option>
						<option>내용</option>
					</select> <input type="text" width=100px; height=30px; /> <input
						type="button" value="검색" />



				</form>
	</table>





</body>

</body>
</html>