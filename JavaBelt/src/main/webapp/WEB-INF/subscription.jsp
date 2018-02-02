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
			.cen{
				width: 1000px ;
  				margin-left: 50px;
 				font-size:24px;

			}
		</style>
	</head>

	<body>
		<div class="cen">
			<h1>Welcome to DojoScriptions ${user.firstName} </h1>
      
                <h3>Please chose a subscription and start date</h3>
            
                   
                      <a href="/logout">Logout!</a>   
			
				<fieldset>
					<legend>Subscription by user </legend>
			   

				
				
				<form action="/subscription/new" method="POST">
				Due Date <input type ="number" value="1" name="dueDate" min="1" max="31"> </br>
				Package : <select name="subscription">
						<c:forEach items="${subscriptions}" var="sub">
                             <c:if test="${sub.available==true}">
                           <option value="${sub.id}"> ${sub.getSubscriptionName()},( $${sub.getCost()})</option> 
                           </c:if> 
                                
                           </c:forEach>  
							</select> </br>
				<input type="submit" value="Sign up!" />
				
				</form>
			</fieldset>
			
			
		</div>
	</body>
</html>