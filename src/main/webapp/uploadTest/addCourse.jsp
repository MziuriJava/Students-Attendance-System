<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <%--<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">--%>
    <title>კურსი</title>
</head>
<body>

<div class="course">
    <form method="post" action="/uploadServlet" enctype="multipart/form-data">
        <h2 class="inputadd"> კურსი </h2>
        <div style="text-align: center;">
            <p>კურსის სახელი</p>
            <input class =courseNameInput type="text" name="courseName">
            <p>საერთო გაკვეთილების რაოდენობა</p>
            <select class="courseLengthInput" name="courseLength">
                <option value="70">70 გაკვეთილი</option>
                <option value="64">64 გაკვეთილი</option>
                <option value="58">56 გაკვეთილი</option>
            </select>
            <p>კვირაში გაკვეთილების რაოდენობა</p>
            <select class="courseLengthInput" name="lessonsPerWeek">
                <option value="4">4 გაკვეთილი</option>
                <option value="3">3 გაკვეთილი</option>
                <option value="2">2 გაკვეთილი</option>
                <option value="1">1 გაკვეთილი</option>
            </select>
            <p>გაკვეთილის დრო</p>
            <select class="courseLengthInput" name="courseLessonTime">
                <option value="3">3 საათი</option>
                <option value="2">2 საათი</option>
                <option value="1.5">1 საათი 30 წუთი</option>
                <option value="1">1 საათი</option>
            </select>
            <p>ფასი</p>
            <input class="coursePriceInput" type="number" name="price">
            <p>აღწერა</p>
            <textarea class="courseDescriptionInput" name="description"> </textarea>
            <p>სილაბუსი</p>
            <input type="file" name="syllabus"  class="AddsyllabusSize">
            <input type="submit"  class="shesvlasize">
        </div>
    </form>
</div>
</body>
</html>
