package lesson15.library.controller;

import lesson15.library.entity.BookStorage;
import lesson15.library.entity.User;
import lesson15.library.repository.BookStorageRepository;
import lesson15.library.repository.SessionRepository;

import java.util.Date;

public class BookStorageController {
    private User user;
    private BookStorageRepository bookStorageRepository;
    private SessionRepository sessionRepository;

    public BookStorageController(User user, BookStorageRepository bookStorageRepository, SessionRepository sessionRepository) {
        this.user = user;
        this.bookStorageRepository = bookStorageRepository;
        this.sessionRepository = sessionRepository;
    }

    public BookStorage addBooksToStorage(String callNo, String name, String author, String publisher, int quantity) {
        if (!user.isLibrarian() || !sessionRepository.userAuthorized(user)) {
            return null;
        }

        BookStorage existBookStorage = bookStorageRepository.getBookByCallNo(callNo);
        if (existBookStorage != null) {
            quantity += existBookStorage.getQuantity();
            existBookStorage.setQuantity(quantity);

            return bookStorageRepository.update(existBookStorage);
        }

        return bookStorageRepository.addBook(new BookStorage(callNo, name, author, publisher, quantity, new Date()));
    }

    public BookStorage[] viewBooks() {
        if (!user.isLibrarian() || !sessionRepository.userAuthorized(user)) {
            return null;
        }

        return bookStorageRepository.getAllBooks();
    }
}
