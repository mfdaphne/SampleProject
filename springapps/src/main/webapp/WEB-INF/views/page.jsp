<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />


<!DOCTYPE html>
<html lang="en">
<head>
</head>


<body>

	<div class="container">
					<form:form method="POST" action="/springapps/contactme" modelAttribute="contact">
						<table>
							<tr>
								<td><form:label path="fname">First Name</form:label></td>
								<td><form:input path="fname" /></td>
							</tr>
							<tr>
								<td><form:label path="lname">Last Name</form:label></td>
								<td><form:input path="lname" /></td>
							</tr>
							<tr>
								<td><form:label path="email">E-Mail</form:label></td>
								<td><form:input path="email" /></td>
							</tr>
							<tr>
								<td><form:label path="phone">Phone</form:label></td>
								<td><form:input path="phone" /></td>
							</tr>
							<tr>
								<td><form:label path="message">Your Message</form:label></td>
								<td><form:input path="message" /></td>
							</tr>
							<tr>
								<td><input type="submit" value="Submit" /></td>
							</tr>
						</table>
					</form:form>
			</div>
</body>
</html>

