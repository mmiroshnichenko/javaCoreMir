package lesson19.home;

public class Controller {
    public File put(Storage storage, File file) throws Exception{
        storage.validateNewFile(file);
        return storage.put(file);
    }

    public void delete(Storage storage, File file) {
        try {
            storage.delete(file);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void transferAll(Storage storageFrom, Storage storageTo) {
        try {
            storageTo.validateNewPacketFiles(storageFrom.getFiles());
            for (File file : storageFrom.getFiles()) {
                storageTo.put(file);
                storageFrom.delete(file);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void transferFile(Storage storageFrom, Storage storageTo, long id) {
        try {
            File file = storageFrom.getFileById(id);
            put(storageTo, file);
            delete(storageFrom, file);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
