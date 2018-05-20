<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="en">
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="../css/post.css">
<head>
    <title>პოსტი</title>
</head>
<body>
<div class="box">
    <a class="button" href="#popup1">პოსტის დამატება</a>
</div>
<div id="popup1" class="overlay">
    <div class="popup">
        <h2>გამოაქვეყნე შენი პოსტი:</h2>
        <a class="close" href="#">×</a>
        <form class="content" method="post" action="/sas/addPost">
            <textarea class="posttextsize" cols="50" rows="10" name="post"></textarea>
            <button type="submit">გამოქვეყნება</button>
        </form>
    </div>
</div>
</body>
</html>
