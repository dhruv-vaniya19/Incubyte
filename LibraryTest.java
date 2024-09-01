import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {

    @Test
    public void testAddBook() {
        Library library = new Library();
        Book book = new Book("1234567890", "The Great Gatsby", "F. Scott Fitzgerald", 1925);

        library.addBook(book);
        assertEquals(book, library.getBook("1234567890"), "The book should be added to the library.");
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
}
