package main.lesson19.home;

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

    public File putFile(File file) throws Exception {
        for (int i = 0; i < files.length; i++) {
            if (files[i] == null) {
                files[i] = file;

                return files[i];
            }
        }

        throw new Exception("Error: File(id: " + file.getId() + ") was not saved. Storage(id: " + id + ") is full");
    }

    public void deleteFile(File file) throws Exception {
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

    public long getUsedSpace() {
        long usedSize = 0;
        for (File storageFile : files) {
            if (storageFile != null) {
                usedSize += storageFile.getSize();
            }
        }

        return usedSize;
    }
}
