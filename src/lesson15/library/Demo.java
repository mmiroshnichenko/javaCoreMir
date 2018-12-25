package lesson15.library;

import lesson15.library.controller.AuthController;
import lesson15.library.controller.BookController;
import lesson15.library.controller.IssueController;
import lesson15.library.controller.UserController;
import lesson15.library.entity.Book;
import lesson15.library.entity.Issue;
import lesson15.library.entity.User;
import lesson15.library.entity.Visitor;
import lesson15.library.repository.BookRepository;
import lesson15.library.repository.IssueRepository;
import lesson15.library.repository.UserRepository;
import lesson15.library.repository.VisitorRepository;

import java.util.Arrays;
import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        User admin = new User(101, "Admin", "admin123", "admin@gmail.com", "test address", "Kiev", "546546546", true);
        User librarian = new User(102, "Pavel", "fhgh123", "pavel.librarian@gmail.com", "test2 address", "Kharkov", "454654654", false);
        User[] users = {admin, librarian, null, null, null, null};
        UserRepository userRepository = new UserRepository(users);

        //тестируем авторизацию пользователей
        AuthController authController = new AuthController(userRepository);
        User admin1 = authController.loginAdmin("Admin", "admin123");

        System.out.println(admin1);
        authController.logout(admin1);
        System.out.println(admin1);
        //неверный пароль админа
        User admin2 = authController.loginAdmin("Admin", "admi3123");
        System.out.println(admin2);

        User admin3 = authController.loginAdmin("Admin", "admin123");
        System.out.println(admin3);
        User librarian1 = authController.loginLibrarian("Pavel", "fhgh123");
        System.out.println(admin3);
        System.out.println(librarian1);
        authController.logout(librarian1);
        System.out.println(librarian1);

        //тестируем работу с библиотекарями
        User admin4 = authController.loginAdmin("Admin", "admin123");
        UserController userController = new UserController(admin4, userRepository);
        userController.addLibrarian("Denis", "retyeuy", "test@test.com", "test3 address", "Lvov", "4654654");
        System.out.println(Arrays.deepToString(userController.viewLibrarian()));
        User librarian2 = authController.loginLibrarian("Denis", "retyeuy");
        System.out.println(librarian2);
        // пробую добавить библиотекаря неавторизованным админом
        UserController userController2 = new UserController(admin4, userRepository);
        userController.addLibrarian("Denis2", "retyeuy", "test2@test.com", "test3 address", "Lvov", "4654654");
        // пробую добавить библиотекаря неадмином
        UserController userController3 = new UserController(librarian2, userRepository);
        userController.addLibrarian("Denis2", "retyeuy", "test2@test.com", "test3 address", "Lvov", "4654654");

        //добавляю книгу
        Book book1 = new Book(201, "$ddf", "Test name1", "test author1", "test publisher1", 5, 0, new Date());
        Book book2 = new Book(202, "$dff", "Test name2", "test author2", "test publisher2", 6, 0, new Date());

        Book[] books = {book1, book2, null, null, null, null, null};
        BookRepository bookRepository = new BookRepository(books);
        BookController bookController = new BookController(librarian2, bookRepository);
        System.out.println(Arrays.deepToString(bookController.viewBooks()));
        bookController.addBooks("@ddf", "Test name3", "test author3", "test publisher3", 7);
        System.out.println(Arrays.deepToString(bookController.viewBooks()));

        //выдаем книгу
        //public Visitor(long id, String name, String contact) {
        Visitor visitor1 = new Visitor(301, "Ivan", "6732546327");
        Visitor visitor2 = new Visitor(302, "Inga", "6734545327");
        Visitor[] visitors = {visitor1, visitor2, null, null, null, null};
        VisitorRepository visitorRepository = new VisitorRepository(visitors);
        Issue[] issues = {null, null, null, null, null, null};
        IssueRepository issueRepository = new IssueRepository(issues);
        IssueController issueController = new IssueController(librarian2, issueRepository, bookRepository, visitorRepository);
        issueController.addIssue("$ddf", 301, "Ivan", "6732546327");
        System.out.println(Arrays.deepToString(issueController.viewIssues()));
        System.out.println(Arrays.deepToString(bookController.viewBooks()));

        //возвращаем книгу
        issueController.returnBook("$ddf", 301);
        System.out.println(Arrays.deepToString(issueController.viewIssues()));
        System.out.println(Arrays.deepToString(bookController.viewBooks()));
    }
}
