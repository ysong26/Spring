<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="../include/header.jsp" %>
<table class="table table-bordered">
	<tr>
		<th style="width: 10px">글번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>작성일</th>
		<th style="width: 40px">조회수</th>
	</tr>
	
	<c:forEach items= "${list}" var="boardVO">
	<tr>
		<td>${boardVO.bno}</td>
		<td><a href="/board/read?bno=${boardVO.bno}">${boardVO.title}</a></td>
		<td>${boardVO.writer}</td>
		<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${boardVO.regdate}"/></td>
		<td><span class="badge bg-red">${boardVO.viewcnt}</span></td>
	</tr>	
	</c:forEach>
</table>


<script>
var result ='${result}'
if(result=='success'){
	alert("글이 등록되었습니다.");
}

var result ='${msg}'
	if(result=='success'){
		alert("글이 삭제되었습니다.");
}
</script>


<%@include file="../include/footer.jsp" %>