<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:out value="spitter.username"></c:out>
	<br />
	<c:out value="spitter.firstName"></c:out>
	<c:out value="spitter.lastName"></c:out>
</body>
</html>