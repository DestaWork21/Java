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

	</head>



	<body>

        <a href="/logout">Logout!</a>
        <h3>Event are the events in your State:</h3>
        <table>
			<tr>
				<td>Name</td>
				<td>Date</td>
				<td>Location</td>
				<td>Action/ Status</td>
			</tr>
			<c:forEach items="${userStates}" var="event">
				<td><a href="/events/${event.id}">${event.name}</a></td>
				<td>${event.date}</td>
				<td>${event.city}, ${event.state}</td>
			</c:forEach>
		</table>
        <h3>Here are some of the events in other states:</h3>
		<table>
			<tr>
				<td>Name</td>
				<td>Date</td>
				<td>Location</td>
				<td>Action</td>
			</tr>
			<c:forEach items="${notUserStates}" var="event">
				<td><a href="/events/${event.id}">${event.name}</a></td>
				<td>${event.date}</td>
                <td>${event.city}, ${event.state}</td>
                <td><a href="/event/{event_id}/join">join</a></td>
			</c:forEach>
		</table>


        <h1>Welcome ${user.firstName} </h1>
        <form:form method="post" action="/events/new" modelAttribute="event"> 
                <p>
                        <form:label path="name">Name:
                            <form:errors path="name"></form:errors>
                            <form:input path="name"></form:input>
                        </form:label>
                    </p>
    
                    <p>
                        <form:label path="date">Date:
                            <form:errors path="date"></form:errors>
                            <form:input type="date" path="date"></form:input>
                        </form:label>
                    </p>
                    <p>
                        <form:label path="city">City:
                            <form:errors path="city"></form:errors>
                            <form:input path="city"></form:input>
                        </form:label>
                    </p>
                    <p>
                        <form:label path="state">State:
                            <form:errors path="state"></form:errors>
                            <form:input path="state"></form:input>
                        </form:label>
                    </p>
                   
                    <input type="submit" value="createEvent!" />
                


        </form:form>
		

	</body>

</html>