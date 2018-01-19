<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>



<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!DOCTYPE HTML>

<html>

	<c:forEach items="${errs}" var="err">

		<h2><c:out value="${err.getDefaultMessage()}"/></h2>

	</c:forEach>
	<style>
		.wraper{
			background-color:antiquewhite;
			width:800px;
			align:center; 
			margin-left:300px; 
			
		}
	</style>
    <div class="wraper">
		<div align="center">

			<h3><a href="/songs/new">Add New</a></h3>

			<h3><a href="/songs/top10">Top Songs</a></h3>

			<form method="post" action="/search">

				<input type="text" name="artist"></input>

				<input type="submit" value="Search Artists"></input>

			</form>

		</div>

	
		<div>

			<table style="width:100%", border="0.1px">

				<tr>
					<th>Name</th>
					<th>Artist</th>
					<th>Rating</th>
					<th>Actions</th>

				</tr>
				<c:forEach items="${songs}" var="song" varStatus="loop" >

					<tr>
						<td><a href="/songs/${song.id}"><c:out value="${song.name}"/></a></td>
						<td><c:out value="${song.artist}" /></td>
						<td><c:out value="${song.rating}" /></td>
						<td> <a href="/songs/delete/${song.id}">Delete</a></td>
					</tr>
				</c:forEach>

			</table>

		</div>
	</div>

</html>