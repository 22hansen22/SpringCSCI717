<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="<c:url value='/static/css/css1.css' />" rel="stylesheet"></link>
<%@ include file="/WEB-INF/fragments/headerT.jspf" %>

</head>
<body>
Hi exit ticket Teacher

Add a new Exit ticket
<div class="wrapper">
		<div class="one">
		This is the list of Students in class:<br>
		</div>
		
		<div class="two">
			<c:url var="groupPeople" value="teacherGroup/groupPeople" />
			<form method="GET">
				<input type="text" class="form-control" id="questionExitT" placeholder="Enter question" name="questionExitT">
				<button type="submit" class="btn btn-primary" name="group" value="Group">Group Students</button>
			</form>
		</div>
		
		<div class="three">
			<c:if test="${not empty slists}">
			<c:forEach var="rowData" items="${slists}" varStatus="l1">
				<div style="float:left; margin-left:15px;">
				
				<ul class="list-group-item">
				Group # ${l1.index+1}<br><br>
					<c:forEach var="cellData" varStatus="loop" items="${rowData}">
						<li class="list-group-item" style="background-color:#ccc; font-weight: bold;">${cellData}</li>
					</c:forEach>
				</ul>
				</div>
			</c:forEach>
		</c:if>
			<c:if test="${not empty show}">
			<c:url var="groupPeople" value="teacherGroup/groupPeople" />
			<form method="GET">
				<input type="text" class="form-control" id="questionExitT" placeholder="Enter question" name="questionExitT">
				<button type="submit" class="btn btn-primary" name="group" value="Group">Group Students</button>
			</form>
			
		</div>
		<!--  
		<div class="four">Four</div>
		<div class="five">Five</div>
		<div class="six">Six</div>-->
	</div>     
        
</body>
</html>