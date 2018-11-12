<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Student</title>
</head>
<body>

<h1>New Student</h1>
<form:form action="/students" method="post" modelAttribute="student">
    <p>
        <form:label path="fname">First Name: </form:label>
        <form:errors path="fname"/>
        <form:input path="fname"/>
    </p>
    <p>
        <form:label path="lname">Last Name: </form:label>
        <form:errors path="lname"/>
        <form:input path="lname"/>
    </p>
    <input type="submit" value="Create"/>
</form:form>    
</body>
</html>