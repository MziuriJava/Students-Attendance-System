<%@ page import="ge.mziuri.model.user.student.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="../css/addStudent.css">
<head>
    <title>სტუდენტის დამატება</title>
</head>
<body>
<div class="addstudent">
    <form>
        <h2 class="inputadd"> სტუდენტის დამატება </h2>
        <div style="text-align: center;">
            <%
                Student student = (Student) request.getAttribute("student");
            %>
            <p>სახელი</p>
            <input class="inputtext" type="text" name="StudentName">
            <p>გვარი</p>
            <input class="inputtext" type="text" name=StudentSurname"">
            <p>იმეილი</p>
            <input class="inputtext" type="email" name="StudentEmail">
            <p>ტელეფონის ნომერი</p>
            <input class="inputtext" type="tel" name="PhoneNumber">
            <p>მშობლის სახელი</p>
            <input class="inputtext" type="text" name="ParentName">
            <p>მშობლის ნომერი</p>
            <input class="inputtext" type="tel" name="ParentNumber">
            <br>
            <input type="submit" class="shesvlasize">
            <%
                String failedAuth = (String)request.getAttribute("failedAuth");
                if (failedAuth != null && failedAuth.equals("true")) {
                    out.print("<p class=\"failedAuth\">მომხმარებლის სახელი/პაროლი არასწორია</p>");
                }
            %>
        </div>
    </form>
</div>

</body>
</html>
