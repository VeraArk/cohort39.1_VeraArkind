import java.io.FileReader;
import java.io.IOException;

public class MyThread2 implements Runnable{
    @Override
    public void run() {
            try {
                FileReader file2 = new FileReader("basic_programming/lesson_43/src/File2");
                int character;
                while ((character = file2.read()) != -1) {
                    System.out.print((char)character);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }
}
