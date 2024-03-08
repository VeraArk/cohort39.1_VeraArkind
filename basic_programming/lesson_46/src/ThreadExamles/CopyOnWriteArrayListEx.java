package ThreadExamles;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListEx {

    /*
     * Задача класса CopyOnWriteArrayListEx продемонстрировать работу класса CopyOnWriteArrayList.
     * CopyOnWriteArrayList является потокобезоспаным вариантом коллекции ArrayList. Этот класс позволяет
     * создавать отдельные копии базовой структуры для каждой операции (записи, добавления, удаления). При этом
     * копия затем становится доступной для чтения всеми потоками. ВАЖНО: использовать это класс рационально, когда
     * количество операций по изменению элементов небольшое. А больше операций, связанных с чтением.
     * Это требование связано с тем, что при изменении элемента коллекции создается новая копия коллекции, а это снижает
     * производительность.
     * В данном примере созданы два потока, которые используют потокобезопасную коллекцию CopyOnWriteArrayList. Один при
     * помощи итератора выводит на экран расписание уроков на день. Второй - вносит актуальные изменения. При одновременной
     * работе первый поток продолжит работу с изначальным вариантом листа.
     */

    public void runThreads3() throws InterruptedException {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("Mathe");
        list.add("Art");
        list.add("English");
        list.add("Geo");
        list.add("Sport");

        Thread thread1 = new Thread(() -> {
            Iterator<String> iterator = list.iterator();
            System.out.println("Расписание предметов на день по плану: ");
            while (iterator.hasNext()) {
                try {
                    Thread.sleep(500);
                    System.out.println(iterator.next());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread thread2 = new Thread(() ->  {
            try {
                Thread.sleep(2000);
                list.remove(3);
                list.add(3, "Musik");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
        System.out.println("В расписание внесли изменения. Теперь план на день выглядит так: " + list);

    }
}
