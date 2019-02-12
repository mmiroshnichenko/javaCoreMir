package lesson35.repository;

import lesson35.exceptions.BadRequestException;
import lesson35.model.BaseModel;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Pattern;

public abstract class BaseRepository<T extends BaseModel> {

    protected String pathFileDb;

    protected abstract T mapObject(String[] rowData) throws Exception;

    public BaseRepository(String pathFileDb) {
        this.pathFileDb = System.getProperty("user.dir") + "\\src\\lesson35\\database\\" + pathFileDb;
    }

    public ArrayList<T> getAllObjects() throws Exception {
        ArrayList<T> objectsList = new ArrayList<>();

        StringBuffer stringBuffer = readFromDb();
        if (stringBuffer.length() > 0) {
            for (String row : Pattern.compile("\n").split(stringBuffer)) {
                String[] rowData = Pattern.compile(";").split(row);
                objectsList.add(mapObject(rowData));
            }
        }

        return objectsList;
    }

    public T findById(long id) throws Exception {
        for (T object : getAllObjects()) {
            if (object.getId() == id) {
                return object;
            }
        }

        return null;
    }

    public T find(T object) throws Exception {
        for (T obj : getAllObjects()) {
            if (obj.equals(object)) {
                return obj;
            }
        }

        return null;
    }

    public T addObject(T object) throws Exception {
        object.setId(getNextId());

        StringBuffer sb = new StringBuffer();
        sb.append(object);
        sb.append("\n");

        writeToDb(sb, true);
        return object;
    }

    public void removeObject(T object) throws Exception {
        T dbObject = find(object);
        if (dbObject == null) {
            throw new BadRequestException("Error: " + object + " does not exist in DB");
        }
        ArrayList<T> objectsList = getAllObjects();
        objectsList.remove(dbObject);
        saveObjectsInDb(objectsList);
    }

    public void updateObject(T updatedObject) throws Exception {
        int index = 0;
        ArrayList<T> objectsList = getAllObjects();
        for (T object : objectsList) {
            if (object.getId() == updatedObject.getId()) {
                objectsList.set(index, updatedObject);

                saveObjectsInDb(objectsList);
                return;
            }
            index++;
        }

        throw new BadRequestException("Error: object with id:" + updatedObject.getId() + " does not exist in DB");
    }

    public void saveObjectsInDb(ArrayList<T> objectsList) throws Exception {
        StringBuffer sb = new StringBuffer();
        for (T object : objectsList) {
            sb.append(object);
            sb.append("\n");
        }

        writeToDb(sb, false);
    }

    public void clearDataInDb() throws Exception {
        saveObjectsInDb(new ArrayList<>());
    }

    private StringBuffer readFromDb() throws Exception {
        validateFile();
        StringBuffer res = new StringBuffer();
        try (BufferedReader br = new BufferedReader(new FileReader(pathFileDb))) {
            String line;
            while ((line = br.readLine()) != null) {
                res.append(line);
                res.append("\n");
            }
            if (res.length() > 0) {
                res.replace(res.length() - 1, res.length(), "");
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File " + pathFileDb + " does not exist");
        } catch (IOException e) {
            throw new IOException("Reading from file " + pathFileDb + " failed");
        }

        return res;
    }

    private void writeToDb(StringBuffer contentToWrite, boolean append) throws Exception {
        validateFile();
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pathFileDb, append))) {
            bufferedWriter.append(contentToWrite);
        } catch (IOException e) {
            throw new IOException("Can't write to file " + pathFileDb);
        }
    }

    private void validateFile() throws Exception {
        File file = new File(pathFileDb);

        if (!file.exists()) {
            throw new FileNotFoundException("File " + pathFileDb + " does not exist");
        }

        if (!file.canRead()) {
            throw new Exception("File " + pathFileDb + " does not have permissions to read");
        }

        if (!file.canWrite()) {
            throw new Exception("File " + pathFileDb + " does not have permissions to be written");
        }
    }

    private long getNextId() throws Exception{
        long maxId = 0;
        for (T object : getAllObjects()) {
            if (object.getId() > maxId) {
                maxId = object.getId();
            }
        }
        maxId++;

        return maxId;
    }

}
