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
    <input class="textx" type="text" placeholder="სახელი" name="searchName" value="<%=(request.getAttribute("searchName") == null) ? "" : request.getAttribute("searchName")%>">
    <input class="textx" type="text" placeholder="გვარი" name="searchLastName" value="">
    <input class="textx" type="text" placeholder="ID" name="searchPersonalId" value="">
    <input class="textx" type="text" placeholder="იმეილი" name="searchEmail" value="">
    <select name="searchStatus">
        <option value="All">ყველა</option>
        <option value="Administrator">ადმინისტრატორი</option>
        <option value="Teacher">მასწავლებელი</option>
        <option value="Other">სხვა</option>
    </select>
    <button type="submit" class="searchButton"><img class="imgStyleSearch" src="images/search-13-16.png"/></button>
</form>

<table class="blueTable">
    <thead>
    <tr>
        <th>ID</th>
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
        <td class="centerButton">
            <form method="post" action="/editStaff">
                <button type="submit" class="buttonStyle"><img class="imgStyle" src="images/edit.png"/></button>
                <input type="hidden" name="staffId" value="<%=staffs.get(i).getId()%>">
            </form>
        </td>
        <td class="centerButton">
            <form method="post" action="/deleteStaff">
                <button type="submit" class="buttonStyle"><img class="imgStyle" src="images/erase.png"/></button>
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
