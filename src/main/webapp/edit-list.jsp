<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit List Details Page</title>
</head>
<body>
	<h1>Edit List:</h1>
	<form action="EditListDetailsServlet" method="post">
		<input type="hidden" name="id" value="${listToEdit.id}"> 
		<p>List Name: <input type="text" name="listName" value="${listToEdit.listName}"></p>
		<p>List Creator: ${listToEdit.bookListOwner}</p>
		<p>Created On: ${listToEdit.createdDate})</p>
		<h2>Select Books To Add to List:</h2>
		<!-- for loop inside a for loop; add one at a time-->
		<div>
			<c:forEach items="${requestScope.allItems}" var="currentItem">
				<div>
					<p><input type="checkbox" id="allItemsToAdd" name="allItemsToAdd"
						value="${currentItem.id}"> 	Title: ${currentItem.book}	Author: ${currentItem.author}	Genre: ${currentItem.genre}</p>
				</div>
			</c:forEach>
		</div>
		<input type="submit" value="Edit List and Add Items">
	</form>
	<form action="ViewAllBooksServlet" method="get">
		<button type="submit">View Books List</button>
	</form>
		<form action="ViewAllListsServlet" method="get">
		<button type="submit">View Books Read Lists</button>
	</form>
	<button onclick="window.location.href='index.html'">Main Menu</button>

</body>
</html>