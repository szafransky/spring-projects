<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style2.css" />
<title>List of customers</title>
</head>
<body>



<!-- New code  -->

 <h1>List of customers</h1>
 <input type="button" value="Add Customer"
				onclick="window.location.href='showFormForAdd'; return false;" 
				class="add-button"
		/>
  <div class="tbl-header">
 	
    <table cellpadding="0" cellspacing="0" border="0">
      <thead>
        <tr>
	         <th>First Name</th>
			 <th>Last Name</th>
			 <th>Email</th>
			 <th>Action</th>
        </tr>
      </thead>
    </table>
  </div>
  <div class="tbl-content">
    <table cellpadding="0" cellspacing="0" border="0">
      <tbody>
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

        
      </tbody>
    </table>
  </div>



</body>
</html>