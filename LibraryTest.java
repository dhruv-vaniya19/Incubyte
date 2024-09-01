import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {

    @Test
    public void testAddBook() {
        Library library = new Library();
        Book book = new Book("1234567890", "The Great Gatsby", "F. Scott Fitzgerald", 1925);

        library.addBook(book);
        assertEquals(book, library.getBook("1234567890"), "The book should be added to the library.");
        assertTrue(library.isBookAvailable("1234567890"), "The book should be available after being added.");
    }

    @Test
    public void testAddDuplicateBook() {
        Library library = new Library();
        Book book1 = new Book("1234567890", "The Great Gatsby", "F. Scott Fitzgerald", 1925);
        Book book2 = new Book("1234567890", "To Kill a Mockingbird", "Harper Lee", 1960);

        library.addBook(book1);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            library.addBook(book2);
        });

        String expectedMessage = "Invalid book or book with this ISBN already exists.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage), "Should throw an exception for duplicate ISBN.");
    }

    @Test
    public void testAddNullBook() {
        Library library = new Library();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            library.addBook(null);
        });

        String expectedMessage = "Invalid book or book with this ISBN already exists.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage), "Should throw an exception for null book.");
    }

    @Test
    public void testBorrowBook() {
        Library library = new Library();
        Book book = new Book("1234567890", "The Great Gatsby", "F. Scott Fitzgerald", 1925);

        library.addBook(book);
        assertTrue(library.isBookAvailable("1234567890"), "Book should be available before borrowing.");

        library.borrowBook("1234567890");
        assertFalse(library.isBookAvailable("1234567890"), "Book should not be available after borrowing.");
    }

    @Test
    public void testBorrowUnavailableBook() {
        Library library = new Library();
        Book book = new Book("1234567890", "The Great Gatsby", "F. Scott Fitzgerald", 1925);

        library.addBook(book);
        library.borrowBook("1234567890");

        Exception exception = assertThrows(IllegalStateException.class, () -> {
            library.borrowBook("1234567890");
        });

        String expectedMessage = "Book is not available for borrowing.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage), "Should throw an exception when borrowing an unavailable book.");
    }

    @Test
    public void testBorrowNonExistentBook() {
        Library library = new Library();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            library.borrowBook("9876543210");
        });

        String expectedMessage = "Book with this ISBN does not exist.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage), "Should throw an exception when borrowing a non-existent book.");
    }

    @Test
    public void testReturnBook() {
        Library library = new Library();
        Book book = new Book("1234567890", "The Great Gatsby", "F. Scott Fitzgerald", 1925);

        library.addBook(book);
        library.borrowBook("1234567890");
        assertFalse(library.isBookAvailable("1234567890"), "Book should not be available after borrowing.");

        library.returnBook("1234567890");
        assertTrue(library.isBookAvailable("1234567890"), "Book should be available after returning.");
    }

    @Test
    public void testReturnNonExistentBook() {
        Library library = new Library();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            library.returnBook("9876543210");
        });

        String expectedMessage = "Book with this ISBN does not exist.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage), "Should throw an exception when returning a non-existent book.");
    }

    @Test
    public void testReturnAlreadyReturnedBook() {
        Library library = new Library();
        Book book = new Book("1234567890", "The Great Gatsby", "F. Scott Fitzgerald", 1925);

        library.addBook(book);
        library.borrowBook("1234567890");
        library.returnBook("1234567890");

        Exception exception = assertThrows(IllegalStateException.class, () -> {
            library.returnBook("1234567890");
        });

        String expectedMessage = "Book is already returned.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage), "Should throw an exception when returning an already returned book.");
    }
}
