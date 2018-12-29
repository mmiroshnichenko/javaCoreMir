package lesson15.library;

import lesson15.library.controller.AuthController;
import lesson15.library.controller.BookStorageController;
import lesson15.library.controller.IssueController;
import lesson15.library.controller.UserController;
import lesson15.library.entity.*;
import lesson15.library.repository.BookStorageRepository;
import lesson15.library.repository.IssueRepository;
import lesson15.library.repository.SessionRepository;
import lesson15.library.repository.UserRepository;

import java.util.Arrays;
import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        User admin = new User(101, "Admin", "admin123", "admin@gmail.com", "test address", "Kiev", "546546546", UserRole.ADMIN);
        User librarian = new User(102, "Pavel", "fhgh123", "pavel.librarian@gmail.com", "test2 address", "Kharkov", "454654654", UserRole.LIBRARIAN);
        User visitor1 = new User(301, "Ivan", "jkhfkj", "ttt@ggg.vom", "test3 address", "Lvov",  "6732546327", UserRole.VISITOR);
        User visitor2 = new User(301, "Inga", "jkhttkj", "tjt@ggg.vom", "test4 address", "Lvov",  "67666327", UserRole.VISITOR);
        User[] users = {admin, librarian, visitor1, visitor2, null, null, null};
        UserRepository userRepository = new UserRepository(users);
        SessionRepository sessionRepository = new SessionRepository();
        //тестируем авторизацию пользователей
        AuthController authController = new AuthController(userRepository, sessionRepository);
        User admin1 = authController.loginUser("Admin", "admin123");

        System.out.println(admin1);
        authController.logout(admin1);
        System.out.println(admin1);

        //неверный пароль админа
        User admin2 = authController.loginUser("Admin", "admi3123");
        System.out.println(admin2);

        User admin3 = authController.loginUser("Admin", "admin123");
        System.out.println(admin3);
        User librarian1 = authController.loginUser("Pavel", "fhgh123");
        System.out.println(admin3);
        System.out.println(librarian1);
        authController.logout(librarian1);
        System.out.println(librarian1);

        //тестируем работу с библиотекарями
        User admin4 = authController.loginUser("Admin", "admin123");
        UserController userController = new UserController(admin4, userRepository, sessionRepository);
        userController.addLibrarian("Denis", "retyeuy", "test@test.com", "test3 address", "Lvov", "4654654");
        System.out.println(Arrays.deepToString(userController.viewLibrarian()));
        User librarian2 = authController.loginUser("Denis", "retyeuy");
        System.out.println(librarian2);
        // пробую добавить библиотекаря неавторизованным админом
        UserController userController2 = new UserController(admin4, userRepository, sessionRepository);
        userController.addLibrarian("Denis2", "retyeuy", "test2@test.com", "test3 address", "Lvov", "4654654");
        // пробую добавить библиотекаря неадмином
        UserController userController3 = new UserController(librarian2, userRepository, sessionRepository);
        userController.addLibrarian("Denis2", "retyeuy", "test2@test.com", "test3 address", "Lvov", "4654654");

        //добавляю книгу
        BookStorage bookStorage1 = new BookStorage(201, "$ddf", "Test name1", "test author1", "test publisher1", 5, 0, new Date());
        BookStorage bookStorage2 = new BookStorage(202, "$dff", "Test name2", "test author2", "test publisher2", 6, 0, new Date());


        BookStorage[] bookStorages = {bookStorage1, bookStorage2, null, null, null, null, null};
        BookStorageRepository bookStorageRepository = new BookStorageRepository(bookStorages);
        BookStorageController bookStorageController = new BookStorageController(librarian2, bookStorageRepository, sessionRepository);
        System.out.println(Arrays.deepToString(bookStorageController.viewBooks()));
        bookStorageController.addBooksToStorage(new BookStorage("@ddf", "Test name3", "test author3", "test publisher3", 7, new Date()));
        System.out.println(Arrays.deepToString(bookStorageController.viewBooks()));

        //выдаем книгу
        Issue[] issues = {null, null, null, null, null, null};
        IssueRepository issueRepository = new IssueRepository(issues);
        IssueController issueController = new IssueController(librarian2, issueRepository, bookStorageRepository, userRepository, sessionRepository);
        issueController.addIssue("$ddf", 301, "Ivan", "6732546327");
        System.out.println(Arrays.deepToString(issueController.viewIssues()));
        System.out.println(Arrays.deepToString(bookStorageController.viewBooks()));

        //возвращаем книгу
        issueController.returnBook("$ddf", 301);
        System.out.println(Arrays.deepToString(issueController.viewIssues()));
        System.out.println(Arrays.deepToString(bookStorageController.viewBooks()));
    }
}
