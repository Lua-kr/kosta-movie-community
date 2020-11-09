<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
  td,th{border:1px purple solid ; text-align: center; padding:5px }
</style>
</head>
<body>
 
    <table align="center" >
        <tr bgcolor=purple>
          
        <th>번호</th><th>제목</th><th>글쓴이</th><th>등록일</th><th>조회수</th>
        </tr>
        <c:forEach items="${list}" var="list"  varStatus="state">
        System.out.println(${list});
        <tr>
            <td>${state.count }</td>
            <td>${list.title }</td>
            <td>${list.authorId }</td>
            <td>${list.timeDate }</td>
            <td>${list.countRead }</td>          
        </tr>  
        </c:forEach>            
   
     <tr>  
        <td colspan="5"> <br/>
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