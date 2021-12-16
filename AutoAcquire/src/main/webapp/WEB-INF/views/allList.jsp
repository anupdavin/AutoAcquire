<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Lists</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<style type="text/css">
tr:first-child {
	font-weignt: bold;
	background-color: #c6c9c4
}
</style>
</head>
<body>
	<div class="container">
		<h2>All Lists</h2>
		<c:if test="${not empty success}">
			<div class="alert alert-success" role="alert">${success}</div>
		</c:if>

		<hr />
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<td>MSISDN</td>
					<td>SimType</td>
					<td>Name</td>
					<td align="center">Gender</td>
					<td>IdNumber</td>
					<td>Date Of Birth</td>
					<td>Address</td>
					<td>Status</td>
				</tr>
				<c:forEach items="${allautoacquire}" var="autoacquire">
					<tr>
						<td> <a href="${pageContext.request.contextPath}/accept/${autoacquire.msisdn}"> ${autoacquire.msisdn}</a></td>
						<td>${autoacquire.simType}</td>
						<td>${autoacquire.name}</td>
						<td>${autoacquire.gender}</td>
						<td>${autoacquire.idNumber}</td>
						<td>${autoacquire.dateOfBirth}</td>
						<td>${autoacquire.address}</td>
						<td>${autoacquire.status}</td>
						
					</tr>
				</c:forEach>
		</table>
		<hr />
		
	</div>
</body>
</html>