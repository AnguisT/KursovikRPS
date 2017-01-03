<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Авторизация</title>
    </head>
    <body>
        <div style="text-align: center"><h1>Авторизация</h1></div>
        <form method="POST" action="j_security_check">
            <fieldset>
                <legend>Авторизация</legend>
                Введите номер паспорта:<br>
                <input type="text" name="j_username" /><br>
                Введите дату своего рождения без точек:<br>
                <input type="password" name="j_password"><br>
                <input type="submit" value="Вход" />
            </fieldset>
        </form>
    </body>
</html>
