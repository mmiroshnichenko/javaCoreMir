package lesson19.home;

public class Controller {
    public File put(Storage storage, File file) throws Exception {
        storage.validateNewFile(file);
        return storage.put(file);
    }

    public void delete(Storage storage, File file) throws Exception {
        storage.delete(file);
    }

    public void transferAll(Storage storageFrom, Storage storageTo) throws Exception {
        storageTo.validateNewPacketFiles(storageFrom.getFiles());
        for (File file : storageFrom.getFiles()) {
            storageTo.put(file);
            storageFrom.delete(file);
        }
    }

    public void transferFile(Storage storageFrom, Storage storageTo, long id)  throws Exception {
        File file = storageFrom.getFileById(id);
        put(storageTo, file);
        delete(storageFrom, file);
    }
}
