<%@ page import="java.util.List" %>
<%@ page import="ge.mziuri.model.user.staff.Staff" %><%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 3/31/2018
  Time: 4:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>სტაფები</title>
</head>
<body>
<h1>სულ არის
    <%
        List<Staff> staffs = (List<Staff>) request.getAttribute("staffs");
        out.write(staffs.size());
    %>
    სტაფი
</h1>
</body>
</html>
