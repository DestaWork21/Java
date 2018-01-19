<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>

</head>

<body>

  <a href="/language/delete/${id}">Delete</a>

  <a href="/">Dashbard</a>

  <form:form method="POST" action="/language/update/${id}" modelAttribute="lang">

      <form:label path="language">language

      <form:errors path="language"/>

      <form:input path="language"/></form:label><br>



      <form:label path="creator">Creator

      <form:errors path="creator"/>

      <form:input path="creator"/></form:label><br>

      <form:label path="version">CurrentVersion

      <form:errors path="version"/>

      <form:input path="version"/></form:label><br>



      <input type="submit" value="Submit"/>

  </form:form>



</body>

</html>