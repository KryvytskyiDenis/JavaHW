<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
<h2 align="center">Список студентов</h2>
<br>
<table border="1">
    <tr>
        <td>Id</td>
        <td>Имя</td>
        <td>Фамилия</td>
        <td>Номер телефона</td>
        <td>Дата рождения</td>
        <td>Email</td>
        <td></td>
    </tr>
    <c:forEach items="${students}" var="student" varStatus="status">
        <tr>
            <td>${student.id} </td>
            <td>${student.name}</td>
            <td>${student.surname}</td>
            <td>${student.phoneNumber}</td>
            <td>${student.dateOfBirth}</td>
            <td>${student.email}</td>
            <td>
                <a href="${pageContext.servletContext.contextPath}/student/update?id=${student.id}">Обновить</a>
                <a href="${pageContext.servletContext.contextPath}/student/delete?id=${student.id}">Удалить</a>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="HelloPage.jsp">На главную.</a>
</body>
</html>
