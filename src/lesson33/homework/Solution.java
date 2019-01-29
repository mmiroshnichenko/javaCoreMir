package lesson33.homework;

import org.apache.commons.io.IOUtils;

import java.io.*;

public class Solution {
    public static void writeToFileFromConsole(String path) {
        try {
            File file = new File(path);
            if (!file.exists()) {
                throw new FileNotFoundException("File with path -" + path + "- not found");
            }
            writeTextToFile(file, readTextFromConsole());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private static String readTextFromConsole() throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

        System.out.println("Enter file content to write in the file:");
        String text = "";
        try {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.equals("wr")) {
                    break;
                }
                text = text.concat(line) + "\n";
            }
        } catch (IOException e) {
            throw new IOException("Reading from keyboard failed");
        } finally {
            IOUtils.closeQuietly(br);
            IOUtils.closeQuietly(reader);
        }

        return text;
    }

    private static void writeTextToFile(File file, String text) throws IOException{
        FileWriter writer = null;
        BufferedWriter bufferedWriter = null;
        try {

            writer = new FileWriter(file, true);
            bufferedWriter = new BufferedWriter(writer);

            bufferedWriter.append(text);
        } catch (IOException e) {
            throw new IOException("Can't write to file with path -" + file.getPath() + "-");
        } finally {
            IOUtils.closeQuietly(bufferedWriter);
            IOUtils.closeQuietly(writer);
        }
    }
}
