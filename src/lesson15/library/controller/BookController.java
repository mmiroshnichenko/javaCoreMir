package lesson15.library.controller;

import lesson15.library.entity.Book;
import lesson15.library.entity.User;
import lesson15.library.repository.BookRepository;

import java.util.Date;

public class BookController {
    private User userLibrarian;
    private BookRepository bookRepository;

    public BookController(User userLibrarian, BookRepository bookRepository) {
        this.userLibrarian = userLibrarian;
        this.bookRepository = bookRepository;
    }

    public void addBooks(String callNo, String name, String author, String publisher, int quantity) {
        if (userLibrarian.isAdmin() || !userLibrarian.isAuthorized()) {
            System.err.println("Access denied!");

            return;
        }

        Book existBook = bookRepository.getBookByCallNo(callNo);
        if (existBook != null) {
            quantity += existBook.getQuantity();
            existBook.setQuantity(quantity);

            System.out.println("Books added successfully!");
            return;
        }

        Book newBook = bookRepository.addBook(new Book(callNo, name, author, publisher, quantity, new Date()));
        if (newBook != null) {
            System.out.println("Books added successfully!");
        } else {
            System.err.println("Wrong adding books!");
        }
    }

    public Book[] viewBooks() {
        if (userLibrarian.isAdmin() || !userLibrarian.isAuthorized()) {
            System.err.println("Access denied!");

            return null;
        }

        return bookRepository.getAllBooks();
    }
}
