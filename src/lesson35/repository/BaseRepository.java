package lesson35.repository;

import lesson35.exceptions.BadRequestException;
import lesson35.exceptions.DataBaseException;
import lesson35.model.BaseModel;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Pattern;

public abstract class BaseRepository<T extends BaseModel> {

    protected int countFields;
    protected String pathFileDb;

    protected ArrayList<T> objects;

    protected abstract T mapObject(String[] rowData) throws Exception;

    protected abstract String toDbRow(T object);

    public BaseRepository(int countFields, String pathFileDb) {
        this.countFields = countFields;
        this.pathFileDb = System.getProperty("user.dir") + "\\src\\lesson35\\database\\" + pathFileDb;
    }

    public ArrayList<T> getAllObjects() throws Exception {
        if (objects == null) {
            objects = loadObjectsFromDb();
        }

        return objects;
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
        T existObject = find(object);
        if (existObject != null) {
            throw new BadRequestException("Error: " + existObject + " already exist");
        }

        object.setId(getNextId());

        StringBuffer sb = new StringBuffer();
        sb.append(toDbRow(object));
        sb.append("\n");

        writeToDb(sb, true);
        objects.add(object);
        return object;
    }

    public void removeById(long id) throws Exception {
        T object = findById(id);
        if (object == null) {
            throw new BadRequestException("Error: object with id:" + id + " does not exist in DB");
        }
        objects.remove(object);
        saveObjectsInDb();
    }

    public void removeObject(T object) throws Exception {
        T dbObject = find(object);
        if (dbObject == null) {
            throw new BadRequestException("Error: " + object + " does not exist in DB");
        }
        objects.remove(dbObject);
        saveObjectsInDb();
    }

    public void updateObject(T updatedObject) throws Exception {
        int index = 0;
        for (T object : getAllObjects()) {
            if (object.getId() == updatedObject.getId()) {
                objects.set(index, updatedObject);

                saveObjectsInDb();
                return;
            }
            index++;
        }

        throw new BadRequestException("Error: object with id:" + updatedObject.getId() + " does not exist in DB");
    }

    public void saveObjectsInDb() throws Exception {
        StringBuffer sb = new StringBuffer();
        for (T object : getAllObjects()) {
            sb.append(toDbRow(object));
            sb.append("\n");
        }

        writeToDb(sb, false);
    }

    public void clearDataInDb() throws Exception {
        if (objects == null) {
            getAllObjects();
        }
        objects.clear();
        saveObjectsInDb();
    }

    private ArrayList<T> loadObjectsFromDb() throws Exception {
        ArrayList<T> objectsList = new ArrayList<>();

        StringBuffer stringBuffer = readFromDb();
        if (stringBuffer.length() > 0) {
            for (String row : Pattern.compile("\n").split(stringBuffer)) {
                String[] rowData = Pattern.compile(";").split(row);
                if (rowData.length != countFields) {
                    throw new DataBaseException("Error: base file -" + pathFileDb + "- is broken");
                }

                objectsList.add(mapObject(rowData));
            }
        }

        return objectsList;
    }

    private StringBuffer readFromDb() throws Exception {
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

    private void writeToDb(StringBuffer contentToWrite, boolean append) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pathFileDb, append))) {
            bufferedWriter.append(contentToWrite);
        } catch (IOException e) {
            throw new IOException("Can't write to file " + pathFileDb);
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
