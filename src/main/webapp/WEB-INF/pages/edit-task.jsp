<%@ page import="com.softserve.itacademy.model.Task" %>
<%@ page import="com.softserve.itacademy.model.Priority" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit existing Task</title>

    <style>
        <%@include file="../styles/main.css"%>
    </style>

</head>
<body>
<%@include file="header.html" %>

<h1>Edit existing Task</h1>

<form action="/edit-task" method="post">

    <%
        Task task = (Task)request.getAttribute("task");
    %>
    <table>
        <tr>
            <td>
                <label for="id">Id:</label>
            </td>
            <td>
                <input type="text" id="id" name="id" value="<%=task.getId()%>" disabled>
            </td>
        </tr>
        <tr>
            <td>
                <label for="name">Name:</label>
            </td>
            <td>
                <input type="text" id="name" name="name" value="<%=task.getTitle()%>">
            </td>
        </tr>
        <tr>
            <td>
                <label for="priority">Priority</label>
            </td>
            <td>
                <select id="priority" name="priority" value="<%=task.getPriority()%>">
                    <option value="LOW">LOW</option>
                    <option value="MEDIUM">MEDIUM</option>
                    <option value="HIGH">HIGH</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Update">
            </td>
        </tr>
    </table>


</form>

</body>
</html>
