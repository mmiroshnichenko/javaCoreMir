package lesson15.library.repository;

import lesson15.library.entity.BookStorage;

public class BookStorageRepository {
    private BookStorage[] bookStorages;

    public BookStorageRepository(BookStorage[] bookStorages) {
        this.bookStorages = bookStorages;
    }

    public BookStorage[] getBookStorages() {
        return bookStorages;
    }

    public BookStorage getBookByCallNo(String callNo) {
        for (BookStorage bookStorage : bookStorages) {
            if (bookStorage != null && callNo.equals(bookStorage.getCallNo())) {
                return bookStorage;
            }
        }

        return null;
    }

    public BookStorage addBookStorage(BookStorage bookStorage) {
        BookStorage existBookStorage = getEqualBookStorage(bookStorage);
        if (existBookStorage != null) {
            int quantity = existBookStorage.getQuantity() + bookStorage.getQuantity();
            existBookStorage.setQuantity(quantity);

            return existBookStorage;
        } else {
            bookStorage.setId(getNextBookId());

            for (int i = 0; i < bookStorages.length; i++) {
                if (bookStorages[i] == null) {
                    bookStorages[i] = bookStorage;

                    return bookStorage;
                }
            }
        }

        return null;
    }

    public BookStorage[] getAllBooks() {
        int length = 0;
        for (BookStorage bookStorage : bookStorages) {
            if (bookStorage != null) {
                length++;
            }
        }

        BookStorage[] allBookStorages = new BookStorage[length];
        int index = 0;
        for (BookStorage bookStorage : bookStorages) {
            if (bookStorage != null) {
                allBookStorages[index] = bookStorage;
                index++;
            }
        }

        return allBookStorages;
    }

    public BookStorage update(BookStorage bookStorage) {
        for (int i = 0; i < bookStorages.length; i++) {
            if (bookStorages[i] != null
                    && bookStorages[i].getId() == bookStorage.getId() && bookStorages[i].getCallNo() == bookStorage.getCallNo()) {
                bookStorages[i] = bookStorage;

                return bookStorage;
            }
        }

        return null;
    }

    private BookStorage getEqualBookStorage(BookStorage bookStorage) {
        for (BookStorage elBookStorage : bookStorages) {
            if (elBookStorage != null && elBookStorage.equals(bookStorage) && elBookStorage.hashCode() == bookStorage.hashCode()) {
                return elBookStorage;
            }
        }

        return null;
    }

    private long getNextBookId() {
        long maxId = bookStorages[0] != null ? bookStorages[0].getId() : 0;
        for (BookStorage bookStorage : bookStorages) {
            if (bookStorage != null && bookStorage.getId() > maxId) {
                maxId = bookStorage.getId();
            }
        }
        maxId++;

        return maxId;
    }
}
