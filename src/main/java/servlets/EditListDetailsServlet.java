package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.BookListDetailsHelper;
import controller.BookListItemsHelper;
import controller.BookListOwnerHelper;
import model.BookListDetails;
import model.BookListItems;
import model.BookListOwner;


/**
 * Servlet implementation class EditListDetailsServlet
 */
@WebServlet("/EditListDetailsServlet")
public class EditListDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditListDetailsServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			BookListDetailsHelper dao = new BookListDetailsHelper();

			BookListItemsHelper blih = new BookListItemsHelper();
			BookListOwnerHelper bloh = new BookListOwnerHelper();
			
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			BookListDetails listToUpdate = dao.searchForBookListDetailsById(tempId);
			
			String newListName = request.getParameter("listName");
			
			String ownerName = request.getParameter("ownerName");

			// find our add the new BookListOwner
//			BookListOwner newOwner = bloh.findOwner(ownerName);
			try { // items are selected in list to add
				String[] selectedItems = request.getParameterValues("allItemsToAdd");
				List<BookListItems> selectedItemsInList = new ArrayList<BookListItems>();
				for (int i = 0; i < selectedItems.length; i++) {
					System.out.println(selectedItems[i]);
					BookListItems c = blih.searchForBookById(Integer.parseInt(selectedItems[i]));
					selectedItemsInList.add(c);
				}
				listToUpdate.setListOfItems(selectedItemsInList);
			} catch (NullPointerException ex) { // no items selected in list - set to an empty list
				List<BookListItems> selectedItemsInList = new ArrayList<BookListItems>();
				listToUpdate.setListOfItems(selectedItemsInList);
			}
			listToUpdate.setListName(newListName);
//			listToUpdate.setBookListOwner(newOwner);
			dao.updateList(listToUpdate);
			
			getServletContext().getRequestDispatcher("/ViewAllListsServlet").forward(request, response);
	}
}
