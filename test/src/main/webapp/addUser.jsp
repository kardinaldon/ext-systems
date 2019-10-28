<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавить нового пользователя</title>
</head>
<body>
<form action = "http://localhost:8080/testcrud_1_war/persons" method="post">
    <input required type="text" name="name" placeholder="Имя">
    <input required type="text" name="surname" placeholder="Фамилия">
    <input type="submit" value="Сохранить">
</form>
</body>
</html>