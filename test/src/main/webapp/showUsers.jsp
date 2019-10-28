<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Список пользователей</title>
</head>
<body>
<table border="2">
    <tr>
        <td>ID</td>
        <td>Имя</td>
        <td>Фамилия</td>
        <td>Действия</td>
    </tr>
    <c:forEach items="${persons}" var = "person">
        <tr>
            <td>${person.getId()}</td>
            <td>${person.getPersonName()}</td>
            <td>${person.getPersonSurname()}</td>
            <td>
                <form action = "updateUser.jsp" method="post">
                    <input type="hidden" name="id" value="${person.getId()}">
                    <input type="hidden" name="name" value="${person.getPersonName()}">
                    <input type="hidden" name="surname" value="${person.getPersonSurname()}">
                    <input type="submit" value="Изменить" style="float:left">
                </form>
                <form action="deleteUser.jsp" method="post">
                    <input type="hidden" name="id" value="${person.getId()}">
                    <input type="submit" value="Удалить" style="float:left">
                </form></td>
        </tr>
    </c:forEach>
</table>

<form action = "addUser.jsp">
    <input type="submit" value="Добавить нового пользователя">
</form>
</body>
</html>