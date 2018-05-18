<%@ page import="java.util.List" %>
<%@ page import="ge.mziuri.model.user.staff.Staff" %>
<%@ page import="ge.mziuri.model.user.student.Student" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<meta charset="UTF-8">
<head>
    <title>სტუდენტები</title>
    <link rel="stylesheet" href="css/table.css">
    <meta charset="UTF-8">
</head>
<body>
<form method="post" action="/loadStudents">
    <input class="textx" type="text" placeholder="სახელი" name="searchName" value="<%=(request.getAttribute("searchName") == null) ? "" : request.getAttribute("searchName")%>">
    <input class="textx" type="text" placeholder="გვარი" name="searchLastName" value="<%=(request.getAttribute("searchLastName") == null) ? "" : request.getAttribute("searchLastName")%>">
    <input class="textx" type="text" placeholder="ID" name="searchPersonalId" value="<%=(request.getAttribute("searchPersonalId") == null) ? "" : request.getAttribute("searchPersonalId")%>">
    <input class="textx" type="text" placeholder="იმეილი" name="searchEmail" value="<%=(request.getAttribute("searchEmail") == null) ? "" : request.getAttribute("searchEmail")%>">
    <button type="submit" class="searchButton"><img class="imgStyleSearch" src="images/search_black.png"/></button>
</form>

<table class="blueTable">
    <thead>
    <tr>
        <th>№</th>
        <th>სახელი</th>
        <th>გვარი</th>
        <th>პირადი ნომერი</th>
        <th>იმეილი</th>
        <th>ტელეფონი</th>
        <th>მშობლის სახელი</th>
        <th>მშობლის ტელ</th>
        <th></th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <%
        int i = 0;
        List<Student> students = (List<Student>) request.getAttribute("students");
        while (i < students.size()) {
    %>
    <tr>
        <td><%=students.get(i).getId()%></td>
        <td><%=students.get(i).getFirstname()%></td>
        <td><%=students.get(i).getLastname()%></td>
        <td><%=students.get(i).getPersonalId()%></td>
        <td><%=students.get(i).getEmail()%></td>
        <td><%=students.get(i).getPhoneNumber()%></td>
        <td><%=students.get(i).getParentName()%></td>
        <td><%=students.get(i).getParentNumber()%></td>
        <td class= "centerButton">
            <form method="post" action="/editStudent">
                <button type="submit" class="buttonStyle"><img class="imgStyle" src="images/edit_black.png"/></button>
                <input type="hidden" name="studentId" value="<%=students.get(i).getId()%>">
            </form>
        </td>

        <td class= "centerButton">
            <form method="post" action="/deleteStudent">
                <button type="submit" class="buttonStyle"><img class="imgStyle" src="images/erase.png"/></button>
                <input type="hidden" name="studentId" value="<%=students.get(i).getId()%>">
            </form>
        </td>
    </tr>
    <%
            i++;}
    %>
    </tbody>
</table>
</body>
</html>
