<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="<c:url value='/static/css/css1.css' />" rel="stylesheet"></link>

</head>
<body>
Error in Page, you must have refresh the page
<c:if test="${not empty msg}"></c:if>
Please go back and 

<a href="">login again.</a>

</body>
</html>