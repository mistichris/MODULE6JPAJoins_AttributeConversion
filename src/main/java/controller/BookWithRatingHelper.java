package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.BookWithRating;

/**
 * @author Misti Christianson - mchristianson
 * CIS175 - Spring 2024
 * Mar 4, 2024
 */
public class BookWithRatingHelper {
static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebBooksJPAJoinsAttributeConv2");
	
	public void insertBookWithRating(BookWithRating li) {							
		EntityManager em = emfactory.createEntityManager();			//creates a new instance of the Entity Manager
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();													//closes Entity Manager
	}

	@SuppressWarnings("unchecked")
	public List<BookWithRating> showAllBookWithRating(){
		EntityManager em = emfactory.createEntityManager();											//creates a new instance of the Entity Manager
		List<BookWithRating> allObjects = em.createQuery("SELECT i FROM BookWithRating i").getResultList();		//retrieves all instances of the item from the table
		return allObjects;
		}
	
	//delete an book from the database
	@SuppressWarnings("unused")
	public void deleteItem(BookWithRating toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<BookWithRating> typedQuery = em.createQuery("Select li from BookWithRating li where li.id = :selectedId", 
				BookWithRating.class);
		typedQuery.setParameter("selectedId", toDelete.getId());

		// we only want on result
		typedQuery.setMaxResults(1);

		// get the result and save it into a new list book
		BookWithRating result = typedQuery.getSingleResult();					//creating a ListBook object for the results

		// remove it
		em.remove(result);					//removing result/book from table in database
		em.getTransaction().commit();
		em.close();							//closing the Entity Manager
	}
	
	//update book in database script
	public void updateItem(BookWithRating toEdit) {
		EntityManager em = emfactory.createEntityManager();			//new instance of Entity Manager Factory
		em.getTransaction().begin();
		em.merge(toEdit);				//merging edits with current item in database using toEdit object from ListBook created in Start Program created in editABook method
		em.getTransaction().commit();
		em.close();						//closing the Entity Manager
		}
		
	//Search for Book by ID script
	public BookWithRating searchForItemById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();				//new instance of Entity Manager Factory
		em.getTransaction().begin();
		BookWithRating found = em.find(BookWithRating.class, idToEdit);				
		em.close();														//closing the Entity Manager
		return found;
		}

	//closing Entity Manager Factory
	public void cleanUp(){
		emfactory.close();
		}
	
	
}
