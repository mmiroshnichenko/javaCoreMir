package lesson15.library.controller;

import lesson15.library.entity.Book;
import lesson15.library.entity.Issue;
import lesson15.library.entity.User;
import lesson15.library.repository.BookRepository;
import lesson15.library.repository.IssueRepository;
import lesson15.library.repository.UserRepository;

import java.util.Calendar;
import java.util.Date;

public class IssueController {
    private User user;
    private IssueRepository issueRepository;
    private BookRepository bookRepository;
    private UserRepository userRepository;

    public IssueController(User user, IssueRepository issueRepository, BookRepository bookRepository, UserRepository userRepository) {
        this.user = user;
        this.issueRepository = issueRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    public Issue addIssue(String bookCallNo, long visitorId, String visitorName, String visitorContact) {
        if (!user.isLibrarian() || !user.isAuthorized()) {
            System.err.println("Access denied!");

            return null;
        }

        Book book = bookRepository.getBookByCallNo(bookCallNo);
        if (book == null) {
            return null;
        }

        User visitor = userRepository.getUserById(visitorId);
        if (visitor == null || !visitor.isVisitor()) {
            return null;
        }

        if (book.getQuantity() == 0){
            return null;
        }

        if (!checkExpiredIssueDatesForVisitor(visitor)) {
            return null;
        }

        Issue newIssue = issueRepository.addIssue(new Issue(visitor, book, new Date()));
        if (newIssue != null) {
            int newQuantity = book.getQuantity() - 1;
            int newIssued = book.getIssued() + 1;
            book.setQuantity(newQuantity);
            book.setIssued(newIssued);
            bookRepository.update(book);

            return newIssue;
        }

        return null;
    }

    private boolean checkExpiredIssueDatesForVisitor(User visitor) {
        Date minIssueDate = issueRepository.getMinIssueDateForVisitor(visitor);
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.MONTH, -1);
        Date compareDate = cal.getTime();
        if (minIssueDate != null && minIssueDate.compareTo(compareDate) <= 0) {
            return false;
        }

        return true;
    }

    public Issue[] viewIssues() {
        if (!user.isLibrarian() || !user.isAuthorized()) {
            System.err.println("Access denied!");

            return null;
        }

        return issueRepository.getAllActiveIssues();
    }

    public boolean returnBook(String bookCallNo, long visitorId) {
        if (!user.isLibrarian() || !user.isAuthorized()) {
            System.err.println("Access denied!");

            return false;
        }

        Book book = bookRepository.getBookByCallNo(bookCallNo);
        if (book == null) {
            return false;
        }

        User visitor = userRepository.getUserById(visitorId);
        if (visitor == null || !visitor.isVisitor()) {
            return false;
        }

        Issue issue = issueRepository.getIssueByBookAndVisitor(book, visitor);
        if (issue != null) {
            issue.setReturnDate(new Date());
            int newQuantity = book.getQuantity() + 1;
            int newIssued = book.getIssued() - 1;
            book.setQuantity(newQuantity);
            book.setIssued(newIssued);
            bookRepository.update(book);

            return true;
        }

        return false;
    }
}
