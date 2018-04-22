<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/login.css">

<head>
    <title> შესვლა </title>
</head>
<body>
<div class="login">
    <form method="post" action="/login">
        <h2> სისტემაში შესვლა </h2>
        <div>
            <label class="lab" >მეილი</label>
            <input class="form-styling" type="email"  name="email">
            <label class="lab">პაროლი</label>
            <input class="form-styling" type="password" name="password">

            <input class="signin" type="submit" value=" შესვლა ">

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
