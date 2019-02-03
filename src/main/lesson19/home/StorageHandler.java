package main.lesson19.home;

import java.util.Arrays;

public class StorageHandler {
    private Storage storage;

    public StorageHandler(Storage storage) {
        this.storage = storage;
    }

    public File putFile(File file) throws Exception {
        validateNewFile(file);

        return storage.putFile(file);
    }

    public void deleteFile(File file) throws Exception {
        storage.deleteFile(file);
    }

    public void putPacketFiles(File[] newFiles) throws Exception {
        validateNewPacketFiles(newFiles);
        for (File file : newFiles) {
            storage.putFile(file);
        }
    }

    public void deleteStorageFiles() throws Exception {
        for (File file : storage.getFiles()) {
            storage.deleteFile(file);
        }
    }

    private void validateNewFile(File file) throws Exception {
        checkExistsAndFileFormat(file);

        if (file.getSize() > storage.getStorageSize() - storage.getUsedSpace()) {
            throw new Exception("Error: not enough space in Storage(id: " + storage.getId() + ") for File(id: " + file.getId() + ")");
        }
    }

    private void validateNewPacketFiles(File[] newFiles) throws Exception {
        long filesSize = 0;
        int countNewFiles = 0;
        for (File file : newFiles) {
            if (file != null) {
                checkExistsAndFileFormat(file);

                filesSize += file.getSize();
                countNewFiles++;
            }
        }

        if (filesSize > storage.getStorageSize() - storage.getUsedSpace()) {
            throw new Exception("Error: not enough space in Storage(id: " + storage.getId() + ") for Files");
        }

        int countCells = 0;
        for (File file : storage.getFiles()) {
            if (file == null) {
                countCells++;
            }
        }

        if (countCells < countNewFiles) {
            throw new Exception("Error: not enough free cells in Storage(id: " + storage.getId() + ") for Files");
        }
    }

    private void checkExistsAndFileFormat(File file) throws Exception {
        try {
            storage.findFileById(file.getId());
            throw new Exception("Error: File(id: " + file.getId() + ") already exists in Storage(id: " + storage.getId() + ")");
        } catch (Exception e) {
            //Sys.out.println("File(id: " + file.getId() + "not found in Storage(id: " + id + "). Will be saved");
        }

        if (!Arrays.asList(storage.getFormatsSupported()).contains(file.getFormat())) {
            throw new Exception("Error: File(id: " + file.getId() + ") has not supported format '" + file.getFormat()
                    + " in Storage(id: " + storage.getId() + ")");
        }
    }
}
