package DatabaseTest;

public class MongoDatabase implements Database{

    @Override
    public void read() {
        System.out.println("Read Data from MongoDatabase");
    }

    @Override
    public void write() {
        System.out.println("Write Data in MongoDatabase");
    }
}

