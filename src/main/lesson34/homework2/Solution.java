package main.lesson34.homework2;

import java.io.*;
import java.util.regex.Pattern;

public class Solution {
    public static void transferSentences(String fileFromPath, String fileToPath, String word) throws Exception {
        validate(fileFromPath, fileToPath);

        writeToFile(fileToPath, cutSentencesWithWord(fileFromPath, word), true);
    }

    private static StringBuffer cutSentencesWithWord(String fileFromPath, String word) throws Exception {
        StringBuffer textFrom = readFromFile(fileFromPath);
        StringBuffer sentences = new StringBuffer();
        int start;
        for (String sentence : Pattern.compile("\\.").split(textFrom)) {
            if (sentence.length() > 10 &&  Pattern.compile(".*\\b" + Pattern.quote(word) + "\\b.*", Pattern.CASE_INSENSITIVE).matcher(sentence).find()) {
                sentences.append(sentence + '.');

                start = textFrom.indexOf(sentence);
                textFrom.replace(start, start + sentence.length() + 1, "");
            }
        }

        writeToFile(fileFromPath, textFrom, false);

        return sentences;
    }

    private static StringBuffer readFromFile(String path) throws Exception {
        StringBuffer res = new StringBuffer();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                res.append(line);
                res.append("\n");
            }
            res.replace(res.length() - 1, res.length(), "");
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File " + path + " does not exist");
        } catch (IOException e) {
            throw new IOException("Reading from file " + path + " failed");
        }


        return res;
    }

    private static void writeToFile(String path, StringBuffer contentToWrite, boolean append) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, append))) {
            bufferedWriter.append(contentToWrite);
        } catch (IOException e) {
            throw new IOException("Can't write to file " + path);
        }
    }

    private static void validate(String fileFromPath, String fileToPath) throws Exception {
        File fileFrom = new File(fileFromPath);
        File fileTo = new File(fileToPath);

        if (!fileFrom.exists()) {
            throw new FileNotFoundException("File " + fileFromPath + " does not exist");
        }

        if (!fileTo.exists()) {
            throw new FileNotFoundException("File " + fileToPath + " does not exist");
        }

        if (!fileFrom.canRead()) {
            throw new Exception("File " + fileFromPath + " does not have permissions to read");
        }

        if (!fileTo.canWrite()) {
            throw new Exception("File " + fileToPath + " does not have permissions to be written");
        }
    }
}
