<%--
  Created by IntelliJ IDEA.
  User: cory.lauscher
  Date: 3/12/2021
  Time: 9:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head></head>

<body>
<h1>This is the body of the sample admin page</h1>

This page is only visible to an admin
<br/>

<a href="<c:url value="/perform_logout" />">Logout</a>

</body>
</html>
