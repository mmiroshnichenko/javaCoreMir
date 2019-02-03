package main.lesson34.homework3;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Solution {
    public static void copyFileContent(String fileFromPath, String fileToPath) throws Exception {
        File fileFrom = new File(fileFromPath);
        File fileTo = new File(fileToPath);

        validate(fileFrom, fileTo);
        Files.copy(fileFrom.toPath(), fileTo.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

    public static void copyFileContentApacheIO(String fileFromPath, String fileToPath) throws Exception {
        File fileFrom = new File(fileFromPath);
        File fileTo = new File(fileToPath);

        validate(fileFrom, fileTo);
        FileUtils.copyFile(fileFrom, fileTo);
    }

    private static void validate(File fileFrom, File fileTo) throws Exception {

        if (!fileFrom.exists()) {
            throw new FileNotFoundException("File " + fileFrom.getPath() + " does not exist");
        }

        if (!fileTo.exists()) {
            throw new FileNotFoundException("File " + fileTo.getPath() + " does not exist");
        }

        if (!fileFrom.canRead()) {
            throw new Exception("File " + fileFrom.getPath() + " does not have permissions to read");
        }

        if (!fileTo.canWrite()) {
            throw new Exception("File " + fileTo.getPath() + " does not have permissions to be written");
        }
    }
}
