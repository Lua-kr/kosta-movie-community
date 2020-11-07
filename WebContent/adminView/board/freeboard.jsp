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
  	margin-right: 
  }
  th{color: white}
  td,th{border:1px purple solid ; text-align: center; padding:5px }
  
</style>
</head>
<body>
    <h2 style="margin-left: 430px">freeboard</h2>
   
    <table align="center" >
        <tr bgcolor=purple>
          
        <th>번호</th><th>제목</th><th>글쓴이</th><th>등록일</th><th>조회수</th><th>삭제</th><th>&nbsp;</th>
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
        <td colspan="7"> <br/>
            <form name="serach" method ="post">
            <select name="keyField">
                <option value="0"> ----선택----</option>
                <option value="id">아이디</option>
                <option value="name">이름</option>
                <option value="addr">주소</option>  
            </select>
            <input type="text" name="keyWord" />
            <input type="button" value="검색" />
            </form>
        </td>      
    </tr>
     
    </table>  
</body>
</html>