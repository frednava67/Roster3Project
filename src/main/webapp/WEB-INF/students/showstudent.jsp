<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

    <!-- Popper JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    <title>Show Student</title>
</head>

<body>
    <div class="container">
        <br>
        <br>
        <h1>${student.fname} ${student.lname}</h1>
        <br>
        <br>
        <div class="row">
            <div class="col-xl-6 col-lg-6 border">
                <form action="/students/addCourse" method="post">
                    <label>Classes:</label>
                    <select name="courseid">
                        <c:forEach items="${unchosenCourses}" var="course">
                            <option value="${course.id}"><c:out value="${course.name}"/></option>
                        </c:forEach>
                    </select>
                    <br>
                    <input type="hidden" name="studentid" value="${student.id}">
                    <input class="btn btn-primary" type="submit" value="Add">
                </form>
            </div>
        </div>
        <br>
        <div class="row">
            <div class="col-xl-6 col-lg-6 border">
	            <label>Your Schedule:</label>
            <table class="table table-striped table-bordered">
                <thead>
                    <th>Class Name</th>
                    <th>Action</th>
                </thead>
                <tbody>
                        <c:forEach items="${chosenCourses}" var="course">
                    <tr>
                        <td>
                            <c:out value="${course.name}"/>
                        </td>
                        <td>
                            <form action="/students/dropCourse" method="POST">
                                <input type="hidden" name="studentid" value="${student.id}">
                                <input type="hidden" name="courseid" value="${course.id}">
                                <input class="btn btn-danger" type="submit" value="Drop">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
	        </table>
            </div>
        </div>
    </div>
</body>

</html>