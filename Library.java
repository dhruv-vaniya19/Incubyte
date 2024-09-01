import java.util.HashMap;
import java.util.Map;

public class Library {
    private Map<String, Book> books;

    public Library() {
        books = new HashMap<>();
    }

    public void addBook(Book book) {
        if (book == null || books.containsKey(book.getIsbn())) {
            throw new IllegalArgumentException("Invalid book or book with this ISBN already exists.");
        }
        books.put(book.getIsbn(), book);
    }

    public Book getBook(String isbn) {
        return books.get(isbn);
    }
}
