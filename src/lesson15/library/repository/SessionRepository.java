package lesson15.library.repository;

import lesson15.library.entity.Session;
import lesson15.library.entity.User;

public class SessionRepository {
    private Session session;

    public void saveSession(Session session) {
        this.session = session;
    }

    public Session getSession() {
        return this.session;
    }

    public void clearSessionForUser(User user) {
        if (userAuthorized(user)) {
            session = null;
        }
    }

    public boolean userAuthorized(User user) {
        if (session != null && session.getUser().equals(user)) {
            return true;
        }

        return false;
    }
}
