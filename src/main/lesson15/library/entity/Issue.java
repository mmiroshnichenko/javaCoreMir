package main.lesson15.library.entity;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Issue issue = (Issue) o;

        if (id != issue.id) return false;
        if (!user.equals(issue.user)) return false;
        if (!bookStorage.equals(issue.bookStorage)) return false;
        if (!issueDate.equals(issue.issueDate)) return false;
        return returnDate.equals(issue.returnDate);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + user.hashCode();
        result = 31 * result + bookStorage.hashCode();
        result = 31 * result + issueDate.hashCode();
        result = 31 * result + returnDate.hashCode();
        return result;
    }
}
