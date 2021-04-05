<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head></head>

<body>
<h1>Welcome</h1>

You should now have access to navigate to REST API methods.<br/>
<a href="<c:url value="/transactions" />">List all transactions</a><br/>
<a href="<c:url value="/transactions/type/SEPA" />">List SEPA transactions</a><br/>
<a href="<c:url value="/transactions/type/SEPA/total" />">Total of SEPA transactions</a><br/>
<br/>
<a href="<c:url value="/perform_logout" />">Logout</a>

</body>
</html>
