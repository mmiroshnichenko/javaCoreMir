package lesson15.library.controller;

import lesson15.library.entity.Book;
import lesson15.library.entity.Issue;
import lesson15.library.entity.User;
import lesson15.library.entity.Visitor;
import lesson15.library.repository.BookRepository;
import lesson15.library.repository.IssueRepository;
import lesson15.library.repository.VisitorRepository;

import java.util.Calendar;
import java.util.Date;

public class IssueController {
    private User userLibrarian;
    private IssueRepository issueRepository;
    private BookRepository bookRepository;
    private VisitorRepository visitorRepository;

    public IssueController(User userLibrarian, IssueRepository issueRepository, BookRepository bookRepository, VisitorRepository visitorRepository) {
        this.userLibrarian = userLibrarian;
        this.issueRepository = issueRepository;
        this.bookRepository = bookRepository;
        this.visitorRepository = visitorRepository;
    }

    public void addIssue(String bookCallNo, long visitorId, String visitorName, String visitorContact) {
        if (userLibrarian.isAdmin() || !userLibrarian.isAuthorized()) {
            System.err.println("Access denied!");

            return;
        }

        Book book = bookRepository.getBookByCallNo(bookCallNo);
        if (book == null) {
            System.err.println("Incorrect book callno!");

            return;
        }

        Visitor visitor = visitorRepository.getVisitorById(visitorId);
        if (visitor == null) {
            System.err.println("Please check visitor ID carefully before issuing book!");

            return;
        }

        Issue existIssue = issueRepository.getIssueByBookAndVisitor(book, visitor);
        if (existIssue != null) {
            System.err.println("Issue book for this visitor already exist!");

            return;
        }

        if (book.getQuantity() == 0){
            System.err.println("Please check quantity of book!");

            return;
        }

        Date minIssueDate = issueRepository.getMinIssueDateForVisitor(visitor);
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.MONTH, -1);
        Date compareDate = cal.getTime();
        if (minIssueDate != null && minIssueDate.compareTo(compareDate) <= 0) {
            System.err.println("Visitor has not returned issued book from " + minIssueDate.toString());

            return;
        }


        Issue newIssue = issueRepository.addIssue(new Issue(visitor, book, new Date()));
        if (newIssue != null) {
            int newQuantity = book.getQuantity() - 1;
            int newIssued = book.getIssued() + 1;
            book.setQuantity(newQuantity);
            book.setIssued(newIssued);
            System.out.println("Book issued successfully!");
        } else {
            System.err.println("Wrong adding issue book!");
        }
    }

    public Issue[] viewIssues() {
        if (userLibrarian.isAdmin() || !userLibrarian.isAuthorized()) {
            System.err.println("Access denied!");

            return null;
        }

        return issueRepository.getAllActiveIssues();
    }

    public void returnBook(String bookCallNo, long visitorId) {
        if (userLibrarian.isAdmin() || !userLibrarian.isAuthorized()) {
            System.err.println("Access denied!");

            return;
        }

        Book book = bookRepository.getBookByCallNo(bookCallNo);
        if (book == null) {
            System.err.println("Incorrect book callno!");

            return;
        }

        Visitor visitor = visitorRepository.getVisitorById(visitorId);
        if (visitor == null) {
            System.err.println("Please check visitor ID carefully before issuing book!");

            return;
        }

        Issue issue = issueRepository.getIssueByBookAndVisitor(book, visitor);
        if (issue != null) {
            issue.setReturnDate(new Date());
            int newQuantity = book.getQuantity() + 1;
            int newIssued = book.getIssued() - 1;
            book.setQuantity(newQuantity);
            book.setIssued(newIssued);
            System.out.println("Book returned successfully!");
        } else {
            System.err.println("Wrong returning issue book!");
        }
    }
}
