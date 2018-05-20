<%@ page import="ge.mziuri.dao.staff.StaffDAO" %>
<%@ page import="ge.mziuri.dao.staff.StaffDAOImpl" %>
<%@ page import="ge.mziuri.model.user.staff.Staff" %>
<%@ page import="ge.mziuri.model.user.staff.StaffStatus" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<meta charset="UTF-8">
<head>
    <title>Main</title>

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../css/main.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<%
    Staff staff = (Staff) session.getAttribute("staff");
%>
<div
        class="w3-sidebar w3-bar-block w3-card w3-animate-left" style="display:none" id="mySidebar">
    <button class="w3-bar-item w3-button w3-large"
            onclick="w3_close()">დახურვა &times;
    </button>
    <%
        if (staff.getStaffStatus() == StaffStatus.ADMIN) {
    %>
        <a href="/sas/main.jsp" class="w3-bar-item w3-button">მთავარი</a>
        <a href="/sas/admin/loadStaffs" class="w3-bar-item w3-button">თანამშრომლები</a>
        <a href="/sas/admin/loadStudents" class="w3-bar-item w3-button">მოსწავლეები</a>
        <a href="/sas/admin/loadCourse" class="w3-bar-item w3-button">კურსები</a>
        <a href="/sas/admin/loadGroups" class="w3-bar-item w3-button">ჯგუფები</a>
        <a href="/sas/admin/loadAssessments" class="w3-bar-item w3-button">შეფასებები</a>
    <%
    } else if (staff.getStaffStatus() == StaffStatus.TEACHER) {
    %>
        <a href="/sas/main.jsp" class="w3-bar-item w3-button">მთავარი</a>
        <a href="/sas/admin/loadTeacherGroups" class="w3-bar-item w3-button">ჯგუფები</a>
        <a href="/sas/admin/loadAssessments" class="w3-bar-item w3-button">შეფასებები</a>
    <%
        }
    %>
</div>

<div id="main">

    <div class="w3-teal">
        <button id="openNav" class="w3-button w3-teal w3-xlarge" onclick="w3_open()">&#9776;</button>
        <div class="w3-container">
            <h1><div class="dropdown">
                <button class="dropbtn">Dropdown</button>
                <div class="dropdown-content">

                    <a href="#">პაროლის შეცვლა</a>
                    <a href="#">გასვლა</a>
                </div>
            </div>
                <div class="nav">ვინმე ვინმე</div></h1>
        </div>
    </div>


    <div class="one">
        <div class="c">
            ვინმე ვინმეძე
            <div class="nav">22/22/2222</div>
        </div>
        <div class="y">
            რაღაცა რაღაცა რაღაცა რაღაცა რაღაცა რაღაცა რაღაცა რაღაცა რაღაცა რაღაცა რაღაცა რაღაცა რაღაცა რაღაც რაღაცა
            რაღაცა რაღაცა რაღაცა რაღაცა რაღაცა რაღაცა რაღაცა რაღაცა რაღაცა რაღაცა რაღაცა რაღაცა რაღაცა რაღაცა რაღაცა
        </div>
        <br>
        <div class="two">
            ვინმე ვინმეშვილი (22/22/2222): ვიღაცა ვიღაცა??
        </div>
        <div class="two">
            ვინმე ვინმეშვილი (22/22/2222): ვინმე ვინმე??
        </div>
        <div class="two">
            ვინმე ვინმეშვილი (22/22/2222): სადღაც სადღაც??
        </div>
        <button class="btn info">სრულად</button>
        <div>
            <br>
        </div>
    </div>
    <br/>
    <div class="one" `>
        <div class="c">
            ვინმე ვინმეძე
            <div class="nav">22/22/2222</div>
        </div>
        <div class="y">
            რაღაცა რაღაცა რაღაცა რაღაცა რაღაცა რაღაცა რაღაცა რაღაცა რაღაცა რაღაცა რაღაცა რაღაცა რაღაცა რაღაც რაღაცა
            რაღაცა რაღაცა რაღაცა რაღაცა რაღაცა რაღაცა რაღაცა რაღაცა რაღაცა რაღაცა რაღაცა რაღაცა რაღაცა რაღაცა რაღაცა
        </div>
        <br>
        <div class="two">
            ვინმე ვინმეშვილი (22/22/2222): ვიღაცა ვიღაცა??
        </div>

        <div class="two">
            ვინმე ვინმეშვილი (22/22/2222): ვინმე ვინმე??
        </div>

        <div class="two">
            ვინმე ვინმეშვილი (22/22/2222): სადღაც სადღაც??
        </div>
        <button class="btn info">სრულად</button>
        <div>
            <br>
        </div>
    </div>
    <br/>

    <div class="one" `>
        <div class="c">
            ვინმე ვინმეძე
            <div class="nav">22/22/2222</div>
        </div>
        <div class="y">
            რაღაცა რაღაცა რაღაცა რაღაცა რაღაცა რაღაცა რაღაცა რაღაცა რაღაცა რაღაცა რაღაცა რაღაცა რაღაცა რაღაც რაღაცა
            რაღაცა რაღაცა რაღაცა რაღაცა რაღაცა რაღაცა რაღაცა რაღაცა რაღაცა რაღაცა რაღაცა რაღაცა რაღაცა რაღაცა რაღაცა
        </div>
        <br>
        <div class="two">
            ვინმე ვინმეშვილი (22/22/2222): ვიღაცა ვიღაცა??
        </div>
        <div class="two">
            ვინმე ვინმეშვილი (22/22/2222): ვინმე ვინმე??
        </div>
        <div class="two">
            ვინმე ვინმეშვილი (22/22/2222): სადღაც სადღაც??
        </div>
        <button class="btn info">სრულად</button>
        <div>
            <br>
        </div>
    </div>
    <br/>


    <script>
        function w3_open() {
            document.getElementById("main").style.marginLeft = "25%";
            document.getElementById("mySidebar").style.width = "25%";
            document.getElementById("mySidebar").style.display = "block";
            document.getElementById("openNav").style.display = 'none';
        }

        function w3_close() {
            document.getElementById("main").style.marginLeft = "0%";
            document.getElementById("mySidebar").style.display = "none";
            document.getElementById("openNav").style.display = "inline-block";
        }
    </script>

</body>
</html>