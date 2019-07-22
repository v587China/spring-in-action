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
	<ol>
		<c:forEach items="${spittleList}" var="spittle">
			<li>
				<div class="spittleMessage">
					<c:out value="spittle.message"></c:out>
				</div>
				<div>
					<span class="spittleTime"><c:out value="spittle.time"></c:out></span>
					<span class="spittleLocation">( <c:out
							value="spittle.latitude"></c:out>,<c:out
							value="spittle.longitude"></c:out>)
					</span>
				</div>
			</li>
		</c:forEach>
	</ol>
</body>
</html>