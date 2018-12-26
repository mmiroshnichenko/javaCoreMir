package lesson15.library.controller;

import lesson15.library.entity.Book;
import lesson15.library.entity.User;
import lesson15.library.repository.BookRepository;

import java.util.Date;

public class BookController {
    private User user;
    private BookRepository bookRepository;

    public BookController(User user, BookRepository bookRepository) {
        this.user = user;
        this.bookRepository = bookRepository;
    }

    public Book addBooks(String callNo, String name, String author, String publisher, int quantity) {
        if (!user.isLibrarian() || !user.isAuthorized()) {
            System.err.println("Access denied!");

            return null;
        }

        Book existBook = bookRepository.getBookByCallNo(callNo);
        if (existBook != null) {
            quantity += existBook.getQuantity();
            existBook.setQuantity(quantity);

            return bookRepository.update(existBook);
        }

        return bookRepository.addBook(new Book(callNo, name, author, publisher, quantity, new Date()));
    }

    public Book[] viewBooks() {
        if (!user.isLibrarian() || !user.isAuthorized()) {
            System.err.println("Access denied!");

            return null;
        }

        return bookRepository.getAllBooks();
    }
}
