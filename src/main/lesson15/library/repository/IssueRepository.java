package main.lesson15.library.repository;

import main.lesson15.library.entity.BookStorage;
import main.lesson15.library.entity.Issue;
import main.lesson15.library.entity.User;

import java.util.Date;

public class IssueRepository {
    private Issue[] issues;

    public IssueRepository(Issue[] issues) {
        this.issues = issues;
    }

    public Issue[] getIssues() {
        return issues;
    }

    public Date getMinIssueDateForVisitor(User visitor) {
        Issue[] visitorIssues = getActiveIssuesForVisitor(visitor);
        if (visitorIssues.length == 0) {
            return null;
        }

        Date minDate = visitorIssues[0].getIssueDate();
        for (Issue issue : visitorIssues) {
            if (issue.getIssueDate().compareTo(minDate) < 0) {
                minDate = issue.getIssueDate();
            }
        }

        return minDate;
    }

    public Issue addIssue(Issue issue) {
        if (getIssueByBookAndVisitor(issue.getBookStorage(), issue.getUser()) != null) {
            return null;
        }

        issue.setId(getNextIssueId());

        for (int i = 0; i < issues.length; i++) {
            if (issues[i] == null) {
                issues[i] = issue;

                return issue;
            }
        }

        return null;
    }

    public Issue[] getAllActiveIssues() {
        int length = 0;
        for (Issue issue : issues) {
            if (issue != null && issue.getReturnDate() == null) {
                length++;
            }
        }

        Issue[] activeIssues = new Issue[length];
        int index = 0;
        for (Issue issue : issues) {
            if (issue != null && issue.getReturnDate() == null) {
                activeIssues[index] = issue;
                index++;
            }
        }

        return activeIssues;
    }

    public Issue getIssueByBookAndVisitor(BookStorage bookStorage, User user) {
        for (Issue issue : issues) {
            if (issue != null && issue.getReturnDate() == null
                    && user.equals(issue.getUser()) && bookStorage.equals(issue.getBookStorage())) {
                return issue;
            }
        }

        return null;
    }

    public boolean delete(Issue issue) {
        for (int i = 0; i < issues.length; i++) {
            if (issues[i] != null && issues[i].equals(issue)) {
                issues[i] = null;

                return true;
            }
        }

        return false;
    }

    private Issue[] getActiveIssuesForVisitor(User user) {
        int length = 0;
        for (Issue issue : issues) {
            if (issue != null && issue.getReturnDate() == null && user.equals(issue.getUser())) {
                length++;
            }
        }

        Issue[] visitorIssues = new Issue[length];
        int index = 0;
        for (Issue issue : issues) {
            if (issue != null && issue.getReturnDate() == null && user.equals(issue.getUser())) {
                visitorIssues[index] = issue;
                index++;
            }
        }

        return visitorIssues;
    }

    private long getNextIssueId() {
        long maxId = issues[0] != null ? issues[0].getId() : 0;
        for (Issue issue : issues) {
            if (issue != null && issue.getId() > maxId) {
                maxId = issue.getId();
            }
        }
        maxId++;

        return maxId;
    }
}
