<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
<title>List of customers</title>
</head>
<body>

<div id="wrapper">
	<div id="header">
	<h2>CRM - Customer Relationship Manager</h2>
	</div>
</div>

<div id="container">

	<div id="content">
	
		<!-- put new button: Add Customer -->
		<input type="button" value="Add Customer"
				onclick="window.location.href='showFormForAdd'; return false;" 
				class="add-button"
		/>
		
		
		<!-- add our html table here -->
		<table>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Action</th>
			</tr>
	
	<!-- loop ofer and print our cutomer -->
				<c:forEach var="tempCustomer" items="${customers}">
				
					<!-- consturct and update link with customer id -->
					<c:url var="updateLink" value="/customer/showFormUpdate" >
						<c:param name="customerId" value="${tempCustomer.id}" />
					</c:url>
					
					<c:url var="deleteLink" value="/customer/delete" >
						<c:param name="customerId" value="${tempCustomer.id}" />
					</c:url>
					<tr>
						<td> ${tempCustomer.firstName} </td>
						<td> ${tempCustomer.lastName} </td>
						<td> ${tempCustomer.email} </td>
						<td> 
						
						<a href="${updateLink}">Update</a>
						|
						<a href="${deleteLink}" 
						onclick="if (!(confirm('Are tou sure you want to delete this customer?'))) return false">Delete</a>
						</td>
					</tr>

				</c:forEach>
		</table>
	</div>
</div>

</body>
</html>