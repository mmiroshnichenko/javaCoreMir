package lesson15.library.entity;

import java.util.Date;

public class Issue {
    private long id;
    private Visitor visitor;
    private Book book;
    private Date issueDate;
    private Date returnDate;

    public Issue(long id, Visitor visitor, Book book, Date issueDate) {
        this.id = id;
        this.visitor = visitor;
        this.book = book;
        this.issueDate = issueDate;
    }

    public Issue(Visitor visitor, Book book, Date issueDate) {
        this.visitor = visitor;
        this.book = book;
        this.issueDate = issueDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Visitor getVisitor() {
        return visitor;
    }

    public Book getBook() {
        return book;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "Issue{" +
                "id=" + id +
                ", visitor=" + visitor +
                ", book=" + book +
                ", issueDate=" + issueDate +
                ", returnDate=" + returnDate +
                '}';
    }
}
