<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="assesment.css">
</head>
<body>
<form method="post" action="/assesment">
<table  class="assesment" style="height: 353px; width: 803px;">
    <thead>
    <tr style="height: 53px;">
        <td class="name" style="width: 700px; height: 53px;" colspan="3" >
            <%=request.getAttribute("staffName")%></td>
        <td class="topic" style=" height: 53px;"colspan="2" name="topic">
            <%=request.getAttribute("topic")%></td>
        <td class="information" style=" height: 53px;"colspan="3" name="assesmentInformation">
            <%=request.getAttribute("assesmentInformation")%></td>
    </tr>
    </thead>
    <tbody>

    <tr style="height: 37px;">
        <th style="width: 231px; height: 37px;" colspan="2">ტესტები/პროექტები   </th>
        <div class="descriptionTop">
            <th style="width: 112px; height: 37px;">საშვალო აქტიუორიბა</th>
            <td style="width: 49px; height: 37px;" name="active">
                <%=request.getAttribute("active")%></td>
            <th style="width: 130px; height: 37px;">საშვალო დავალება</th>
            <td style="width: 49px; height: 37px;" name="homework">
                <%=request.getAttribute("homework")%></td>
            <th style="width: 137px; height: 37px;">გაცდენა</th>
            <td style="width: 49px; height: 37px;" name="absent">
                <%=request.getAttribute("absent")%></td>
        </div>

    </tr>
    <tr style="height: 37px;">
        <th style="width: 112px; height: 37px;">თარიღი</th>
        <th style="width: 113px; height: 37px;">ნიშანი</th>
        <td class="description" style="width: 556px; height: 189px;" colspan="6" rowspan="5" name="description">
            <%=request.getAttribute("description")%></td>
    </tr>
    <tr style="height: 38px;">
        <td style="width: 112px; height: 38px;" name="date1">
            <%=request.getAttribute("date1")%></td>
        <td style="width: 113px; height: 38px;" name="mark1">
            <%=request.getAttribute("mark1")%></td>
    </tr>
    <tr style="height: 38px;">
        <td style="width: 112px; height: 38px;" name="date2"></td>
        <td style="width: 113px; height: 38px;" name="mark2"></td>
    </tr>
    <tr style="height: 38px;">
        <td style="width: 112px; height: 38px;" name="date3"></td>
        <td style="width: 113px; height: 38px;" name="mark3"></td>
    </tr>
    <tr style="height: 38px;">
        <td style="width: 112px; height: 38px;" name="date4"></td>
        <td style="width: 113px; height: 38px;" name="mark4"></td>
    </tr>
    <tr style="height: 38px;">
        <td style="width: 112px; height: 38px;" name="date5"></td>
        <td style="width: 113px; height: 38px;" name="mark5"></td>
        <td class="teacher" style="width: 556px; height: 38px;" colspan="6" name="teacherName">
            <%=request.getAttribute("teacherName")%></td>
    </tr>
    </tbody>
</table>
</form>


</body>
</html>
