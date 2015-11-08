<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<html>
<head>
    <title>Struts 2 - <s:text name="actor.list"/></title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <sb:head/>
</head>
<body>

<div class="container-fluid">
    <h1><s:text name="actor.list"/></h1>
    <ul>
        <s:iterator value="allActors">
            <li><a href="actors/${id}">${firstname} <s:property value="lastname"/></a> </li>
        </s:iterator>
    </ul>
    <a href="<s:url action='new' namespace='/actors'/>" class="btn btn-default" role="button"><s:text name="new"/></a>
</div>

</body>
</html>
