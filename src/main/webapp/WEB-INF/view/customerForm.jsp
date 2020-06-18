<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <style>
        .error {color: red}
    </style>

    <title>Customer Registration Form</title>
</head>
<body>
<form:form action="processForm" modelAttribute="customer">
    First name: <form:input path="firstName" />
    <form:errors path="firstName" cssClass="error"/>
    <br>

    Last Name: <form:input path="lastName" />
    <form:errors path="lastName" cssClass="error"/>
    <br>

    Age: <form:input path="age" />
    <form:errors path="age" cssClass="error"/>
    <br>

    Postal Code: <form:input path="postalCode" />
    <form:errors path="postalCode" cssClass="error"/>
    <br>

    <input type="submit" value="Submit">
</form:form>
</body>
</html>