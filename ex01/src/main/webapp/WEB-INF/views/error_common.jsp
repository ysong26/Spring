<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${exception.getMessage()} <br><br> 여기까지는 getMessage<br>

<c:forEach items="${exception.getStackTrace()}" var="stack">
	${stack.toString() } <br>
</c:forEach>

</body>
</html>