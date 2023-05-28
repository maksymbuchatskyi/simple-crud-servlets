<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Error Page</title>

    <style>
        <%@include file="../styles/main.css"%>
    </style>

</head>
<body>
<%@include file="header.html"%>

		<c:choose>
				<c:when test="${ not empty idErrorRead }">
					<h1>Task with ID '${idt}' not found in To-Do List</h1>
					<h2>url: /read-task</h2>
				</c:when>
		</c:choose>

		<c:choose>
				<c:when test="${ not empty idErrorEdit }">
					<h1>Task with ID '${idt}' not found in To-Do List</h1>
					<h2>url: /edit-task</h2>
				</c:when>
		</c:choose>	
		
		<c:choose>
				<c:when test="${ not empty idErrorDelete }">
					<h1>Task with ID '${idt}' not found in To-Do List</h1>
					<h2>url: /delete-task</h2>
				</c:when>
		</c:choose>	
</body>
</html>
