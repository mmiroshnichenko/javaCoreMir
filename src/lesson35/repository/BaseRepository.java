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


    public ArrayList<T> getAllObjects() throws Exception {
        return objects;
    }

    public BaseRepository(int countFields, String pathFileDb) throws Exception {
        this.countFields = countFields;
        this.pathFileDb = pathFileDb;
        loadObjectsFromDb();
    }

    protected abstract T mapObject(String[] rowData) throws Exception;

    protected abstract String toDbRow(T object);

    public T findById(long id) {
        for (T object : objects) {
            if (object.getId() == id) {
                return object;
            }
        }

        return null;
    }

    public T find(T object) {
        for (T obj : objects) {
            if (obj.equals(object)) {
                return obj;
            }
        }

        return null;
    }

    protected T saveObject(T object) throws Exception {
        if (find(object) != null) {
            throw new BadRequestException("Error: " + object + " already exist");
        }

        object.setId(getNextId());

        StringBuffer sb = new StringBuffer();
        sb.append("\n");
        sb.append(toDbRow(object));

        writeToDb(sb, true);
        objects.add(object);
        return object;
    }

    protected void removeObject(T object) throws Exception {
        for (T obj : objects) {
            if (object.equals(obj)) {
                objects.remove(obj);
                break;
            }
        }

        saveObjectsInDb();
    }

    protected void saveObjectsInDb() throws Exception {
        StringBuffer sb = new StringBuffer();
        for (T object : objects) {
            sb.append("\n");
            sb.append(toDbRow(object));
        }

        writeToDb(sb, false);
    }

    private void loadObjectsFromDb() throws Exception {
        for (String row : Pattern.compile("\n").split(readFromDb())) {
            String[] rowData = Pattern.compile("|").split(row);
            if (rowData.length != countFields) {
                throw new DataBaseException("Error: base file -" + pathFileDb + "- is broken");
            }

            objects.add(mapObject(rowData));
        }
    }

    private StringBuffer readFromDb() throws Exception {
        StringBuffer res = new StringBuffer();
        try (BufferedReader br = new BufferedReader(new FileReader(pathFileDb))) {
            String line;
            while ((line = br.readLine()) != null) {
                res.append(line);
                res.append("\n");
            }
            res.replace(res.length() - 1, res.length(), "");
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
