package lesson15.library.entity;

import java.util.Date;

public class Book {
    private long id;
    private String callNo;
    private String name;
    private String author;
    private String publisher;
    private int quantity;
    private int issued = 0;
    private Date addedDate;

    public Book(long id, String callNo, String name, String author, String publisher, int quantity, int issued, Date addedDate) {
        this.id = id;
        this.callNo = callNo;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.quantity = quantity;
        this.issued = issued;
        this.addedDate = addedDate;
    }

    public Book(String callNo, String name, String author, String publisher, int quantity, Date addedDate) {
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

        Book book = (Book) o;

        if (id != book.id) return false;
        if (quantity != book.quantity) return false;
        if (issued != book.issued) return false;
        if (!callNo.equals(book.callNo)) return false;
        if (!name.equals(book.name)) return false;
        if (!author.equals(book.author)) return false;
        if (!publisher.equals(book.publisher)) return false;
        return addedDate.equals(book.addedDate);
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
        return "Book{" +
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
