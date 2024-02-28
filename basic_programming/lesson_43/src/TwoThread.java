import java.io.FileReader;
import java.io.IOException;

public class TwoThread extends Thread{

    /*
Напишите программу, которая параллельно считывает данные из двух файлов и выводит их на экран.
Пример
Входные данные (в файле 1): Hello, World!
Входные данные (в файле 2): How are you?
Выходные данные: Hello, World! How are you?
     */

    public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run(){
            try {
                FileReader file1 = new FileReader("basic_programming/lesson_43/src/File1");
                int character;
                while ((character = file1.read()) != -1) {
                    System.out.print((char) character);
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }});
        threadOne.start();
        threadOne.join();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.print(" ");
                try {
                FileReader file2 = new FileReader("basic_programming/lesson_43/src/File2");
                int character;
                while ((character = file2.read()) != -1) {
                    System.out.print((char) character);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }}).start();
    }
}
