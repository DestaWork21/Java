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
		<div class="cen">
		<a href="/logout">Logout!</a>
			<h1>Admin Dashboard</h1>  
			   
				<h3>Customers</h3>
            
           		
            
                 <table border=1>

                        <tr>                
                            <th> Name</th>                
                            <th>Next Due Date </th>                
                            <th>Amount due </th>                
                            <th>Package Type </th>                                           
                        </tr>
                          
                        <c:forEach items="${users}" var="user" varStatus="loop">
                            
                          <tr>
                          		 <c:if test="${user.id !=id}"></c:if>
                             <td><c:out value="${user.getFirstName()}"/> </td>                                                   
                             <td><c:out value="${user.getDueDate()}"/></td>              
                             <td><c:out value="${user.subscription.getCost()}"/></td>       
                             <td><c:out value="${user.subscription.getSubscriptionName()}"/></td> 
                
                           </tr>           
                        </c:forEach>               
                    </table>
	
                    <h3>Subscriptions</h3>
            
                    <table border=1>
    
                            <tr>                
                                <th> Package Name</th>                
                                <th> Package cost </th>                
                                <th>Available </th> 
                                <th>Users</th> 
                                <th> Action</th>              
                                                                        
                            </tr>
                       
                       <c:forEach items="${subscriptions}" var="subscription" varStatus="loop">
                             <tr>
                                 	<td><c:out value="${subscription.getSubscriptionName()}"/> </td>                                                   
                                    <td><c:out value="${subscription.getCost()}"/></td>   
                                    <td><c:if test="${subscription.available ==false}">Unavailable </c:if>
                                    	<c:if test="${subscription.available ==true}"> available </c:if>
                                    </td>      
                                                                       
                                    <td> ${subscription.getUsers().size()}</td> 
                                    <c:choose>
                                    <c:when test="${subscription.available==true && subscription.getUsers().size() == 0}">
                                    	<td><a href="changeAvi/${subscription.id}">deactivate</a> <a href="/delete/${subscription.id}">Delete</a></td>
                                    </c:when>
                                    <c:when test="${subscription.available==false && subscription.getUsers().size() == 0}">
                                    	<td><a href="changeAvi/${subscription.id}">activate</a> <a href="/delete/${subscription.id}">Delete</a></td>
                                    </c:when>
                                    <c:when test="${subscription.available==true && subscription.getUsers().size() != 0}">
                                    	<td><a href="changeAvi/${subscription.id}">deactivate</a> </td>
                                    </c:when>
                                    <c:when test="${subscription.available==false && subscription.getUsers().size() != 0}">
                                    	<td><a href="changeAvi/${subscription.id}">activate</a> </td>
                                    </c:when>
                                    </c:choose>
                                     <%-- <td><a href="changeAvi/${subscription.id}">deactivate</a> <a href="/delete/${id}>Delete</a></td> --%>
                                   
                    
                              </tr>             
                           </c:forEach>       
                      </table>

			<form:form action="/admin" method="post" modelAttribute="subscription">
				<fieldset>
					<legend>Create Subscription </legend>
			   

				<p>
					<form:label path="subscriptionName"> Subscription Name:
						<form:errors path="subscriptionName"></form:errors>
						<form:input path="subscriptionName"></form:input>
					</form:label>
				</p>

				<p>
					<form:label path="cost">Cost:
						<form:errors path="cost"></form:errors>
						<form:input path="cost"></form:input>
					</form:label>
				</p>
							
				<input type="submit" value="Create new Subscription!" />
			</fieldset>
			<c:if test="${err !=null}" >${err} </c:if>
			</form:form> 
		</div>
	</body>
</html>