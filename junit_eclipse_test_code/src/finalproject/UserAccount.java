package finalproject;

import java.util.List;

public class UserAccount {
	private String username;
	private String password;
	private String email;
	private String userId;
	private FavoriteBooks favorites;
	
	/* To implement */
	// UserPreferences preferences;
	// RecommendedBooks recommendations;
	
	public UserAccount(String email, String username, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
		userId = Double.toHexString(Math.random() * 10000.0);
		favorites = new FavoriteBooks(userId);
	}
	
	public void addFavorite(Object obj) {
		if (obj instanceof finalproject.Book) {
			favorites.addBook((Book) obj);
		}
		// else do nothing
	}
	
	public void removeFavorite(Object obj) {
		if (obj instanceof finalproject.Book) {
			favorites.removeBook((Book) obj);
		}
		// else do nothing
	}
	
	public List<Book> getFavorites() {
		return favorites.getFavoritesList();
	}
	
}
