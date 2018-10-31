<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="<c:url value='/static/css/css1.css' />" rel="stylesheet"></link>
<%@ include file="/WEB-INF/fragments/headerTeacher.jspf" %>

</head>
<body>
<div class="wrapper">
		<div class="one">
			<form method="GET">
			<button type="submit" class="btn btn-primary" name="showETInput" value="showETInput">Create a new Exit Ticket</button>
			</form>
			<br><br><br>
			<form method="GET">
			<button type="submit" class="btn btn-primary" name="showETList" value="showET">Search by Ticket list</button>
			</form>
			<br><br><br>
			<form method="GET">
			<button type="submit" class="btn btn-primary" name="showETList" value="showU">Search by user list</button>
			</form>
		</div>
		
		<div class="two">
			In this section you can write an exit ticket or you can check the results of the exit tickets of the students.
		</div>
		
		<div class="three">
			<c:if test="${not empty showETList}">
				<!-- TABLE WITH EXIT TICKETS -->
				<table class="table table-striped table-hover" style="background:#fff;">
						<thead>
							<tr>
								<th>ID</th>
								<th>Exit Ticket/User</th>
								<th></th>
							</tr>
						</thead>
						${headerx}
						<tbody>
							<c:forEach items="${etList}" var="etList" varStatus="loop">
							<tr>
								<td style="width: 40px;">${loop.index+1}</td>
								<td>${etList}</td>
								<td>
								<div style="float:right;">
								<form method="GET">
									<input type="hidden" name="id" value="${loop.index+1}" />
									<button type="submit" class="btn btn-primary" name="showETList" value="${loop.index+1}">View</button>
								</form>
								</div>
								</td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
			</c:if>
		
			<c:if test="${not empty showETList}">
				<c:if test="${not empty etList}">
					<table class="table table-striped table-hover" style="background:#fff;">
						<thead>
							<tr>
								<th>ID</th>
								<th>Exit Ticket/User</th>
								<th></th>
							</tr>
						</thead>
						${headerx}
						<tbody>
							<c:forEach items="${etList}" var="etList" varStatus="loop">
							<tr>
								<td style="width: 40px;">${loop.index+1}</td>
								<td>${etList}</td>
								<td>
								<div style="float:right;">
								<form method="GET">
									<input type="hidden" name="id" value="${loop.index+1}" />
									<button type="submit" class="btn btn-primary" name="showETList" value="${loop.index+1}">View</button>
								</form>
								</div>
								</td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:if>
			</c:if>
			
			<c:if test="${not empty showETInput}">
				<form method="GET">
					<input type="text" class="form-control" id="questionExitT" placeholder="Enter question" name="questionExitT">
					<button type="submit" class="btn btn-primary" name="group" value="Group">Send</button>
				</form>
			</c:if>
		</div>
		<!--  
		<div class="four">Four</div>
		<div class="five">Five</div>
		<div class="six">Six</div>-->
	</div>     
        
</body>
</html>