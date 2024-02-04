import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
Задание 2: Работа с пользовательским вводом
Напишите программу, которая будет запрашивать у пользователя его имя.
Запишите имя пользователя в текстовый файл.
Затем прочитайте файл и выведите приветствие пользователю в консоль.
Пример работы:
Входные данные: Имя пользователя Alice.
Выходные данные: В консоль выводится "Hello, Alice!".
 */

public class ReadName {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Tell me your name please");
        String name = scan.nextLine();


        try (FileWriter nameWriter = new FileWriter("fileForName.txt")) {
            for (int i = 0; i < name.length(); i++) {
                nameWriter.write(name.charAt(i));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        try (FileReader nameWriter = new FileReader("fileForName.txt")) {
            System.out.print("Hello, ");
            int character;
            while ((character = nameWriter.read()) != -1) {
                System.out.print((char) character);
            }
        }
    }
}
