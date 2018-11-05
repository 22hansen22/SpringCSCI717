<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="<c:url value='/static/css/css1.css' />" rel="stylesheet"></link>
<%@ include file="/WEB-INF/fragments/headerStudent.jspf" %>

</head>
<body>
Hi exit ticket Student     
<div class="wrapper">
        <div class="one">
        	<!-- SHOW TABLE OF EXIT TICKETS -->
        	<table class="table table-striped table-hover" style="background: #fff;">
					<thead>
						<tr>
							<th>ID#</th>
							<th>Exit Ticket Question</th>
							<th>Date</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="rowData" items="${etList}" varStatus="status">
							<tr>
								<td>${rowData.id}</td>
								<td>${rowData.title}
								<c:if test="${not empty countList2}">
								<span class="label label-pill label-success">${countList2[status.index]}</span>
								</c:if>
								</td>
								<td>${rowData.dateET}</td>
								<td>
									<div style="float: right;">
										<form method="GET">
											<input type="hidden" name="id" value="${rowData.id}" />
											<button type="submit" class="btn btn-primary"
												name="showETList" value="editET">
												<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
												</button>
										</form>
									</div>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
		</div>
		
		<div class="two">
			In this section you can write an exit ticket or you can check the results of the exit tickets of the students.
		</div>
		
		<div class="three"></div>
		
		<div class="four">Four</div>
		<div class="five">Five</div>
		<div class="six">Six</div>
	</div>     
        
        
        
</body>
</html>