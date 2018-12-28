package lesson15.library.controller;

import lesson15.library.entity.BookStorage;
import lesson15.library.entity.User;
import lesson15.library.repository.BookStorageRepository;
import lesson15.library.repository.SessionRepository;

public class BookStorageController {
    private User user;
    private BookStorageRepository bookStorageRepository;
    private SessionRepository sessionRepository;

    public BookStorageController(User user, BookStorageRepository bookStorageRepository, SessionRepository sessionRepository) {
        this.user = user;
        this.bookStorageRepository = bookStorageRepository;
        this.sessionRepository = sessionRepository;
    }

    public BookStorage addBooksToStorage(BookStorage bookStorage) {
        if (!user.isLibrarian() || !sessionRepository.userAuthorized(user)) {
            return null;
        }

        return bookStorageRepository.addBookStorage(bookStorage);
    }

    public BookStorage[] viewBooks() {
        if (!user.isLibrarian() || !sessionRepository.userAuthorized(user)) {
            return null;
        }

        return bookStorageRepository.getAllBooks();
    }
}
