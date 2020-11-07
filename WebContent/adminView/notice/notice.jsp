<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
 table {
  	border: width:666px;
  	width: 900px;
  }
  th{color: white}
  td,th{border:1px purple solid ; text-align: center; padding:5px}
</style>
</head>
<body>
    <h2 align="center">공지사항</h2>
   
    <table align="center" >
        <tr bgcolor="purple">
        <th>아이디</th><th>이름</th><th>비밀번호</th><th>나이</th><th>주소</th><th>주민번호</th><th>&nbsp;</th>
        </tr>
        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td><input type="button" value="삭제"></td> 
        </tr>              
   
     <tr>  
        <td colspan="7" style="text-align: right;" > <br/>
        	
            <input type="button" value="추가" />
           
        </td>      
    </tr>
    </table>  
</body>
</html>