package main.lesson20.task2;

import main.lesson20.task2.exception.BadRequestException;
import main.lesson20.task2.exception.InternalServerException;
import main.lesson20.task2.exception.LimitExceeded;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        Controller controller = new Controller();

        Transaction transaction1 = new Transaction(1001, "Kiev", 5, "test1", TransactionType.INCOME, parseDate("2019-01-10"));
        Transaction transaction2 = new Transaction(1002, "Kiev", 10, "test2", TransactionType.INCOME, parseDate("2019-01-10"));
        Transaction transaction3 = new Transaction(1003, "Kiev", 10, "test3", TransactionType.INCOME, parseDate("2019-01-10"));
        Transaction transaction4 = new Transaction(1004, "Kiev", 10, "test4", TransactionType.INCOME, parseDate("2019-01-10"));
        Transaction transaction5 = new Transaction(1005, "Kiev", 10, "test5", TransactionType.INCOME, parseDate("2019-01-10"));
        Transaction transaction6 = new Transaction(1006, "Odessa", 10, "test6", TransactionType.INCOME, parseDate("2019-01-10"));
        Transaction transaction7 = new Transaction(1007, "Odessa", 10, "test7", TransactionType.INCOME, parseDate("2019-01-10"));
        Transaction transaction8 = new Transaction(1008, "Odessa", 10, "test8", TransactionType.INCOME, parseDate("2019-01-10"));
        Transaction transaction9 = new Transaction(1009, "Odessa", 5, "test9", TransactionType.INCOME, parseDate("2019-01-10"));
        //Transaction transaction10 = new Transaction(1010, "Odessa", 5, "test10", TransactionType.INCOME, parseDate("2019-01-10"));

        Transaction tooBigTransaction = new Transaction(1011, "Kiev", 50, "test11", TransactionType.INCOME, parseDate("2019-01-10"));
        Transaction tooBigPerDayTransaction = new Transaction(1012, "Kiev", 35, "test12", TransactionType.INCOME, parseDate("2019-01-10"));
        Transaction wrongCityTransaction = new Transaction(1013, "Lvov", 5, "test13", TransactionType.INCOME, parseDate("2019-01-10"));

        Transaction transaction11 = new Transaction(1014, "Odessa", 5, "test10", TransactionType.INCOME, parseDate("2019-01-10"));
        Transaction limitCountPerDayTransaction = new Transaction(1014, "Odessa", 5, "test10", TransactionType.INCOME, parseDate("2019-01-10"));

        try {
            controller.save(transaction1);
            controller.save(transaction2);
            controller.save(transaction3);
            controller.save(transaction4);
            controller.save(transaction5);
            controller.save(transaction6);
            controller.save(transaction7);
            controller.save(transaction8);
            controller.save(transaction9);
            //transactionDAO.save(transaction10);
        } catch (LimitExceeded e) {
            System.out.println("LimitExceededException: " + e.getMessage());
        } catch (BadRequestException e) {
            System.out.println("Bad request exception: " + e.getMessage());
        } catch (InternalServerException e) {
            System.out.println("InternalServerException: " + e.getMessage());
        } catch (Exception e){
            System.out.println("Unexpected exception: " + e.getMessage());
        } finally {
            System.out.println(Arrays.toString(controller.transactionList()));
        }

        //too big transaction amount
        try {
            controller.save(tooBigTransaction);
        } catch (LimitExceeded e) {
            System.out.println("LimitExceededException: " + e.getMessage());
        } catch (BadRequestException e) {
            System.out.println("Bad request exception: " + e.getMessage());
        } catch (InternalServerException e) {
            System.out.println("InternalServerException: " + e.getMessage());
        } catch (Exception e){
            System.out.println("Unexpected exception: " + e.getMessage());
        } finally {
            System.out.println(Arrays.toString(controller.transactionList()));
        }

        //too big amount transactions per day
        try {
            controller.save(tooBigPerDayTransaction);
        } catch (LimitExceeded e) {
            System.out.println("LimitExceededException: " + e.getMessage());
        } catch (BadRequestException e) {
            System.out.println("Bad request exception: " + e.getMessage());
        } catch (InternalServerException e) {
            System.out.println("InternalServerException: " + e.getMessage());
        } catch (Exception e){
            System.out.println("Unexpected exception: " + e.getMessage());
        } finally {
            System.out.println(Arrays.toString(controller.transactionList()));
        }

        //incorrect transaction city
        try {
            controller.save(wrongCityTransaction);
        } catch (LimitExceeded e) {
            System.out.println("LimitExceededException: " + e.getMessage());
        } catch (BadRequestException e) {
            System.out.println("Bad request exception: " + e.getMessage());
        } catch (InternalServerException e) {
            System.out.println("InternalServerException: " + e.getMessage());
        } catch (Exception e){
            System.out.println("Unexpected exception: " + e.getMessage());
        } finally {
            System.out.println(Arrays.toString(controller.transactionList()));
        }

        //last correct transaction per day
        try {
            controller.save(transaction11);
        } catch (LimitExceeded e) {
            System.out.println("LimitExceededException: " + e.getMessage());
        } catch (BadRequestException e) {
            System.out.println("Bad request exception: " + e.getMessage());
        } catch (InternalServerException e) {
            System.out.println("InternalServerException: " + e.getMessage());
        } catch (Exception e){
            System.out.println("Unexpected exception: " + e.getMessage());
        } finally {
            System.out.println(Arrays.toString(controller.transactionList()));
        }

        //limit quantity transactions per day
        try {
            controller.save(limitCountPerDayTransaction);
        } catch (LimitExceeded e) {
            System.out.println("LimitExceededException: " + e.getMessage());
        } catch (BadRequestException e) {
            System.out.println("Bad request exception: " + e.getMessage());
        } catch (InternalServerException e) {
            System.out.println("InternalServerException: " + e.getMessage());
        } catch (Exception e){
            System.out.println("Unexpected exception: " + e.getMessage());
        } finally {
            System.out.println(Arrays.toString(controller.transactionList()));
        }

        //get list by city
        System.out.println(Arrays.toString(controller.transactionList("Kiev")));
        System.out.println(Arrays.toString(controller.transactionList("Odessa")));
        //get list by amount
        System.out.println(Arrays.toString(controller.transactionList(10)));
        System.out.println(Arrays.toString(controller.transactionList(5)));

    }

    private static Date parseDate(String date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            return null;
        }
    }
}
