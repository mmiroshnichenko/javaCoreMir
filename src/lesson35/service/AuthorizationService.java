package lesson35.service;

import lesson35.exceptions.AuthException;
import lesson35.model.Session;

public class AuthorizationService {
    public static void checkAdminPermissions() throws Exception {
        checkUserAuthorization();

        if (!Session.getUser().isAdmin()) {
            throw new AuthException("Error: user is not admin");
        }
    }

    public static void checkUserAuthorization() throws Exception {
        if (Session.getUser() == null) {
            throw new AuthException("Error: user is not authorized");
        }
    }
}