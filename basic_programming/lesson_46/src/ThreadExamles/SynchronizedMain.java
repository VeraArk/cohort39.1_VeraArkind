package ThreadExamles;
public class SynchronizedMain {

    /* Класс предназначен для запуска многопоточного приложения, в котором потоки работают с общим списком строк.
     * Приложение демонстрирует проблему гонки ресурсов при
     * добавлении элементов в список и предлагает решение с помощью синхронизации.
     */
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Демонстрация гонки ресурсов\n");
        ThreadRace example1 = new ThreadRace();
        example1.runThreads();

        System.out.println("\n Демонстрация синхронизации потоков в методе\n");
        Synchronized example2 = new Synchronized();
        example2.runThreads2();

        System.out.println("\n Демонстрация работы синхронизатора Semaphore\n");
        SemaphoreEx example3 = new SemaphoreEx();
        example3.runThreads();

        System.out.println("\n Демонстрация работы с потокобезопасными коллекциями\n");
        CopyOnWriteArrayListEx example4 = new CopyOnWriteArrayListEx();
        example4.runThreads3();
    }
}
