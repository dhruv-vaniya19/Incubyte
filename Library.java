import java.util.HashMap;
import java.util.Map;

public class Library {
    private Map<String, Book> books;
    private Map<String, Boolean> availability;

    public Library() {
        books = new HashMap<>();
        availability = new HashMap<>();
    }

    public void addBook(Book book) {
        if (book == null || books.containsKey(book.getIsbn())) {
            throw new IllegalArgumentException("Invalid book or book with this ISBN already exists.");
        }
        books.put(book.getIsbn(), book);
        availability.put(book.getIsbn(), true); // Book is available when first added
    }

    public void borrowBook(String isbn) {
        if (!books.containsKey(isbn)) {
            throw new IllegalArgumentException("Book with this ISBN does not exist.");
        }

        if (!availability.get(isbn)) {
            throw new IllegalStateException("Book is not available for borrowing.");
        }

        availability.put(isbn, false); // Mark the book as borrowed
    }

    public Book getBook(String isbn) {
        return books.get(isbn);
    }

    public boolean isBookAvailable(String isbn) {
        return availability.getOrDefault(isbn, false);
    }
}
