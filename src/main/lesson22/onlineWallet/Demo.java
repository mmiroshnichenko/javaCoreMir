package main.lesson22.onlineWallet;

import main.lesson22.onlineWallet.exception.BadRequestException;
import main.lesson22.onlineWallet.exception.InternalServerException;
import main.lesson22.onlineWallet.exception.LimitExceeded;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Demo {
    public static void main(String[] args) {
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
            Controller.save(transaction1);
            Controller.save(transaction2);
            Controller.save(transaction3);
            Controller.save(transaction4);
            Controller.save(transaction5);
            Controller.save(transaction6);
            Controller.save(transaction7);
            Controller.save(transaction8);
            Controller.save(transaction9);
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
            System.out.println(Arrays.toString(Controller.transactionList()));
        }

        //too big transaction amount
        try {
            Controller.save(tooBigTransaction);
        } catch (LimitExceeded e) {
            System.out.println("LimitExceededException: " + e.getMessage());
        } catch (BadRequestException e) {
            System.out.println("Bad request exception: " + e.getMessage());
        } catch (InternalServerException e) {
            System.out.println("InternalServerException: " + e.getMessage());
        } catch (Exception e){
            System.out.println("Unexpected exception: " + e.getMessage());
        } finally {
            System.out.println(Arrays.toString(Controller.transactionList()));
        }

        //too big amount transactions per day
        try {
            Controller.save(tooBigPerDayTransaction);
        } catch (LimitExceeded e) {
            System.out.println("LimitExceededException: " + e.getMessage());
        } catch (BadRequestException e) {
            System.out.println("Bad request exception: " + e.getMessage());
        } catch (InternalServerException e) {
            System.out.println("InternalServerException: " + e.getMessage());
        } catch (Exception e){
            System.out.println("Unexpected exception: " + e.getMessage());
        } finally {
            System.out.println(Arrays.toString(Controller.transactionList()));
        }

        //incorrect transaction city
        try {
            Controller.save(wrongCityTransaction);
        } catch (LimitExceeded e) {
            System.out.println("LimitExceededException: " + e.getMessage());
        } catch (BadRequestException e) {
            System.out.println("Bad request exception: " + e.getMessage());
        } catch (InternalServerException e) {
            System.out.println("InternalServerException: " + e.getMessage());
        } catch (Exception e){
            System.out.println("Unexpected exception: " + e.getMessage());
        } finally {
            System.out.println(Arrays.toString(Controller.transactionList()));
        }

        //last correct transaction per day
        try {
            Controller.save(transaction11);
        } catch (LimitExceeded e) {
            System.out.println("LimitExceededException: " + e.getMessage());
        } catch (BadRequestException e) {
            System.out.println("Bad request exception: " + e.getMessage());
        } catch (InternalServerException e) {
            System.out.println("InternalServerException: " + e.getMessage());
        } catch (Exception e){
            System.out.println("Unexpected exception: " + e.getMessage());
        } finally {
            System.out.println(Arrays.toString(Controller.transactionList()));
        }

        //limit quantity transactions per day
        try {
            Controller.save(limitCountPerDayTransaction);
        } catch (LimitExceeded e) {
            System.out.println("LimitExceededException: " + e.getMessage());
        } catch (BadRequestException e) {
            System.out.println("Bad request exception: " + e.getMessage());
        } catch (InternalServerException e) {
            System.out.println("InternalServerException: " + e.getMessage());
        } catch (Exception e){
            System.out.println("Unexpected exception: " + e.getMessage());
        } finally {
            System.out.println(Arrays.toString(Controller.transactionList()));
        }

        //get list by city
        System.out.println(Arrays.toString(Controller.transactionList("Kiev")));
        System.out.println(Arrays.toString(Controller.transactionList("Odessa")));
        //get list by amount
        System.out.println(Arrays.toString(Controller.transactionList(10)));
        System.out.println(Arrays.toString(Controller.transactionList(5)));

    }

    private static Date parseDate(String date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            return null;
        }
    }
}
