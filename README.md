# Library Management System

 A simple Java-based library management system allows users to add, borrow, return, and view available books.


# Features
------------
# Features :
Add Books: Add new books with unique identifiers (ISBN), title, author, and publication year.
Borrow Books: Borrow books from the library, with availability checks.
Return Books: Return borrowed books, updating their availability status.
View Available Books: List all currently available books in the library.




# Test-Driven Development (TDD) :
This project follows the TDD approach, where unit tests are written first, and the implementation follows. The LibraryTest.java file in the Test directory contains all the tests that guide the development of the Library system.


# Prerequisites :

JDK 8 or higher
JUnit 5 for testing


# Installation
Clone the repository:
git clone https://github.com/dhruv-vaniya19/library-management.git
cd library-management



# Compile the code:
javac -d bin Test/*.java


# Run the application:
java -cp bin LibraryApp


# Usage :


Library library = new Library();

// Adding a book
library.addBook(new Book("1234567890", "The Great Gatsby", "F. Scott Fitzgerald", 1925));

// Borrowing a book
library.borrowBook("1234567890");

// Returning a book
library.returnBook("1234567890");

// Viewing available books
List<Book> availableBooks = library.viewAvailableBooks();





# Running Tests
Unit tests are provided in the LibraryTest.java file using JUnit. To run the tests:

-->Compile the test code:
javac -cp .:lib/junit-platform-console-standalone-1.7.1.jar -d bin Test/LibraryTest.java
