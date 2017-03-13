<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/student/create" method="GET">
    <table>
        <tr>
            <td align="right" >Name : </td>
            <td>
                <input type="text" name="name">
            </td>
        </tr>
        <tr>
            <td align="right" >Surname : </td>
            <td>
                <input type="text" name="surname">
            </td>
        </tr>
        <tr>
            <td align="right" >Phone : </td>
            <td>
                <input type="text" name="phone">
            </td>
        </tr>
        <tr>
            <td align="right" >Date of Birth : </td>
            <td>
                <input type="date" name="DOB">
            </td>
        </tr>
        <tr>
            <td align="right" >Email : </td>
            <td>
                <input type="text" name="email">
            </td>
        </tr>
        <tr>
            <td><input type="submit" align="center" value="Submit"/></td>
        </tr>
    </table>
</form>
</body>
</html>