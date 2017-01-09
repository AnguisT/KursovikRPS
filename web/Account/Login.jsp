<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Авторизация</title>
    </head>
    <body>
        <h1 style="text-align: center">Авторизация</h1>
        <form action="j_security_check" method="POST">
            <fieldset>
                <legend>Форма авторизации</legend>
                Введите номер паспорта:<br/>
                <input type="text" name="j_username"><br/>
                Введите дату своего рождения без точек (ддММгггг):<br/>
                <input type="password" name="j_password"><br/>
                <br/>
                <input type="submit" value="Login" >
            </fieldset>
        </form>
    </body>
</html>