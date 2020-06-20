<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>

<head>
	<title> Szafranski Spring Security demo app</title>
</head>

<body>
	<h2>Szafranski Company Home Page</h2>
	<hr>
	
	<p>
	Welcome to the Szafranski company home page!
	</p>
	
	<hr>
		<p>
			<!-- Display username and role -->
			User: <security:authentication property="principal.username" />
			<br><br>
			Role(s): <security:authentication property="principal.authorities" />
		</p>
		
		<hr>
		
		<security:authorize access="hasRole('MANAGER')">
		<!-- Add a link to point a /leaders ... this is for the managers -->
		<p>
			<a href="${pageContext.request.contextPath}/leaders">LeaderShip Meeting</a>
			(Only for managers)
		</p>
		<hr>
		
		</security:authorize>
		
		<security:authorize access="hasRole('ADMIN')">
		<!-- Add a link to point a /system ... this is for the admins -->
		<p>
			<a href="${pageContext.request.contextPath}/systems">IT Systems Meeting</a>
			(Only for Admin peoples)
		</p>
		</security:authorize>
	
	
	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout" 
			   method="POST">
			   
		<input type="submit" value="Logout" />
	
	</form:form>
</body>

</html>