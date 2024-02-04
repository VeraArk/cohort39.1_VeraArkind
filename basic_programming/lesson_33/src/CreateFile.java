import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
Задание 1: Работа с файлами
Создайте текстовый файл с несколькими строками текста.
Напишите метод, который будет читать этот файл и выводить содержимое в консоль.
Напишите метод, который будет записывать в этот же файл строку “Hello, World!” в конец файла.
Пример работы:
Входные данные: Файл с текстом "Java is fun\nI love programming\n"
Выходные данные: В консоль выводится:
Java is fun
I love programming
Hello, World!
 */

public class CreateFile {

    public static void main(String[] args) throws IOException {

        String text = "Java is fun\nI love programming\n";

        try (FileWriter output = new FileWriter("fileExample.txt")) {
            for (int i = 0; i < text.length(); i++) {
                output.write(text.charAt(i));
            }
            System.out.println("Done");
        }

        try (FileReader reader = new FileReader("fileExample.txt")) {
            int character;
            while ((character = reader.read()) != -1) {
                System.out.print((char) character);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();
        String addText = "Hello World";

        try (FileWriter output1 = new FileWriter("fileExample.txt", true)) {
            for (int i = 0; i < addText.length(); i++) {
                output1.write(addText.charAt(i));
            }
        }
        try (FileReader reader = new FileReader("fileExample.txt")) {
            int character;
            while ((character = reader.read()) != -1) {
                System.out.print((char) character);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

