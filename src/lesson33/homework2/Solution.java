package lesson33.homework2;

import org.apache.commons.io.IOUtils;

import java.io.*;

public class Solution {

    public static void readFileByConsolePath() {
        try {
            readFile(readPathFromConsole());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private static String readPathFromConsole() throws IOException {
        //using scanner
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

        System.out.println("Please enter file path to read:");

        String path = "";
        try {
            path = br.readLine();
        } catch (IOException e) {
            throw new IOException("Reading from keyboard failed");
        } finally {
            IOUtils.closeQuietly(reader);
            IOUtils.closeQuietly(br);
        }

        return path;
    }

    private static void readFile(String path) throws Exception {
        FileReader reader;
        try {
            reader = new FileReader(path);
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File with path -" + path + "- not found");
        }

        BufferedReader br = new BufferedReader(reader);

        try {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new IOException("Can't read file by path -" + path + "-");
        } finally {
            IOUtils.closeQuietly(br);
            IOUtils.closeQuietly(reader);
        }
    }
}
