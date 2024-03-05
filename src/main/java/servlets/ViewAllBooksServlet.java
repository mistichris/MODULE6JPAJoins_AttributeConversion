package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.BookListItemsHelper;

@WebServlet("/ViewAllBooksServlet")
public class ViewAllBooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ViewAllBooksServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookListItemsHelper dao = new BookListItemsHelper();	//data access object
		request.setAttribute("allBooks", dao.showAllBooks());
		String path = "/bookslist.jsp";
//		if(dao.showAllBooks().isEmpty()) {
//			path = "/index.html";
//		}
		getServletContext().getRequestDispatcher(path).forward(request,  response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
