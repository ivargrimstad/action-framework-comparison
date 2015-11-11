<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>MVC 1.0 Hello Demo</title>
    <link rel='stylesheet' href='${pageContext.request.contextPath}/webjars/bootstrap/3.3.5/css/bootstrap.min.css'>
</head>
<body>
<div class="container-fluid">
    <h1>JSR 371 Examples</h1>
    <ul>
        <li><a href="mvc/hello">Say Hello</a></li>
    </ul>
    <ul>
        <li><a href="mvc/hello/faces">Say Hello from Faces</a></li>
    </ul>
    <ul>
        <li><a href="mvc/actors">Actors</a></li>
    </ul>
</div>
<script src="${pageContext.request.contextPath}/webjars/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>
