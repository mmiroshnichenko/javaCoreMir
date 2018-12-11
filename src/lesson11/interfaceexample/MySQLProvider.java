package lesson11.interfaceexample;

public class MySQLProvider implements DbProvider {

    @Override
    public void connectToDb() {
        //logic for Mysql
    }

    @Override
    public void disconnectFromDb() {

    }

    @Override
    public void encryptData() {

    }
}
