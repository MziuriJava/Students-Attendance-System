<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="../../css/register.css">
<href
<head>
    <title> მასწავლებლის დამატება</title>
</head>
<style>
    .fixed-size {
        width: 200px;
        height: 30px;
        margin: 5px;
    }
</style>
<body>
<div class="addStaff">
    <form method="post" action="/sas/admin/addStaff">
        <h2> მასწავლებლის დამატება </h2>
        <input type="text" placeholder="სახელი" name="name">
        <input type="text" placeholder="გვარი" name="surname">
        <input type="email" placeholder="Email" name="email">
        <input type="text" placeholder="ID" name="ID">
        <input type="tel" placeholder="მთავარი ნომერი" name="MainNumber">
        <input type="tel" placeholder="სუბ. ნომერი" name="SubNumber">
        <div style="text-align: center;">
            <select class="fixed-size" style="border-radius: 8px; width: 250px; height: 36px;" name="status">
                <option value="Administrator">ადმინისტრატორი</option>
                <option value="Teacher">მასწავლებელი</option>
                <option value="Other">სხვა</option>
            </select>
            <%
                String failedAuth = (String)request.getAttribute("failedAuth");
                if (failedAuth != null && failedAuth.equals("true")) {
                    out.print("<p class=\"failedAuth\">მომხმარებლის სახელი/პაროლი არასწორია</p>");
                }
            %>
        </div>
        <br>
        <input type="submit" value="დამატება">
    </form>
</div>

</body>
</html>
