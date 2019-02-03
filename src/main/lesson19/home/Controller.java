package main.lesson19.home;

public class Controller {

    public File put(Storage storage, File file) throws Exception {
        StorageHandler storageHandler = new StorageHandler(storage);
        return storageHandler.putFile(file);
    }

    public void delete(Storage storage, File file) throws Exception {
        StorageHandler storageHandler = new StorageHandler(storage);
        storageHandler.deleteFile(file);
    }

    public void transferAll(Storage storageFrom, Storage storageTo) throws Exception {
        StorageHandler storageHandlerTo = new StorageHandler(storageTo);
        StorageHandler storageHandlerFrom = new StorageHandler(storageFrom);

        storageHandlerTo.putPacketFiles(storageFrom.getFiles());
        storageHandlerFrom.deleteStorageFiles();
    }

    public void transferFile(Storage storageFrom, Storage storageTo, long id)  throws Exception {
        File file = storageFrom.findFileById(id);

        put(storageTo, file);
        delete(storageFrom, file);
    }
}
