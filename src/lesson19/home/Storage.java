package lesson19.home;

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

    public File getFileById(long id) throws Exception {
        File file = findFileById(id);
        if (file == null) {
            throw new Exception("Error: File(id: " + id + ") was not found in Storage(id: " + id + ")");
        }

        return file;
    }



    public void validateNewFile(File file) throws Exception {
        checkExistsFile(file);
        checkFileFormat(file);
        checkFreeSpaceForFile(file);
    }

    public void validateNewPacketFiles(File[] newFiles) throws Exception {
        checkFreeCellsForPacketFiles(newFiles);
        checkFreeSpaceForPacketFiles(newFiles);
        checkExistsForPacketFiles(newFiles);
        checkFileFormatForPacketFiles(newFiles);
    }

    private void checkFileFormatForPacketFiles(File[] newFiles) throws Exception{
        for (File file : newFiles) {
            if (file != null) {
                checkFileFormat(file);
            }
        }
    }

    private void checkFileFormat(File file) throws Exception {
        for (String formatSupported : formatsSupported) {
            if (formatSupported.equals(file.getFormat())) {
                return;
            }
        }

        throw new Exception("Error: File(id: " + id + ") has not supported format '" + file.getFormat()
                + " in Storage(id: " + id + ")");
    }

    private void checkFreeSpaceForFile(File file) throws Exception {
        if (file.getSize() > getFreeSpace()) {
            throw new Exception("Error: not enough space in Storage(id: " + id + ") for File(id: " + file.getId() + ")");
        }
    }

    private void checkFreeSpaceForPacketFiles(File[] newFiles) throws Exception {
        long filesSize = 0;
        for (File file : newFiles) {
            if (file != null) {
                filesSize += file.getSize();
            }
        }

        if (filesSize > getFreeSpace()) {
            throw new Exception("Error: not enough space in Storage(id: " + id + ") for Files");
        }
    }

    private void checkFreeCellsForPacketFiles(File[] newFiles) throws Exception {
        int countCells = 0;
        for (File file : files) {
            if (file == null) {
                countCells++;
            }
        }

        int countNewFiles = 0;
        for (File newFile : newFiles) {
            if (newFile != null) {
                countNewFiles++;
            }
        }

        if (countCells < countNewFiles) {
            throw new Exception("Error: not enough free cells in Storage(id: " + id + ") for Files");
        }
    }

    private long getFreeSpace() {
        return storageSize - getUsedSpace();
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

    private void checkExistsForPacketFiles(File[] newFiles) throws Exception{
        for (File file : newFiles) {
            if (file != null) {
                checkExistsFile(file);
            }
        }
    }

    private void checkExistsFile(File file) throws Exception {
        File existsFile = findFileById(file.getId());
        if (existsFile != null) {
            throw new Exception("Error: File(id: " + file.getId() + ") already exists in Storage(id: " + id + ")");
        }
    }

    private File findFileById(long id) {
        for (File file : files) {
            if (file != null && file.getId() == id) {
                return file;
            }
        }

        return null;
    }
}
