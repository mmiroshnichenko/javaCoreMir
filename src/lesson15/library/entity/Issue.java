package lesson15.library.entity;

import java.util.Date;

public class Issue {
    private long id;
    private User user;
    private Book book;
    private Date issueDate;
    private Date returnDate;

    public Issue(long id, User user, Book book, Date issueDate) {
        this.id = id;
        this.user = user;
        this.book = book;
        this.issueDate = issueDate;
    }

    public Issue(User user, Book book, Date issueDate) {
        this.user = user;
        this.book = book;
        this.issueDate = issueDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
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
                ", user=" + user +
                ", book=" + book +
                ", issueDate=" + issueDate +
                ", returnDate=" + returnDate +
                '}';
    }
}
