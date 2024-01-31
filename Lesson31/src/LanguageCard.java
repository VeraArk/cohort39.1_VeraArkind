
import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class LanguageCard {
    // Хранилище для слов и их переводов
    private HashMap<String, String> wordMap = new HashMap<>();

    // Создание дополнительной Мар, где будут храниться те же ключи, что и в основной мапе wordMap,
    // а в качестве значения - количество неправильных ответов при практике конкретной пары.

    private static HashMap<String, Integer> wrongAttemptsMap = new HashMap<>();
    // счетчик неправильный попыток, который становится значением второй мапы
    int numberWrongAnswer = 1;

    // Метод для добавления нового слова и его перевода с (!!!!) доработанной частью, которая добавляет
    public void addWord(String foreignWord, String nativeWord) {
        wordMap.put(foreignWord, nativeWord);
    }

    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    // Метод для практики слов
    public void practice() {
        if (wordMap.isEmpty()) {
            System.out.println("Словарь пуст. Пожалуйста, добавьте слова для практики.");
            return;
        }
        // Преобразование ключей мапы в список для удобного доступа
        ArrayList<String> keys = new ArrayList<>(wordMap.keySet());

        // Случайный выбор слова для проверки
        String randomKey = keys.get(random.nextInt(keys.size()));
        String correctAnswer = wordMap.get(randomKey);

        // Задаем вопрос
        System.out.println("Каков перевод слова " + randomKey + "?");
        String userAnswer = scanner.nextLine();

        // Проверка ответа
        if (correctAnswer.equalsIgnoreCase(userAnswer)) {
            System.out.println("Верно!");
            practice();
        } else {
            System.out.println("Неверно! Правильный ответ: " + correctAnswer);
            createListWithWrongAnswer(correctAnswer);
        }

    }

    /// метод для создания новой мапы с неверными ответами, где ключ- слово, значение - число неверных ответов

    public void createListWithWrongAnswer(String correctAnswer) {
        if (!wrongAttemptsMap.containsKey(correctAnswer)) {
            wrongAttemptsMap.put(correctAnswer, numberWrongAnswer);
        } else {
            int wrongAttemptsTempo = wrongAttemptsMap.get(correctAnswer).intValue() + 1;
            wrongAttemptsMap.put(correctAnswer, wrongAttemptsTempo);
        }
        System.out.println("Хотите посмотреть количество неправиьных ответов? Да/нет: ");
        if (scanner.nextLine().equalsIgnoreCase("да")) {
            schowInfoAboutWrongAnswer();
        } else {
            System.out.println("Хотите продолжить заниматься? Да/нет: ");
            if (scanner.nextLine().equalsIgnoreCase("да")) {
                practice();
            }
        }
    }

    // вывод информации о количестве неверных ответов
    void schowInfoAboutWrongAnswer() {
        System.out.println("Результаты неверных ответов в отдельной табліце: " + wrongAttemptsMap);
    }


    public static void main(String[] args) {
        // Пример использования класса LanguageCard
        LanguageCard myCard = new LanguageCard();

        // Добавление слов
        myCard.addWord("apple", "яблоко");
        myCard.addWord("dog", "собака");
        myCard.addWord("hello", "привет");

        // Запуск практики
        myCard.practice();

    }
}




