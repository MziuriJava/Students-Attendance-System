<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 4/21/2018
  Time: 5:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>კურსი</title>
</head>
<body>

<div class="course">
    <form method="post" action="/uploadServlet" enctype="multipart/form-data">
        <h2 class="inputadd"> კურსი </h2>
        <div style="text-align: center;">
            <p>კურსის სახელი</p>
            <input class =courseNameInput type="text" name="course_name">

            <p>საერთო გაკვეთილების რაოდენობა</p>
            <select class="courseLengthInput" name="course_length">
                <option value="70">70 გაკვეთილი</option>
                <option value="64">64 გაკვეთილი</option>
                <option value="58">56 გაკვეთილი</option>
            </select>
            <p>კვირაში გაკვეთილების რაოდენობა</p>
            <select class="courseLengthInput" name="lessons_per_week">
                <option value="4">4 გაკვეთილი</option>
                <option value="3">3 გაკვეთილი</option>
                <option value="2">2 გაკვეთილი</option>
                <option value="1">1 გაკვეთილი</option>
            </select>
            <p>გაკვეთილის დრო</p>
            <select class="courseLengthInput" name="course_lesson_time">
                <option value="3">3 საათი</option>
                <option value="2">2 საათი</option>
                <option value="1:30">1 საათი 30 წუთი</option>
                <option value="1">1 საათი</option>
            </select>
            <p>ფასი</p>
            <input class="coursePriceInput" type="number" name="price">
            <p>აღწერა</p>
            <textarea class="courseDescriptionInput" name="description"> </textarea>
            <p>სილაბუსი</p>
            <input type="file" name="Syllabus"  class="AddsyllabusSize">
            <input type="submit"  class="shesvlasize">
        </div>
    </form>
</div>
</body>
</html>
