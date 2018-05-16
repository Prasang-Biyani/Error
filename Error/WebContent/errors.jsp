<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Errors</title>
<style>
table {
    border-collapse: collapse;
    width: 100%;
}

th, td {
    text-align: left;
    border: 1px solid #ddd;
    padding: 8px;
}

tr:nth-child(even) {background-color: #f2f2f2;}
</style>
</head>
<body>
	<table>
		<tr>
			<th>ID</th>
			<th>Category</th>
			<th>Description</th>
			<th>Date</th>
			<th>Time</th>
		</tr>
		<c:forEach items = "${errors}" var = "error">
			<tr>
				<td><c:out value="${error.eid}"/></td>
				<td><c:out value="${error.category}"/></td>
				<td><c:out value="${error.descri}"/></td>
           		<td><c:out value="${error.date}"/></td>
           		<td><c:out value="${error.time}"/></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>