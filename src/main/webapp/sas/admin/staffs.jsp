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
<meta charset="UTF-8">
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
<table class="blueTable"></table>
    <thead>
    <link rel="stylesheet" href="../../css/table.css">
        <tr>
            <th>ID</th>
            <th>სახელი</th>
            <th>გვარი</th>
            <th>ტელეფონი</th>
            <th>დამატებითი ტელ</th>
            <th>იმეილი</th>
            <th>სტატუსი</th>
            <th></th>
            <th></th>
        </tr>
    </thead>
<tbody>

    <%int i = 0;
    while (i < staffs.size()) {%>

    <tr>
        <td><%staffs.get(i).getId();%></td>
        <td><%staffs.get(i).getFirstname();%></td>
        <td><%staffs.get(i).getLastname();%></td>
        <td><%staffs.get(i).getMainPhoneNumber();%></td>
        <td><%staffs.get(i).getAdditionalPhoneNumber();%></td>
        <td><%staffs.get(i).getEmail();%></td>
        <td><%staffs.get(i).getStaffStatus();%></td>
        <td class= "centerButton">
            <button type="button" class="buttonStyle"><img class="imgStyle" src="../../images/edit.png"/></button>
        </td>
        <td class= "centerButton">
            <button type="button" class="buttonStyle"><img class="imgStyle" src="../../images/erase.png"/></button>
        </td>
    </tr>


<%}%>
</tbody>
</body>
</html>
