package DatabaseTest;
public class MySQLDatabase implements Database {

    @Override
    public void read() {
        System.out.println("Read Data from MySQLDatabase");
    }

    @Override
    public void write() {
        System.out.println("Write Data in MySQLDatabase");
    }
}

