<%-- 
    Document   : error
    Created on : Nov 10, 2015, 2:34:37 PM
    Author     : Ivar Grimstad (ivar.grimstad@gmail.com)
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>Error Page</title>
   </head>
   <body>
      <h1>Error Messages</h1>
      <ul class="list-unstyled">
         <c:forEach var="error" items="${errorDataBean.messages}">
            <li>${mvc.encoders.html(error)}</li>
            </c:forEach>
      </ul>
   </body>
</html>
