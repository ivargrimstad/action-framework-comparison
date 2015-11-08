<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Struts 2 - Show/Edit Person</title>
    <sb:head/>
</head>
<body>

<div class="container-fluid">
    <h1>Person</h1>
    <ul>
        <li>${person.id}</li>
        <li>${person.firstname}</li>
        <li>${person.lastname}</li>
    </ul>
</div>

</body>
</html>
