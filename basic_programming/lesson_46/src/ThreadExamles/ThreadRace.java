package ThreadExamles;
import java.util.ArrayList;

public class ThreadRace {
    /* В классе ThreadRace создаются два потока - группы студентов, которые посещают занятия.
     * Потоки НЕ синхронизированы - возникает гонка ресурсов, когда они одновременно пытаются вызвать метод addString, то
     * есть добавить одну из лекций в список посещенных. Этот метод расположен в классе SharedStringList. В этом же методе
     * идет подсчет общего числа лекций, которые посетили обе группы
     */

    public void runThreads() {
        final SharedStringList th = new SharedStringList();
        Thread thread1 = new Thread(() -> {

            System.out.println("Группа 1 начала учиться: ");
            th.addString("Mathe");
            th.addString("Art");
            th.addString("English");
            th.addString("Geo");
            th.addString("Sport");

        });

        Thread thread2 = new Thread(() -> {
            System.out.println("Группа 2 начала учиться: ");
            th.addString("Physic");
            th.addString("Art");
            th.addString("Deutch");
            th.addString("History");
            th.addString("Latein");

        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (
                InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Две группы посетили занятия: "+ th.getList().toString());
        System.out.println("Общее число заниятий, которые посетили две группы: " + th.getCounter());
    }
}

class SharedStringList {

    private ArrayList<String> list = new ArrayList<>();

    private int counter = 0;

    public void addString(String str) {
        getList().add(str + "\n");
        counter++;
    }

    public ArrayList<String> getList() {
        return list;
    }

    public int getCounter() {
        return counter;
    }
}

