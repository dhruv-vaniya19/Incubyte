# Library Management System

 A simple Java-based library management system allows users to add, borrow, return, and view available books.


# Features
------------

# Add Books :
-------------
Users can add new books to the library.
Each book has a unique identifier (ISBN), title, author, and publication year.
The system prevents duplicate books from being added based on ISBN.

# Borrow Books :
---------------
Users can borrow a book from the library if it is available.
The system checks the book's availability before allowing it to be borrowed.
If the book is not available, an appropriate error is raised.

# Return Books :
---------------
Users can return a borrowed book to the library.
The system updates the availability of the book upon return.
The system prevents returning a book that wasn't borrowed or has already been returned.

# View Available Books
-----------------------
Users can view a list of all books that are currently available in the library.
Only books that are not borrowed are listed as available.
