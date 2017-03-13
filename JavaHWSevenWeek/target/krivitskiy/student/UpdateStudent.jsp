<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Редактирвование информации о студенте</title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/student/update" method="post">
    <input type="hidden" name="id" value="${student.id}">
    <table>
        <tr>
            <td align="right" >Name : </td>
            <td>
                <input type="text" name="name" value="${student.name}">
            </td>
        </tr>
        <tr>
            <td align="right" >Surname : </td>
            <td>
                <input type="text" name="surname" value="${student.surname}">
            </td>
        </tr>
        <tr>
            <td align="right" >Phone : </td>
            <td>
                <input type="text" name="phone" value="${student.phoneNumber}">
            </td>
        </tr>
        <tr>
            <td align="right" >Date of Birth : </td>
            <td>
                <input type="date" name="DOB" value="${student.dateOfBirth}">
            </td>
        </tr>
        <tr>
            <td align="right" >Email : </td>
            <td>
                <input type="text" name="email" value="${student.email}">
            </td>
        </tr>
        <tr>
            <td><input type="submit" align="center" value="Обновить"/></td>
        </tr>
    </table>
</form>
</body>
</html>
