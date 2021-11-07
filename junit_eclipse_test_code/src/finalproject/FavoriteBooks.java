package finalproject;

import java.util.ArrayList;
import java.util.List;

public class FavoriteBooks {
	private List<Book> favoritesList;
	private String userId;
	
	
	public FavoriteBooks(String userId) {
		favoritesList = new ArrayList<Book>();
		this.userId = userId;
	}
	
	public void addBook(Book book) {
		favoritesList.add(book);
	}
	
	public void removeBook(Book book) {
		favoritesList.remove(book);
	}
	
	public List<Book> getFavoritesList() {
		return favoritesList;
	}
	
	// Extending equals() method to compare FavoriteBooks objects properly
	@Override
	public boolean equals(Object obj) {
		FavoriteBooks otherList = (FavoriteBooks) obj;
		for (Book book : this.favoritesList)
			if (otherList.getFavoritesList().contains(book) == false)
				return false;
		
		return true;
	}
}
