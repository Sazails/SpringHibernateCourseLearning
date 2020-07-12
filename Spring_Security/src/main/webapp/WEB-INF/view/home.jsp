<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>Home page</title>
</head>
<body>
<h2>Home page!</h2>

<hr>
User: <security:authentication property="principal.username"/>
<br>
Role(s): <security:authentication property="principal.authorities"/>

<security:authorize access="hasRole('ADMIN')">
    <br>
    <a href="${pageContext.request.contextPath}/admins">Meeting(Admins)</a>
    <br>
</security:authorize>
<security:authorize access="hasRole('SPECIAL')">
    <br>
    <a href="${pageContext.request.contextPath}/specials">Meeting(Specials)</a>
    <br>
</security:authorize>
<hr>

<form:form action="${pageContext.request.contextPath}/logout" method="post">
    <input type="submit" value="Logout"/>
</form:form>
</body>
</html>