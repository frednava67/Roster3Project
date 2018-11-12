
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Course</title>
</head>
<body>
	<h1>Classes</h1>
	<form:form action="/courses" method="post" modelAttribute="course">
	    <p>
	        <form:label path="name">Name: </form:label>
	        <form:errors path="name"/>
	        <form:input path="name"/>
	    </p>
	    <input type="submit" value="Create"/>
	</form:form>
</body>
</html>