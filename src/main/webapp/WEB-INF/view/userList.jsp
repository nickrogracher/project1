<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>БД пользователей</h1><br/>

<form method='post'>
    <p><b>Выберите действие c пользователем</b></p>
    <p><input name="action" type="radio" value="add" checked> Добавить
        <input name="action" type="radio" value="edit"> Изменить</p>

    <table width='100%' cellspacing='0' cellpadding='4' items="${requestScope.userEdit}" var="userEdit">
        <tr>
            <td align='right' width='100'>Имя</td>
            <td><input type='text' name='name' maxlength='50' size='20' value= ${userEdit.name}></td>
        </tr>
        <tr>
            <td align='right'>Фамилия</td>
            <td><input type='text' name='surname' maxlength='50' size='20' value=${userEdit.surname}></td>
        </tr>
        <tr>
            <td align='right'>Отчество</td>
            <td><input type='text' name='fathername' maxlength='50' size='20' value=${userEdit.fathername}></td>
        </tr>
    </table>
    <input type='submit' value='Подтвердить' name='Ok'><br>
    <input type="hidden" name="id" value="${userEdit.id}">
</form>


<table table border="1" cellspacing="0" cellpadding="2">
    <tr>
        <th>Id</th>
        <th>Имя</th>
        <th>Фамилия</th>
        <th>Отчество</th>
    </tr>
    <c:forEach items="${requestScope.list}" var="user">
        <tr>
            <td> ${user.id} </td>
            <td> ${user.name} </td>
            <td> ${user.surname} </td>
            <td> ${user.fathername} </td>
            <td>
                <form method="get">
                    <input type="submit" value="Изменить" name="edit">
                    <input type="submit" value="Удалить" name="delete">
                    <input type="hidden" name="id" value="${user.id}">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>


</body>

</html>
