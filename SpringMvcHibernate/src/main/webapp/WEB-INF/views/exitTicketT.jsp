<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/fragments/headerTeacher.jspf" %>
</head>
<body>
<div class="wrapper">
		<div class="one">
			<form method="GET">
			<button type="submit" class="btn btn-primary" name="showETInput" value="showETInput">
			<span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span>
			Create a new Exit Ticket</button>
			</form>
			<br><br><br>
			<form method="GET">
			<button type="submit" class="btn btn-primary" name="showETList" value="showETList">
			
			Search by Ticket list</button>
			</form>
			<br><br><br>
			<form method="GET">
			<button type="submit" class="btn btn-primary" name="showETList" value="showUserList">Search by user list</button>
			</form>
		</div>
		
		<div class="two">
			In this section you can write an exit ticket or you can check the results of the exit tickets of the students.
		</div>
		
		<div class="three">
			<c:if test="${showETList == 'showETList'}">
				<!-- TABLE WITH EXIT TICKETS -->
				<table class="table table-striped table-hover"
					style="background: #fff;">
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
												name="showETList" value="showUsersForET">View Responses</button>
										</form>
									</div>
								</td>
								<td>
									<div style="float: right;">
										<form method="GET">
											<input type="hidden" name="id" value="${rowData.id}" />
											<button type="submit" class="btn btn-primary"
												name="deleteET" value="yes">
												<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
												
												</button>
										</form>
									</div>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>

			<c:if test="${showETList == 'showUserList'}">
				<!-- TABLE WITH USERS -->
				<table class="table table-striped table-hover"
					style="background: #fff;">
					<thead>
						<tr>
							<th>User ID#</th>
							<th>User Name</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="rowData" items="${usersList}" varStatus="status">
							<tr>
								<td>${rowData.id}</td>
								<td>${rowData.userRealName}
								
								<c:if test="${not empty countList}">
								<span class="label label-pill label-primary">${countList[status.index]}</span>
								</c:if>
								</td>

								<td>
									<div style="float: right;">
										<form method="GET">
											<input type="hidden" name="id" value="${rowData.id}" />
											<button type="submit" class="btn btn-primary"
												name="showETList" value="showETForUser">View</button>
										</form>
									</div>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>

			<c:if test="${showETList == 'showUsersForET'}">
				<!-- TABLE WITH USERS THAT HAVE THAT EXIT TICKET -->
				<table class="table table-striped table-hover"
					style="background: #fff;">
					<thead>
						<tr>
							<th>USER ID#</th>
							<th>User Name</th>
							<th>Answer</th>
							<th>Date</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="rowData" items="${usersForET}">
							<tr>
								<td>${rowData.user.id}</td>
								<td>${rowData.user.userRealName}</td>
								<td>${rowData.answer}</td>
								<td>${rowData.dateAnswer}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>

			<c:if test="${showETList == 'showETForUser'}">
				<!-- TABLE OF EXIT TICKETs BY USER-->
				<table class="table table-striped table-hover"
					style="background: #fff;">
					<thead>
						<tr>
							<th>USER ID#</th>
							<th>User Name</th>
							<th>Answer</th>
							<th>Date2</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="rowData" items="${etForUsers}">
							<tr>
								<td>${rowData.user.id}</td>
								<td>${rowData.user.userRealName}</td>
								<td>${rowData.answer}</td>
								<td>${rowData.dateAnswer}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
			
			<c:if test="${not empty showETInput}">
<%-- 				<form method="GET"> --%>
<!-- 					<textarea rows="3" class="form-control" id="questionExitT" hidden="true" placeholder="Enter question" name="questionExitT"> -->
<!-- 					</textarea> -->
<!-- 					<br> -->
<!-- 					<button type="submit" class="btn btn-primary" name="group" value="Group">Send</button> -->
<%-- 				</form> --%>
				Entry ticket question:<br><br>
				<form:form method = "GET" action = "exitTicketT/addExitTicket">
					<form:textarea path = "title" class="form-control" rows = "5" />
					<br>
					<button type="submit" class="btn btn-primary" value="submit">Save</button>
				</form:form>
			</c:if>
		</div>
		<!--  
		<div class="four">Four</div>
		<div class="five">Five</div>
		<div class="six">Six</div>-->
	</div>     
        
</body>
</html>