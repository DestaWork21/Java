<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Index</title>
		<link rel="stylesheet" type="text/css" href="/css/style.css">	
		<script src="/js/main.js"></script>
		<style>
			.center{
				width: 1000px ;
  				margin-left: 50px;
 				font-size:24px;

			}
		</style>
	</head>

	<body>
		<div class="center">
			<h1>DojoScriptions</h1>
				<h3>A subcription platform</h3>
			<form method="post" action="/login">
				<fieldset>
						<legend>login </legend>
				<h2>Email:<input type="text" name="email"> </h2>
				<h2>Password:<input type="password" name="password"> </h2>
				<input type="submit" name="login">
				</fieldset>
			</form>
			
			<c:if test="${err !=null}" >${err} </c:if>
			
			<form:form action="/register" method="post" modelAttribute="user">
				<fieldset>
					<legend>Register </legend>
			   

				<p>
					<form:label path="firstName">First Name:
						<form:errors path="firstName"></form:errors>
						<form:input path="firstName"></form:input>
					</form:label>
				</p>

				<p>
					<form:label path="lastName">Last Name:
						<form:errors path="lastName"></form:errors>
						<form:input path="lastName"></form:input>
					</form:label>
				</p>
				<p>
						<form:label path="email">Email:
							<form:errors path="email"></form:errors>
							<form:input path="email"></form:input>
						</form:label>
				</p>
				<p>
					<form:label path="password">Password:
						<form:errors path="password"></form:errors>
						<form:input type="password" path="password"></form:input>

					</form:label>

				</p>

				<p>
					<form:label path="confirm">Confirm:
						<form:errors path="confirm"></form:errors>
						<form:input type="password" path="confirm"></form:input>
					</form:label>
				</p>
				<input type="submit" value="Register!" />
			</fieldset>
			<c:if test="${err !=null}" >${err} </c:if>
			</form:form>
		</div>
	</body>
</html>