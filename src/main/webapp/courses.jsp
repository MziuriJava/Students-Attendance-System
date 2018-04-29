<%@ page import="java.util.List" %>
<%@ page import="ge.mziuri.model.user.staff.Staff" %>
<%@ page import="ge.mziuri.model.user.student.Student" %>
<%@ page import="ge.mziuri.model.course.Course" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<meta charset="UTF-8">
<head>
    <title>კურსები</title>
    <link rel="stylesheet" href="css/table.css">
    <meta charset="UTF-8">
</head>
<body>
<table class="blueTable">
    <thead>
    <tr>
        <th>ID</th>
        <th>კურსის სახელი</th>
        <th>კურსის ხანგრძლივობა</th>
        <th>კვირაში გაკვეთილი</th>
        <th>გაკვეთილის ხანგრძ.</th>
        <th>ფასი</th>
        <th>კურსის სტატუსი</th>
        <th>კურსის ხელმძღვანელი</th>
        <th></th>
        <th></th>
        <th></th>

    </tr>
    </thead>
    <tbody>
    <%
        int i = 0;
        List<Course> courses = (List<Course>) request.getAttribute("courses");
        while (i < courses.size()) {
    %>
    <tr>
        <td><%=courses.get(i).getID()%></td>
        <td><%=courses.get(i).getCourseName()%></td>
        <td><%=courses.get(i).getCourseLength()%></td>
        <td><%=courses.get(i).getLessonsPerWeek()%></td>
        <td><%=courses.get(i).getCourseLessonTime()%></td>
        <td><%=courses.get(i).getPrice()%></td>
        <td><%=courses.get(i).getCourseStatus()%></td>
        <td><%=courses.get(i).getFounder()%></td>
        <td class= "centerButton">
            <form method="post" action="">
                <button type="submit" class="buttonStyle"><img class="imgStyle" src="images/download.png"/></button>
                <input type="hidden" name="courseId" value="<%%>">
            </form>
        </td>
        <td class= "centerButton">
            <form method="post" action="/editCourse">
                <button type="submit" class="buttonStyle"><img class="imgStyle" src="images/edit.png"/></button>
                <input type="hidden" name="courseId" value="<%=courses.get(i).getID()%>">
            </form>
        </td>

        <td class= "centerButton">
            <form method="post" action="/deleteCourse">
                <button type="submit" class="buttonStyle"><img class="imgStyle" src="images/erase.png"/></button>
                <input type="hidden" name="courseId" value="<%=courses.get(i).getID()%>">
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
