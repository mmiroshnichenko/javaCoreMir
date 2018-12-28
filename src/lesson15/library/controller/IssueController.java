package lesson15.library.controller;

import lesson15.library.entity.BookStorage;
import lesson15.library.entity.Issue;
import lesson15.library.entity.User;
import lesson15.library.repository.BookStorageRepository;
import lesson15.library.repository.IssueRepository;
import lesson15.library.repository.SessionRepository;
import lesson15.library.repository.UserRepository;

import java.util.Calendar;
import java.util.Date;

public class IssueController {
    private User user;
    private IssueRepository issueRepository;
    private BookStorageRepository bookStorageRepository;
    private UserRepository userRepository;
    private SessionRepository sessionRepository;

    public IssueController(User user, IssueRepository issueRepository,
                           BookStorageRepository bookStorageRepository,
                           UserRepository userRepository,
                           SessionRepository sessionRepository) {
        this.user = user;
        this.issueRepository = issueRepository;
        this.bookStorageRepository = bookStorageRepository;
        this.userRepository = userRepository;
        this.sessionRepository = sessionRepository;
    }

    public Issue addIssue(String bookCallNo, long visitorId, String visitorName, String visitorContact) {
        if (!user.isLibrarian() || !sessionRepository.userAuthorized(user)) {
            return null;
        }

        BookStorage bookStorage = bookStorageRepository.getBookByCallNo(bookCallNo);
        User visitor = userRepository.getUserById(visitorId);
        if (bookStorage == null || bookStorage.getQuantity() == 0
                || visitor == null || !visitor.isVisitor()
                || !checkExpiredIssueDatesForVisitor(visitor)) {
            return null;
        }


        Issue newIssue = issueRepository.addIssue(new Issue(visitor, bookStorage, new Date()));
        if (newIssue != null) {
            int newQuantity = bookStorage.getQuantity() - 1;
            int newIssued = bookStorage.getIssued() + 1;
            bookStorage.setQuantity(newQuantity);
            bookStorage.setIssued(newIssued);
            bookStorageRepository.update(bookStorage);

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
        if (!user.isLibrarian() || !sessionRepository.userAuthorized(user)) {
            return null;
        }

        return issueRepository.getAllActiveIssues();
    }

    public boolean returnBook(String bookCallNo, long visitorId) {
        if (!user.isLibrarian() || !sessionRepository.userAuthorized(user)) {
            return false;
        }

        BookStorage bookStorage = bookStorageRepository.getBookByCallNo(bookCallNo);
        User visitor = userRepository.getUserById(visitorId);
        if (bookStorage == null || visitor == null || !visitor.isVisitor()) {
            return false;
        }

        Issue issue = issueRepository.getIssueByBookAndVisitor(bookStorage, visitor);
        if (issue != null) {
            issue.setReturnDate(new Date());
            int newQuantity = bookStorage.getQuantity() + 1;
            int newIssued = bookStorage.getIssued() - 1;
            bookStorage.setQuantity(newQuantity);
            bookStorage.setIssued(newIssued);
            bookStorageRepository.update(bookStorage);

            return true;
        }

        return false;
    }
}
