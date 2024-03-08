package ThreadExamles;
import java.util.ArrayList;

public class Synchronized {

        /*Kласс Synchronized дублирует по логике исполнения ThreadRace, то есть  создаются два потока - группы студентов,
         * которые посещают занятия. Единственное отличие - метод addString в классе SharedStringList1 синхронизирован
         * при помощи ключевого слова synchronized. Поэтому гонки ресрусов не возникает и подсчет посещенных лекций
         * происходит корректно
         */

        public void runThreads2() {
            final SharedStringList2 th = new SharedStringList2();
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

    class SharedStringList2 {
        /*В классе SharedStringList создается список занятий, которые посещают студенты, а также общий счетчик лекций.
         */

        private ArrayList<String> list = new ArrayList<>();

        private int counter = 0;

         public synchronized void addString(String str)
        {
            getList().add(str + "\n");
            counter++;
        }

        /* Метод getList() возвращает список зарегистрированных звонок
         */
        public ArrayList<String> getList() {
            return list;
        }

        public int getCounter() {
            return counter;
        }
    }

