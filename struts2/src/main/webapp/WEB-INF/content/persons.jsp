<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Struts 2 - List Persons</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>

<h1>Persons</h1>
<ul>
<s:iterator value="allPersons">
    <li><a href="persons/${id}">${firstname} <s:property value="lastname"/></a> </li>
</s:iterator>
</ul>

</body>
</html>
