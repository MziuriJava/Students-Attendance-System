<%@ page import="ge.mziuri.model.user.staff.Staff" %>
<%@ page import="ge.mziuri.model.user.staff.StaffStatus" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="../../css/register.css">
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
        <%
            Staff staff = (Staff) request.getAttribute("staff");
        %>
        <h2 class ="inputadd"><%=(staff == null) ? "მასწავლებლის დამატება" : "მასწავლებლის რედაქტირება"%>  </h2>
        <input class="inputtext"  type="text" placeholder="სახელი" name="name" value="<%=(staff == null) ? "" : staff.getFirstname()%>">
        <input class="inputtext"  type="text" placeholder="გვარი" name="surname" value="<%=(staff == null) ? "" : staff.getLastname()%>">
        <input class="inputtext"  type="email" placeholder="Email" name="email" value="<%=(staff == null) ? "" : staff.getEmail()%>">
        <input class="inputtext"  type="text" placeholder="ID" name="ID" value="<%=(staff == null) ? "" : staff.getId()%>">
        <input class="inputtext"  type="tel" placeholder="მთავარი ნომერი" name="MainNumber" value="<%=(staff == null) ? "" : staff.getMainPhoneNumber()%>">
        <input class="inputtext"  type="tel" placeholder="სუბ. ნომერი" name="SubNumber" value="<%=(staff == null) ? "" : staff.getAdditionalPhoneNumber()%>">
        <div style="text-align: center;">
            <select class="fixed-size" name="status">
                <option value="Administrator" <%=(staff != null && staff.getStaffStatus() == StaffStatus.ADMIN) ? "selected" : ""%>>ადმინისტრატორი</option>
                <option value="Teacher" <%=(staff != null && staff.getStaffStatus() == StaffStatus.TEACHER) ? "selected" : ""%>>მასწავლებელი</option>
                <option value="Other" <%=(staff != null && staff.getStaffStatus() == StaffStatus.OTHER) ? "selected" : ""%>>სხვა</option>
            </select>
            <%
                String failedAuth = (String)request.getAttribute("failedAuth");
                if (failedAuth != null && failedAuth.equals("true")) {
                    out.print("<p class=\"failedAuth\">მომხმარებლის სახელი/პაროლი არასწორია</p>");
                }
            %>
        </div>
        <br>
        <input class="submit" type="submit" value="დამატება">
    </form>
</div>

</body>
</html>
