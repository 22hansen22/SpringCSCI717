<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/fragments/headerTeacher.jspf" %>
</head>
<body>
Welcome to the teacher group page<br>

<hr>
	<div class="wrapper">
		<div class="one">
		This is the list of Students in class:<br><br>
			<c:if test="${not empty lists}">
				<ul class="list-group-item">
					<c:forEach items="${lists}" var="lists">
						<li class="list-group-item">${lists}</li>
					</c:forEach>
				</ul>
			</c:if>
		</div>
		
		<div class="two">
			<c:url var="groupPeople" value="teacherGroup/groupPeople" />
			<form method="GET">
				<select name="groupSize">
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
				</select>
				<button type="submit" class="btn btn-primary" name="group" value="Group">Group Students</button>
			</form>
			<c:if test="${not empty gmsg}">
			<br><br>
			${gmsg}
			</c:if>
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
		</div>
		<!--  
		<div class="four">Four</div>
		<div class="five">Five</div>
		<div class="six">Six</div>-->
	</div>

</body>


</html>