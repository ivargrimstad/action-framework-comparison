<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Struts 2 - Show/Edit Actor</title>
    <sb:head/>
    <sj:head/>
</head>
<body>

<div class="container-fluid">
    <s:form action="save" enctype="multipart/form-data" theme="bootstrap" cssClass="form-horizontal"
            label="%{getText('actor.information')}">
        <s:hidden name="actor.id"/>
        <s:textfield key="actor.firstname" />
        <s:textfield key="actor.lastname"/>
        <s:checkbox key="actor.cool"/>
        <s:textfield key="actor.birthday"/>
        <s:textfield key="actor.salary" value="%{getFormatted('format.money','actor.salary')}"/>
        <%-- Alternatively: use datepicker
        <sj:datepicker parentTheme="bootstrap"
                key="actor.birthday"
                cssClass="form-control"
                elementCssClass="col-sm-5"
                showOn="focus"
                inputAppendIcon="calendar"
                displayFormat="dd.mm.yy"/>
        --%>
        <s:submit cssClass="btn btn-default" key="save"/>
        <s:a action="actors" namespace="/" cssClass="btn"><s:text name="actor.back.to.list"/></s:a>
    </s:form>
    <s:actionerror theme="bootstrap"/>
    <s:actionmessage theme="bootstrap"/>
    <s:fielderror theme="bootstrap"/>
</div>

</body>
</html>
