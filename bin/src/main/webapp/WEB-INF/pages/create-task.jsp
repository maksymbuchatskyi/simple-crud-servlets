<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="com.softserve.itacademy.model.Priority"%>
<%@ page import="com.softserve.itacademy.model.Task"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<html>
<head>
	<title>Create new Task</title>
		<style>
 		<%@include file="../styles/main.css"%>
	</style>
	</head>
<body>
	<%@include file="header.html"%>
		<h1>Create new task</h1>

		<c:choose>
				<c:when test="${ not empty creationError }">
					<span style="color: #ff0000;">Task with a given name already exists!</span>
					<br><br>
				</c:when>
		</c:choose>		
		
		<form action ="/create-task" method="post">
		<a>Name:</a>
		<input name ="name"><br> 
			 
		<a>Priority: </a> 
				<select name="prio">
					<c:forEach items="${priorities}" var="entry">
						<option>
							${entry}
						</option>
					</c:forEach>
				</select><br>
		<input type = "submit" value="Create" />
        <input type = "reset" value="Clear" />
		</form>
</body>
</html>
