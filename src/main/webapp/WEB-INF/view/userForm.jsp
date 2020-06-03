<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>User Registration</title>
</head>
<body>

<form:form action="processForm" modelAttribute="user">
    First Name <form:input path="firstName"/>
    <br>
    Last Name <form:input path="lastName"/>
    <br>
    Age <form:input path="age"/>
    <br>
    Gender
    <form:select path="gender">
        <form:option value="Male" label="Male"/>
        <form:option value="Female" label="Female"/>
    </form:select>
    <br>
    Team
    <form:select path="team">
        <form:options items="${user.teamOptions}"/>
    </form:select>
    <br>
    Do you believe in magic?
    <form:select path="magic">
        <form:options items="${magicOptions}"/>
    </form:select>
    <br>
    <%--Favorite programming language
    C <form:radiobutton path="programmingLanguage" value="C"/>
    C# <form:radiobutton path="programmingLanguage" value="C#"/>
    C++ <form:radiobutton path="programmingLanguage" value="C++"/>
    Java <form:radiobutton path="programmingLanguage" value="Java"/>
    Python <form:radiobutton path="programmingLanguage" value="Python"/>--%>

    Preferred programming language
    <form:radiobuttons path="programmingLanguage" items="${user.programmingLanguageOptions}"/>
    <br>
    Current Emotion
    Neutral <form:checkbox path="emotionOptions" value="Neutral"/>
    Happy <form:checkbox path="emotionOptions" value="Happy"/>
    Sad <form:checkbox path="emotionOptions" value="Sad"/>
    Angry <form:checkbox path="emotionOptions" value="Angry"/>
    <br>
    <input type="submit" value="Submit"/>
</form:form>

</body>
</html>
