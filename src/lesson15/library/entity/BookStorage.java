package lesson15.library.entity;

import java.util.Date;

public class BookStorage {
    private long id;
    private String callNo;
    private String name;
    private String author;
    private String publisher;
    private int quantity;
    private int issued = 0;
    private Date addedDate;

    public BookStorage(long id, String callNo, String name, String author, String publisher, int quantity, int issued, Date addedDate) {
        this.id = id;
        this.callNo = callNo;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.quantity = quantity;
        this.issued = issued;
        this.addedDate = addedDate;
    }

    public BookStorage(String callNo, String name, String author, String publisher, int quantity, Date addedDate) {
        this.callNo = callNo;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.quantity = quantity;
        this.addedDate = addedDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCallNo() {
        return callNo;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getIssued() {
        return issued;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setIssued(int issued) {
        this.issued = issued;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookStorage bookStorage = (BookStorage) o;

        if (id != bookStorage.id) return false;
        if (quantity != bookStorage.quantity) return false;
        if (issued != bookStorage.issued) return false;
        if (!callNo.equals(bookStorage.callNo)) return false;
        if (!name.equals(bookStorage.name)) return false;
        if (!author.equals(bookStorage.author)) return false;
        if (!publisher.equals(bookStorage.publisher)) return false;
        return addedDate.equals(bookStorage.addedDate);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + callNo.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + author.hashCode();
        result = 31 * result + publisher.hashCode();
        result = 31 * result + quantity;
        result = 31 * result + issued;
        result = 31 * result + addedDate.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "BookStorage{" +
                "id=" + id +
                ", callNo='" + callNo + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", quantity=" + quantity +
                ", issued=" + issued +
                ", addedDate=" + addedDate +
                '}';
    }
}
