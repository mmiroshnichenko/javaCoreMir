package lesson15.library.repository;

import lesson15.library.entity.Book;

public class BookRepository {
    private Book[] books;

    public BookRepository(Book[] books) {
        this.books = books;
    }

    public Book[] getBooks() {
        return books;
    }

    public Book getBookByCallNo(String callNo) {
        for (Book book : books) {
            if (book != null && callNo.equals(book.getCallNo())) {
                return book;
            }
        }

        return null;
    }

    public Book addBook(Book book) {
        book.setId(getNextBookId());

        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                books[i] = book;

                return book;
            }
        }

        return null;
    }

    public Book[] getAllBooks() {
        int length = 0;
        for (Book book : books) {
            if (book != null) {
                length++;
            }
        }

        Book[] allBooks = new Book[length];
        int index = 0;
        for (Book book : books) {
            if (book != null) {
                allBooks[index] = book;
                index++;
            }
        }

        return allBooks;
    }

    private long getNextBookId() {
        long maxId = books[0] != null ? books[0].getId() : 0;
        for (Book book : books) {
            if (book != null && book.getId() > maxId) {
                maxId = book.getId();
            }
        }
        maxId++;

        return maxId;
    }
}
