
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
Задание 3: Обработка исключений
Напишите метод, который будет пытаться читать несуществующий файл и обрабатывать возможное
исключение FileNotFoundException, выводя сообщение об ошибке в консоль.
Пример работы:
Входные данные: Попытка чтения несуществующего файла nonexistent.txt.
Выходные данные: В консоль выводится сообщение "File not found: nonexistent.txt".
 */

public class NotExistFile extends Exception {
    public static void main(String[] args) {
        try (FileReader reader = new FileReader("notExist.File.txt")) {
            int character;
            while ((character = reader.read()) != -1) {
                System.out.println(character);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File is not found: notExist.File.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
