<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

    <title> Secret Code </title>

    <link href="css/style.css" rel="stylesheet"></link>

</head>

<body>

	<c:out value="${err}" />

	<h2>What is the code?</h2>

	<form action="/process" method="post">

		<input name="code" type="text"></input>

		<input type="submit"></input>

	</form>

</body>

</html>