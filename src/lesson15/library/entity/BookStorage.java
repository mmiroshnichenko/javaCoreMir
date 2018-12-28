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

        BookStorage that = (BookStorage) o;

        if (!name.equals(that.name)) return false;
        if (!author.equals(that.author)) return false;
        return publisher.equals(that.publisher);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + author.hashCode();
        result = 31 * result + publisher.hashCode();
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
