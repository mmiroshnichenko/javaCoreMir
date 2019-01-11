package lesson19.home;

public class Controller {

    public File put(Storage storage, File file) throws Exception {
        StorageDAO storageDAO = new StorageDAO(storage);
        return storageDAO.putFile(file);
    }

    public void delete(Storage storage, File file) throws Exception {
        StorageDAO storageDAO = new StorageDAO(storage);
        storageDAO.deleteFile(file);
    }

    public void transferAll(Storage storageFrom, Storage storageTo) throws Exception {
        StorageDAO storageDAOTo = new StorageDAO(storageTo);
        StorageDAO storageDAOFrom = new StorageDAO(storageFrom);

        storageDAOTo.putPacketFiles(storageFrom.getFiles());
        storageDAOFrom.deleteStorageFiles();
    }

    public void transferFile(Storage storageFrom, Storage storageTo, long id)  throws Exception {
        File file = storageFrom.findFileById(id);

        put(storageTo, file);
        delete(storageFrom, file);
    }
}
