<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="../css/login.css">
<style>
    .shesvlasize {
        width: 150px;
        height: 30px;
    }
</style>
<head>
    <title> შესვლა </title>
</head>
<body>
<div class="login">
    <form method="post" action="/login">
        <h2> შესვლა </h2>
        <center>
            <input type="email" placeholder="Email" name="email">
            <input type="password" name="password">
            <input class="shesvlasize" type="button" value=" შესვლა ">
        </center>
        <%
            String failedAuth = (String) request.getAttribute("failedAuth");
            if (failedAuth != null && failedAuth.equals("true")) {
                out.print("<p class=\"failedAuth\">მომხმარებლის სახელი/პაროლი არასწორია</p>");
            }
        %>
    </form>
</div>
</body>
</html>
