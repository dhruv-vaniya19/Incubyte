import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {

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
}
