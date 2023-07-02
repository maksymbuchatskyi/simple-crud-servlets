<%@ page import="mbuchatskyi.model.Task" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Read existing Task</title>

    <style>
        <%@include file="../styles/main.css"%>
    </style>

</head>
<body>
<table>
    <%@include file="header.html"%>
	<h1>Read existing task</h1>
	<a>Id: </a> <b> ${idt} </b> <br> 
	<a>Title: </a> <b> ${name} </b> <br>
	<a>Priority: </a> <b> ${prio} </b>
</body>
</html>
