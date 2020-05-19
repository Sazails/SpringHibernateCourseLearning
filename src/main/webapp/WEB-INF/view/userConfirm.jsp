<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Confirmation</title>
</head>
<body>

User confirmed:
<br>
First Name: ${user.firstName}
<br>
Last Name: ${user.lastName}
<br>
Age: ${user.age}
<br>
Gender: ${user.gender}
<br>
Team: ${user.team}
<br>
Magic: ${user.magic}
<br>
Preferred Programming Language: ${user.programmingLanguage}
<br>
Current Emotion:
<ul>
    <c:forEach var="temp" items="${user.emotionOptions}">
    <li>temp</li>
    </c:forEach>
</ul>

</body>
</html>
