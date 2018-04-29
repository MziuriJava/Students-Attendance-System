<% Student student = null; %>
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
    <form action="/sas/addStudent">
        <h2 class="inputadd"> სტუდენტის დამატება <%=(student == null) ? "სტუდენტის დამატება" : "სტუდენტის რედაქტირება"%> </h2>
        <div style="text-align: center;">
            <%
                student = (Student) request.getAttribute("student");
            %>
            <p>სახელი</p>
            <input class="inputtext" type="text" name="studentName" value="<%=(student == null) ? "" : student.getFirstname()%>">
            <p>გვარი</p>
            <input class="inputtext" type="text" name="studentSurname" value="<%=(student == null) ? "" : student.getLastname()%>">
            <p>იმეილი</p>
            <input class="inputtext" type="email" name="studentEmail" value="<%=(student == null) ? "" : student.getEmail()%>">
            <p>ტელეფონის ნომერი</p>
            <input class="inputtext" type="tel" name="studentPhoneNumber" value="<%=(student == null) ? "" : student.getPhoneNumber()%>">
            <p>მშობლის სახელი</p>
            <input class="inputtext" type="text" name="studentParentName" value="<%=(student == null) ? "" : student.getParentName()%>">
            <p>მშობლის ნომერი</p>
            <input class="inputtext" type="tel" name="studentParentNumber" value="<%=(student == null) ? "" : student.getParentNumber()%>">
            <br>
            <input type="submit" class="shesvlasize">
        </div>
    </form>
</div>

</body>
</html>
