<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!DOCTYPE HTML>
<html>

        <c:forEach items="${errs}" var="err">

                <h2><c:out value="${err.getDefaultMessage()}"/></h2>
        
            </c:forEach>


	
  
  <a href="/dashboard">Dashboard</a>

<h2> Title: <c:out value="${song.name}" />  </h2>
<h2> Artist: <c:out value="${song.artist}" />  </h2>
<h2> Rating(1-10): <c:out value="${song.rating}" />  </h2>

<a href="/songs/delete/{id}">Delete</a>


</html>















    
	


		

	

