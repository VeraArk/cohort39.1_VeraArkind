package DatabaseTest;

public interface Database {
    /*
    Создать интерфейс Database с методами read() и write().
    Используйте этот интерфейс для создания классов MySQLDatabase и MongoDatabase.
     */
    void read();
    void write();
}
