<%@ page import="java.util.List" %>
<%@ page import="ge.mziuri.model.user.staff.Staff" %>
<%@ page import="ge.mziuri.model.assessment.Assessment" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<meta charset="UTF-8">
<head>
    <title>სტუდენტები</title>
    <link rel="stylesheet" href="css/table.css">
    <meta charset="UTF-8">
</head>
<body>
<form method="post" action="/loadAssessments">
    <input class="textx" type="text" placeholder="მასწავლებელი" name="searchStaff" value="<%=(request.getAttribute("searchStaff") == null) ? "" : request.getAttribute("searchStaff")%>">
    <input class="textx" type="text" placeholder="მოსწავლე" name="searchStudent" value="<%=(request.getAttribute("searchStudent") == null) ? "" : request.getAttribute("searchStudent")%>">
    <input class="textx" type="text" placeholder="ჯგუფი" name="searchGroup" value="<%=(request.getAttribute("searchGroup") == null) ? "" : request.getAttribute("searchGroup")%>">
    <input class="textx" type="text" placeholder="საწყ. თარიღი" name="searchStartDate" value="<%=(request.getAttribute("searchStartDate") == null) ? "" : request.getAttribute("searchStartDate")%>">
    <button type="submit" class="searchButton"><img class="imgStyleSearch" src="images/search_black.png"/></button>
</form>

<table class="blueTable">
    <thead>
    <tr>
        <th>№</th>
        <th>მასწავლებელი</th>
        <th>მოსწავლე</th>
        <th>ჯგუფი</th>
        <th>სახელი</th>
        <th>საწყ. თარიღი</th>
        <th>საბლ. თარიღი</th>
        <th></th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <%
        int i = 0;
        List<Assessment> assessments = (List<Assessment>) request.getAttribute("assessments");
        while (i < assessments.size()) {
    %>
    <tr>
        <td><%=assessments.get(i).getID()%></td>
        <td><%=assessments.get(i).getStaff()%></td>
        <td><%=assessments.get(i).getStudent()%></td>
        <td><%=assessments.get(i).getGroup()%></td>
        <td><%=assessments.get(i).getName()%></td>
        <td><%=assessments.get(i).getStartDate()%></td>
        <td><%=assessments.get(i).getEndDate()%></td>
        <td class= "centerButton">
            <form method="post" action="/editAssessment">
                <button type="submit" class="buttonStyle"><img class="imgStyle" src="images/edit_black.png"/></button>
                <input type="hidden" name="assessmentId" value="<%=assessments.get(i).getID()%>">
            </form>
        </td>

        <td class= "centerButton">
            <form method="post" action="/deleteAssessment">
                <button type="submit" class="buttonStyle"><img class="imgStyle" src="images/erase.png"/></button>
                <input type="hidden" name="assessmentId" value="<%=assessments.get(i).getID()%>">
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
