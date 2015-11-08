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
    <s:form action="save" enctype="multipart/form-data" theme="bootstrap" cssClass="form-horizontal"
            label="%{getText('person.information')}">
        <s:hidden name="person.id"/>
        <s:textfield key="person.firstname" tooltip="Enter your fist name here"/>
        <s:textfield key="person.lastname" tooltip="Enter your last name here"/>
        <s:submit cssClass="btn btn-default" key="save"/>
        <s:a action="persons" namespace="/" cssClass="btn"><s:text name="person.back.to.list"/></s:a>
    </s:form>
    <s:actionerror theme="bootstrap"/>
    <s:actionmessage theme="bootstrap"/>
    <s:fielderror theme="bootstrap"/>
</div>

</body>
</html>
