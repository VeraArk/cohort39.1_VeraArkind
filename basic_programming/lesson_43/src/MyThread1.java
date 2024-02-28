import java.io.FileReader;
import java.io.IOException;

public class MyThread1 implements Runnable{
    @Override
    public void run() {
        try {
            FileReader file1 = new FileReader("basic_programming/lesson_43/src/File1");
            int character;
            while ((character = file1.read()) != -1) {
                System.out.print((char)character);
            }
            System.out.print(" ");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
