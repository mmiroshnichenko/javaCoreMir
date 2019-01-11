package lesson19.home;

import java.util.Arrays;

public class Storage {
    private long id;
    private File[] files;
    private String[] formatsSupported;
    private String storageCountry;
    private long storageSize;

    public Storage(long id, File[] files, String[] formatsSupported, String storageCountry, long storageSize) {
        this.id = id;
        this.files = files;
        this.formatsSupported = formatsSupported;
        this.storageCountry = storageCountry;
        this.storageSize = storageSize;
    }

    public long getId() {
        return id;
    }

    public File[] getFiles() {
        return files;
    }

    public String[] getFormatsSupported() {
        return formatsSupported;
    }

    public String getStorageCountry() {
        return storageCountry;
    }

    public long getStorageSize() {
        return storageSize;
    }

    public File put(File file) throws Exception {
        for (int i = 0; i < files.length; i++) {
            if (files[i] == null) {
                files[i] = file;

                return files[i];
            }
        }

        throw new Exception("Error: File(id: " + file.getId() + ") was not saved. Storage(id: " + id + ") is full");
    }

    public void delete(File file) throws Exception {
        for (int i = 0; i < files.length; i++) {
            if (files[i] != null && files[i].equals(file)) {
                files[i] = null;

                return;
            }
        }

        throw new Exception("Error: File(id: " + file.getId() + ") was not deleted. File was not found in Storage(id: "
                + id + ")");
    }

    public File findFileById(long fileId) throws Exception{
        for (File file : files) {
            if (file != null && file.getId() == fileId) {
                return file;
            }
        }

        throw new Exception("Error: File(id: " + fileId + ") was not found in Storage(id: " + id + ")");
    }

    public void validateNewFile(File file) throws Exception {
        try {
            findFileById(file.getId());
            throw new Exception("Error: File(id: " + file.getId() + ") already exists in Storage(id: " + id + ")");
        } catch (Exception e) {
            //System.out.println("File(id: " + file.getId() + "not found in Storage(id: " + id + "). Will be saved");
        }

        if (!Arrays.asList(formatsSupported).contains(file.getFormat())) {
            throw new Exception("Error: File(id: " + id + ") has not supported format '" + file.getFormat()
                    + " in Storage(id: " + id + ")");
        }

        if (file.getSize() > storageSize - getUsedSpace()) {
            throw new Exception("Error: not enough space in Storage(id: " + id + ") for File(id: " + file.getId() + ")");
        }
    }

    public void validateNewPacketFiles(File[] newFiles) throws Exception {
        long filesSize = 0;
        int countNewFiles = 0;
        for (File file : newFiles) {
            if (file != null) {
                try {
                    findFileById(file.getId());
                    throw new Exception("Error: File(id: " + file.getId() + ") already exists in Storage(id: " + id + ")");
                } catch (Exception e) {
                    System.out.println("File(id: " + file.getId() + "not found in Storage(id: " + id + "). Will be saved");
                }

                if (!Arrays.asList(formatsSupported).contains(file.getFormat())) {
                    throw new Exception("Error: File(id: " + id + ") has not supported format '" + file.getFormat()
                            + " in Storage(id: " + id + ")");
                }
                filesSize += file.getSize();
                countNewFiles++;
            }
        }

        if (filesSize > storageSize - getUsedSpace()) {
            throw new Exception("Error: not enough space in Storage(id: " + id + ") for Files");
        }

        int countCells = 0;
        for (File file : files) {
            if (file == null) {
                countCells++;
            }
        }

        if (countCells < countNewFiles) {
            throw new Exception("Error: not enough free cells in Storage(id: " + id + ") for Files");
        }
    }

    private long getUsedSpace() {
        long usedSize = 0;
        for (File storageFile : files) {
            if (storageFile != null) {
                usedSize += storageFile.getSize();
            }
        }

        return usedSize;
    }
}
