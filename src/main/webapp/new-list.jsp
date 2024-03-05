<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create a New Books Read List</title>
</head>
<body>
	<form action="CreateListServlet" method="post">
		<div>
			<label for="listName">List Name</label> <input type="text"
				name="listName">
		</div>
		<div>
			<label for="firstName">List Owner First Name</label> <input
				type="text" name="firstName">
		</div>
		<div>
			<label for="lastName">List Owner Last Name</label> <input type="text"
				name="lastName">
		</div>

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


		<input type="submit" name="createList" value="Create List">
	</form>

	<form action="ViewAllBooksServlet" method="get">
		<button type="submit">View Books List</button>
	</form>
	<form action="ViewAllListsServlet" method="get">
		<button type="submit">View Books Read Lists</button>
	</form>

	<!-- 	<a href="add-book.jsp">Go add new items instead.</a> -->

</body>
</html>


<%-- 				
					<form>
						<td></td>
						<input type="hidden" id="" value="${}>
						<td colspan="3">Rating: <input type="text" id="ratingToAdd" name="rating" placeholder="1-5"></td>
						<td colspan="3">Read On: <input type="date" id="ratingToAdd" name="date"></td>
					</form> --%>
<!-- 	<div>
						Trip date: <input type="text" name="month" placeholder="mm"
							size="4"> <input type="text" name="day" placeholder="dd"
							size="4">, <input type="text" name="year"
							placeholder="yyyy" size="4">
					</div> -->