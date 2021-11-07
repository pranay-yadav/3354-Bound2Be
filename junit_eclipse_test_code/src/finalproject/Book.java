package finalproject;

import java.util.ArrayList;
import java.util.List;

public class Book {
	private String title;
	private List<String> authors;
	private String publishDate;
	private List<String> hyperlinks;
	private double price;
	private String publisher;
	private String isbn;
	
	public Book() {
		title = "n/a";
		authors = new ArrayList<String>();
		authors.add("n/a");
		publishDate = "n/a";
		hyperlinks = new ArrayList<String>();
		hyperlinks.add("n/a");
		price = -1.0;
		publisher = "n/a";
		isbn = "n/a";
	}
	
	public Book(String title, List<String> authors, String publishDate, List<String> hyperlinks, double price, String publisher, String isbn) {
		this.title = title;
		this.authors = authors;
		this.publishDate = publishDate;
		this.hyperlinks = hyperlinks;
		this.price = price;
		this.publisher = publisher;
		this.isbn = isbn;
	}
	
	public String getTitle() {
		return title;
	}
	public List<String> getAuthors() {
		return authors;
	}
	public String getPublishDate() {
		return publishDate;
	}
	public List<String> getHyperlinks() {
		return hyperlinks;
	}
	public double getPrice() {
		return price;
	}
	public String getPublisher() {
		return publisher;
	}
	public String getIsbn() {
		return isbn;
	}
	
	// Overriding equals() method to compare Book objects properly
	@Override
	public boolean equals(Object obj) {
		Book book = (Book) obj;
		if (this.publishDate.equals(book.getPublishDate()) == false)
			return false;
		if (this.title.equals(book.getTitle()) == false)
			return false;
		if (this.price != book.getPrice())
			return false;
		if (this.publisher.equals(book.getPublisher()) == false)
			return false;
		if (this.isbn.equals(book.getIsbn()) == false)
			return false;
		for (String author: this.authors)
			if (book.getAuthors().contains(author) == false)
				return false;
		for (String hyperlink: this.hyperlinks)
			if (book.getHyperlinks().contains(hyperlink) == false)
				return false;
		return true;
	}
	
	// Overriding toString() method to print Book objects properly
	@Override
	public String toString() {
		return isbn;
	}
	
}
