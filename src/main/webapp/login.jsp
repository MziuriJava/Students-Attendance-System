<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/login.css">
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
        <h2> სისტემაში შესვლა </h2>
        <div style="text-align: center;">
            <input type="email" placeholder="მეილი" name="email">
            <input type="password" placeholder="პაროლი" name="password">
            <input class="shesvlasize" type="submit" value=" შესვლა ">
        </div>
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
