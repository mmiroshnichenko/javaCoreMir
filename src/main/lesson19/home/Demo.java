package main.lesson19.home;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        try {
            File file1 = new File(1001, "test1", "txt", 15000);
            File file2 = new File(1002, "test2", "txt", 15000);
            File file3 = new File(1003, "test3", "txt", 15000);
            File file4 = new File(1004, "test4", "txt", 15000);
            File file5 = new File(1005, "test5", "txt", 15000);
            File file6 = new File(1006, "test6", "jpg", 25000);
            File file7 = new File(1007, "test7", "jpg", 25000);
            File file8 = new File(1008, "test8", "jpg", 25000);
            File file9 = new File(1009, "test9", "jpg", 25000);
            File file10 = new File(1010, "test10", "jpg", 25000);

            File tooBigFile = new File(1011, "test11", "jpg", 20000000);
            File wrongFormatFile = new File(1012, "test12", "mp3", 20000);
            //File wrongNameFile = new File(1013, "testtesttest13", "txt", 20000);

            File[] files1 = new File[]{file1, file2, file6, file7, null, null};
            String[] formatsSupported = new String[]{"txt", "jpg"};
            Storage storage1 = new Storage(2001, files1, formatsSupported, "USA", 200000);

            Controller controller = new Controller();

            System.out.println("Adding");

            try{
                //adding new correct file
                controller.put(storage1, file3);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                System.out.println(Arrays.toString(storage1.getFiles()));
            }

            try{
                //adding already exist file
                controller.put(storage1, file3);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                System.out.println(Arrays.toString(storage1.getFiles()));
            }

            try{
                //adding new file with wrong format
                controller.put(storage1, wrongFormatFile);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                System.out.println(Arrays.toString(storage1.getFiles()));
            }

            try{
                //adding new too big file
                controller.put(storage1, tooBigFile);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                System.out.println(Arrays.toString(storage1.getFiles()));
            }

            try{
                //adding new correct file
                controller.put(storage1, file4);
                System.out.println(Arrays.toString(storage1.getFiles()));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            try{
                //no free cells for new file
                controller.put(storage1, file5);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                System.out.println(Arrays.toString(storage1.getFiles()));
            }

            System.out.println("Deleting");
            try{
                //deleting exist file
                controller.delete(storage1, file1);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                System.out.println(Arrays.toString(storage1.getFiles()));
            }

            try{
                //deleting not exist file
                controller.delete(storage1, file8);
                System.out.println(Arrays.toString(storage1.getFiles()));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("Transfer all");
            File[] files2 = new File[]{file1, file2, file6, file7, null, null};
            File[] files3 = new File[]{file9, file10, null, null, null, null};
            String[] formatsSupported2 = new String[]{"txt", "jpg"};
            Storage storageFrom1 = new Storage(2002, files2, formatsSupported2, "USA", 200000);
            Storage storageTo1 = new Storage(2003, files3, formatsSupported2, "USA", 200000);

            try{
                //correct transfer
                controller.transferAll(storageFrom1, storageTo1);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                System.out.println("From: " + Arrays.toString(storageFrom1.getFiles()));
                System.out.println("To: " + Arrays.toString(storageTo1.getFiles()));
            }

            //one or more file already exists
            File[] files4 = new File[]{file1, file2, file6, file7, null, null};
            File[] files5 = new File[]{file7, file10, null, null, null, null};
            Storage storageFrom2 = new Storage(2002, files4, formatsSupported2, "USA", 200000);
            Storage storageTo2 = new Storage(2003, files5, formatsSupported2, "USA", 200000);
            try{
                controller.transferAll(storageFrom2, storageTo2);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                System.out.println("From: " + Arrays.toString(storageFrom2.getFiles()));
                System.out.println("To: " + Arrays.toString(storageTo2.getFiles()));
            }

            //incorrect format
            File[] files6 = new File[]{file1, file2, file6, file7, null, null};
            File[] files7 = new File[]{file8, file10, null, null, null, null};
            String[] formatsSupported3 = new String[]{"jpg"};
            Storage storageFrom3 = new Storage(2002, files6, formatsSupported2, "USA", 200000);
            Storage storageTo3 = new Storage(2003, files7, formatsSupported3, "USA", 200000);
            try{
                controller.transferAll(storageFrom3, storageTo3);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                System.out.println("From: " + Arrays.toString(storageFrom3.getFiles()));
                System.out.println("To: " + Arrays.toString(storageTo3.getFiles()));
            }

            //full cells
            File[] files8 = new File[]{file1, file2, file6, file7, file9, null};
            File[] files9 = new File[]{file8, file10, null, null, null, null};
            Storage storageFrom4 = new Storage(2002, files8, formatsSupported2, "USA", 200000);
            Storage storageTo4 = new Storage(2003, files9, formatsSupported2, "USA", 200000);
            try{
                controller.transferAll(storageFrom4, storageTo4);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                System.out.println("From: " + Arrays.toString(storageFrom4.getFiles()));
                System.out.println("To: " + Arrays.toString(storageTo4.getFiles()));
            }

            //full free space in storage
            File[] files10 = new File[]{file1, file2, tooBigFile, null, null};
            File[] files11 = new File[]{file8, file10, null, null, null, null};
            Storage storageFrom5 = new Storage(2002, files10, formatsSupported2, "USA", 2000000000);
            Storage storageTo5 = new Storage(2003, files11, formatsSupported2, "USA", 200000);
            try{
                controller.transferAll(storageFrom5, storageTo5);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                System.out.println("From: " + Arrays.toString(storageFrom5.getFiles()));
                System.out.println("To: " + Arrays.toString(storageTo5.getFiles()));
            }

            System.out.println("Transfer file");
            File[] files12 = new File[]{file1, file2, file6, file7, null, null};
            File[] files13 = new File[]{file9, file10, null, null, null, null};
            Storage storageFrom6 = new Storage(2002, files12, formatsSupported2, "USA", 200000);
            Storage storageTo6 = new Storage(2003, files13, formatsSupported2, "USA", 200000);
            //correct transfer file
            try{
                controller.transferFile(storageFrom6, storageTo6, 1001);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                System.out.println("From: " + Arrays.toString(storageFrom6.getFiles()));
                System.out.println("To: " + Arrays.toString(storageTo6.getFiles()));
            }

            //correct transfer file back
            try{
                controller.transferFile(storageTo6, storageFrom6, 1001);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                System.out.println("From: " + Arrays.toString(storageFrom6.getFiles()));
                System.out.println("To: " + Arrays.toString(storageTo6.getFiles()));
            }

            //not exists file
            try{
                controller.transferFile(storageFrom6, storageTo6, 3025);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                System.out.println("From: " + Arrays.toString(storageFrom6.getFiles()));
                System.out.println("To: " + Arrays.toString(storageTo6.getFiles()));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
