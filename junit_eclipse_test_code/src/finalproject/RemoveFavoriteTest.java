package finalproject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class RemoveFavoriteTest {
	
	
	@Test
	void testRemoveFavoriteWithPreexistingBook() {
		
		/* Begin Test Data Definitions */
		String title1 = "Harry Potter and the Sorcerer\'s Stone";
		List<String> authors1 = new ArrayList<>(); authors1.add("J.K. Rowling");
		String publishDate1 = "01-09-1998";
		List<String> hyperlinks1 =  new ArrayList<>(); hyperlinks1.add("https://www.amazon.com/Harry-Potter-Sorcerers-Stone-Rowling/dp/059035342X/");
		double price1 = 9.49;
		String publisher1 = "Scholastic";
		String isbn1 = "9780606170970";
		
		Book book1 = new Book(title1, authors1, publishDate1, hyperlinks1, price1, publisher1, isbn1);
		
		String title2 = "Harry Potter and the Chamber of Secrets";
		List<String> authors2 = new ArrayList<>(); authors2.add("J.K. Rowling");
		String publishDate2 = "01-09-2000";
		List<String> hyperlinks2 =  new ArrayList<>(); hyperlinks2.add("https://www.amazon.com/Harry-Potter-Chamber-Secrets-Rowling/dp/0439064872/");
		double price2 = 9.49;
		String publisher2 = "Scholastic";
		String isbn2 = "9780439064873";
		
		Book book2 = new Book(title2, authors2, publishDate2, hyperlinks2, price2, publisher2, isbn2);
		
		UserAccount userAcc = new UserAccount("example@email.com", "exampleUsername", "examplePassword");
		userAcc.addFavorite(book1);
		
		// Make copy of favorites list with only book1
		List<Book> expected_favorites = new ArrayList<>(userAcc.getFavorites());
		
		userAcc.addFavorite(book2);		
		/* End Test Data Definitions */
	
		/* Begin Test */
		// Remove a book that is in favorites list
		userAcc.removeFavorite(book2);
		assertEquals("Favorites lists should only contain one book with isbn = " + book1 + " after removing book with isbn = " + book2,
						expected_favorites, userAcc.getFavorites());
		/* End Test */
	}
	
	@Test
	void testRemoveFavoriteWithNonexistentBook() {

		/* Begin Test Data Definitions */
		String title1 = "Harry Potter and the Sorcerer\'s Stone";
		List<String> authors1 = new ArrayList<>(); authors1.add("J.K. Rowling");
		String publishDate1 = "01-09-1998";
		List<String> hyperlinks1 =  new ArrayList<>(); hyperlinks1.add("https://www.amazon.com/Harry-Potter-Sorcerers-Stone-Rowling/dp/059035342X/");
		double price1 = 9.49;
		String publisher1 = "Scholastic";
		String isbn1 = "9780606170970";
		
		Book book1 = new Book(title1, authors1, publishDate1, hyperlinks1, price1, publisher1, isbn1);
		
		String title2 = "Harry Potter and the Chamber of Secrets";
		List<String> authors2 = new ArrayList<>(); authors2.add("J.K. Rowling");
		String publishDate2 = "01-09-2000";
		List<String> hyperlinks2 =  new ArrayList<>(); hyperlinks2.add("https://www.amazon.com/Harry-Potter-Chamber-Secrets-Rowling/dp/0439064872/");
		double price2 = 9.49;
		String publisher2 = "Scholastic";
		String isbn2 = "9780439064873";
		
		Book book2 = new Book(title2, authors2, publishDate2, hyperlinks2, price2, publisher2, isbn2);
		
		UserAccount userAcc = new UserAccount("example@email.com", "exampleUsername", "examplePassword");
		userAcc.addFavorite(book1);
		
		// Make copy of favorites list with only book1
		List<Book> expected_favorites = new ArrayList<>(userAcc.getFavorites());
		
		/* End Test Data Definitions */
	
		/* Begin Test */
		
		// Remove a book that is in favorites list
		userAcc.removeFavorite(book2);
		assertEquals("Favorites lists should not be affected by trying to remove book that is not in the list " + book1,
				expected_favorites, userAcc.getFavorites());
		
		/* End Test */
	}
	
	@Test
	void testRemoveFavoriteWithInvalidObjectType() {
		/* Begin Test Data Definitions */
		String title1 = "Harry Potter and the Sorcerer\'s Stone";
		List<String> authors1 = new ArrayList<>(); authors1.add("J.K. Rowling");
		String publishDate1 = "01-09-1998";
		List<String> hyperlinks1 =  new ArrayList<>(); hyperlinks1.add("https://www.amazon.com/Harry-Potter-Sorcerers-Stone-Rowling/dp/059035342X/");
		double price1 = 9.49;
		String publisher1 = "Scholastic";
		String isbn1 = "9780606170970";
		
		Book book1 = new Book(title1, authors1, publishDate1, hyperlinks1, price1, publisher1, isbn1);
		
		String title2 = "Harry Potter and the Chamber of Secrets";
		List<String> authors2 = new ArrayList<>(); authors2.add("J.K. Rowling");
		String publishDate2 = "01-09-2000";
		List<String> hyperlinks2 =  new ArrayList<>(); hyperlinks2.add("https://www.amazon.com/Harry-Potter-Chamber-Secrets-Rowling/dp/0439064872/");
		double price2 = 9.49;
		String publisher2 = "Scholastic";
		String isbn2 = "9780439064873";
		
		Book book2 = new Book(title2, authors2, publishDate2, hyperlinks2, price2, publisher2, isbn2);
		
		UserAccount userAcc = new UserAccount("example@email.com", "exampleUsername", "examplePassword");
		userAcc.addFavorite(book1);
		userAcc.addFavorite(book2);
		
		// Make copy of favorites list with only book1
		List<Book> expected_favorites = new ArrayList<>(userAcc.getFavorites());
		
		// Invalid object type
		String invalid_object = "Invalid Object";
	
		/* End Test Data Definitions */
	
		/* Begin Test */
		
		// Attempt to remove an invalid object type
		userAcc.removeFavorite(invalid_object);
		assertEquals("Favorites lists should not be affected by passing in an invalid object.",
				expected_favorites, userAcc.getFavorites());
		
	
		/* End Test */
	}
	
	@Test
	void testRemoveFavoriteWithInvalidPrimitveType() {
		
		/* Begin Test Data Definitions */
		// Book 1
		String title1 = "Harry Potter and the Sorcerer\'s Stone";
		List<String> authors1 = new ArrayList<>(); authors1.add("J.K. Rowling");
		String publishDate1 = "01-09-1998";
		List<String> hyperlinks1 =  new ArrayList<>(); hyperlinks1.add("https://www.amazon.com/Harry-Potter-Sorcerers-Stone-Rowling/dp/059035342X/");
		double price1 = 9.49;
		String publisher1 = "Scholastic";
		String isbn1 = "9780606170970";
		Book book1 = new Book(title1, authors1, publishDate1, hyperlinks1, price1, publisher1, isbn1);
		// Book 2
		String title2 = "Harry Potter and the Chamber of Secrets";
		List<String> authors2 = new ArrayList<>(); authors2.add("J.K. Rowling");
		String publishDate2 = "01-09-2000";
		List<String> hyperlinks2 =  new ArrayList<>(); hyperlinks2.add("https://www.amazon.com/Harry-Potter-Chamber-Secrets-Rowling/dp/0439064872/");
		double price2 = 9.49;
		String publisher2 = "Scholastic";
		String isbn2 = "9780439064873";
		Book book2 = new Book(title2, authors2, publishDate2, hyperlinks2, price2, publisher2, isbn2);
		
		UserAccount userAcc = new UserAccount("example@email.com", "exampleUsername", "examplePassword");
		userAcc.addFavorite(book1); // Add book 1 to favorites list
		userAcc.addFavorite(book2); // Add book 2 to favorites list
		
		// Make copy of favorites list for expected result
		List<Book> expected_favorites = new ArrayList<>(userAcc.getFavorites());
		
		// Invalid primitive type
		int invalid_primitive = 12345;
		/* End Test Data Definitions */
	
		/* Begin Test */
		// Attempt to remove an invalid primitive data type
		userAcc.removeFavorite(invalid_primitive);
		assertEquals("Favorites lists should not be affected by passing in an invalid primitive data type.",
				expected_favorites, userAcc.getFavorites());
		/* End Test */
	}
}
