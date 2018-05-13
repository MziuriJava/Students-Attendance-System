<%@ page import="java.util.List" %>
<%@ page import="ge.mziuri.model.user.staff.Staff" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<meta charset="UTF-8">
<head>
    <title>სტაფები</title>
    <link rel="stylesheet" href="css/table.css">
    <meta charset="UTF-8">
</head>
<body>
<form method="post" action="/loadStaffs">
    <input class="textx" type="text" placeholder="სახელი" name="searchName"
           value="<%=(request.getAttribute("searchName") == null) ? "" : request.getAttribute("searchName")%>">
    <input class="textx" type="text" placeholder="გვარი" name="searchLastName"
           value="<%=(request.getAttribute("searchLastName") == null) ? "" : request.getAttribute("searchLastName")%>">
    <input class="textx" type="text" placeholder="ID" name="searchPersonalId"
           value="<%=(request.getAttribute("searchPersonalId") == null) ? "" : request.getAttribute("searchPersonalId")%>">
    <input class="textx" type="text" placeholder="იმეილი" name="searchEmail"
           value="<%=(request.getAttribute("searchEmail") == null) ? "" : request.getAttribute("searchEmail")%>">
    <select name="searchStatus">
        <option value="All" <%=(request.getAttribute("searchStatus") == null) ? "selected" : ""%>>ყველა</option>
        <option value="Administrator"<%=(request.getAttribute("searchStatus") != null && request.getAttribute("searchStatus").equals("Administrator")) ? "selected" : ""%>>
            ადმინისტრატორი
        </option>
        <option value="Teacher"<%=(request.getAttribute("searchStatus") != null && request.getAttribute("searchStatus").equals("Teacher")) ? "selected" : ""%>>
            მასწავლებელი
        </option>
        <option value="Other"<%=(request.getAttribute("searchStatus") != null && request.getAttribute("searchStatus").equals("Other")) ? "selected" : ""%>>
            სხვა
        </option>
    </select>
    <button type="submit" class="submitAddButtons"><img class="submitAddButtonsImg" src="images/search_blue.png"/></button>
    <button type="button" class="submitAddButtons"><img class="submitAddButtonsImg" src="images/add_blue.png" onclick="location.href='/sas/admin/addStaff.jsp';"/></button>
</form>

<table class="blueTable">
    <thead>
    <tr>
        <th>№</th>
        <th>სახელი</th>
        <th>გვარი</th>
        <th>პირადი ნომერი</th>
        <th>ტელეფონი</th>
        <th>დამატებითი ტელ</th>
        <th>იმეილი</th>
        <th>სტატუსი</th>
        <th></th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <%
        int i = 0;
        List<Staff> staffs = (List<Staff>) request.getAttribute("staffs");
        while (i < staffs.size()) {
    %>
    <tr>
        <td><%=staffs.get(i).getId()%>
        </td>
        <td><%=staffs.get(i).getFirstname()%>
        </td>
        <td><%=staffs.get(i).getLastname()%>
        </td>
        <td><%=staffs.get(i).getPersonalId()%>
        </td>
        <td><%=staffs.get(i).getMainPhoneNumber()%>
        </td>
        <td><%=staffs.get(i).getAdditionalPhoneNumber()%>
        </td>
        <td><%=staffs.get(i).getEmail()%>
        </td>
        <td><%=staffs.get(i).getStaffStatus()%>
        </td>
        <td>
            <form method="post" action="/loadStaff">
                <button type="submit" class="editDeleteButtons"><img class="editDeleteButtonsImg" src="images/edit_blue.png"/></button>
                <input type="hidden" name="staffId" value="<%=staffs.get(i).getId()%>">
            </form>
        </td>
        <td>
            <form method="post" action="/deleteStaff">
                <button type="submit" class="editDeleteButtons"><img class="editDeleteButtonsImg" src="images/erase.png"/></button>
                <input type="hidden" name="staffId" value="<%=staffs.get(i).getId()%>">
            </form>
        </td>
    </tr>
    <%
            i++;
        }
    %>
    </tbody>
</table>
</body>
</html>
