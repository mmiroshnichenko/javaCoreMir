package lesson15.library.entity;

import java.util.Date;

public class Issue {
    private long id;
    private User user;
    private BookStorage bookStorage;
    private Date issueDate;
    private Date returnDate;

    public Issue(long id, User user, BookStorage bookStorage, Date issueDate) {
        this.id = id;
        this.user = user;
        this.bookStorage = bookStorage;
        this.issueDate = issueDate;
    }

    public Issue(User user, BookStorage bookStorage, Date issueDate) {
        this.user = user;
        this.bookStorage = bookStorage;
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

    public BookStorage getBookStorage() {
        return bookStorage;
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
                ", bookStorage=" + bookStorage +
                ", issueDate=" + issueDate +
                ", returnDate=" + returnDate +
                '}';
    }
}
