import java.util.concurrent.locks.ReentrantLock;

public class ThreadSynchronizationExercises {

    /*
     * Задача 1: Демонстрация гонки ресурсов.
     * Создайте два потока, которые инкрементируют общий счетчик 1000 раз каждый.
     */

    public static void main(String[] args) {

        //создаю объект класса, чтобы запустить нестатичный метод raceConditionDemo(), который
        // демонстрирует гонку ресурсов

        ThreadSynchronizationExercises n = new ThreadSynchronizationExercises();
//        n.raceConditionDemo();
//        n.synchronizedSolution();
//        n.lockSolution();
        n.volatileDemo();

    }

    public void raceConditionDemo() {
        final Counter counter = new Counter();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Final counter value (Race Condition): " + counter.value());
    }


    /*
     * Задача 2: Решение гонки ресурсов с использованием synchronized.
     * Модифицируйте Counter так, чтобы инкремент был синхронизирован.
     */
    public void synchronizedSolution() {
        final SynchronizedCounter counter = new SynchronizedCounter();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Final counter value (Race Condition): " + counter.value());
    }

    /*
     * Задача 3: Использование Lock для синхронизации.
     * Используйте ReentrantLock для синхронизации доступа к методу инкремента счетчика.
     */
    public void lockSolution() {
        final LockCounter counter = new LockCounter();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Final counter value (Race Condition): " + counter.value());
    }

    /*
     * Задача 4: Использование volatile для сигнала.
     * Создайте два потока: один устанавливает флаг (volatile переменная), другой ждет изменения флага.
     */
    public void volatileDemo() {
        final Flag flag = new Flag();
        Thread thread1 = new Thread(() -> {
            System.out.println("В магазин завезли хлеб");
            for (int i = 10; i > 0; i--) {
                flag.setFlag(true);
                System.out.println("Хлеб продается");
            }
            System.out.println("Хлеб закончился");
            flag.setFlag(false);
        });

        Thread thread2 = new Thread(() -> {
               if (flag.getFlag()) {
                       System.out.println("В магазине еще есть хлеб. Можно продолжать торговать");
               }
               else {
                   System.out.println("Нужно звонить на хлебзавод, заказывать хлеб");
               }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /*
     * Задача 5: Синхронизация с помощью объектного монитора.
     * Используйте wait() и notify() для управления потоками, где один поток ждет сигнала от другого.
     */
    public void waitNotifyDemo() {
        final Object monitor = new Object();
        // Реализуйте логику с использованием wait() и notify() на объекте monitor
    }

    // Вспомогательные классы для задач
    static class Counter {
        private int count = 0;

        void increment() {
            count++;
        }

        int value() {
            return count;
        }
    }

    static class SynchronizedCounter {
        private int count = 0;

        synchronized void increment() {
            count++;
        }

        int value() {
            return count;
        }
    }

    /**
     * Класс {@code LockCounter} представляет собой пример использования {@link ReentrantLock}
     * для синхронизации доступа к счетчику в многопоточной среде.
     * <p>
     * {@code ReentrantLock} используется для обеспечения взаимоисключающего доступа
     * к методу инкремента {@code count}. Это предотвращает одновременное выполнение
     * метода {@code increment()} несколькими потоками, что могло бы привести к гонке данных
     * и некорректному увеличению счетчика.
     * <p>
     * Принцип работы:
     * <ul>
     *     <li>Перед началом выполнения операции инкремента счетчика поток пытается захватить блокировку,
     *     вызывая метод {@code lock.lock()}.</li>
     *     <li>Если блокировка уже захвачена другим потоком, текущий поток блокируется и ожидает,
     *     пока блокировка освободится.</li>
     *     <li>После захвата блокировки поток выполняет инкремент счетчика.</li>
     *     <li>По завершении операции поток освобождает блокировку, вызывая метод {@code lock.unlock()},
     *     что позволяет другим потокам захватить блокировку и выполнить операцию.</li>
     * </ul>
     * <p>
     * Использование {@code ReentrantLock} вместо синхронизированных методов или блоков кода
     * предоставляет более гибкий контроль над блокировками, включая возможность попытки захвата
     * блокировки с тайм-аутом, работу с условиями ({@code Condition}), а также возможность
     * проверки захвачена ли блокировка и есть ли ожидающие потоки.
     *
     * @see ReentrantLock
     */
    static class LockCounter {
        private final ReentrantLock lock = new ReentrantLock();
        private int count = 0;

        /**
         * Увеличивает счетчик на единицу с гарантией атомарности операции.
         * <p>
         * Блокировка {@code ReentrantLock} обеспечивает, что только один поток может
         * выполнить инкремент счетчика в данный момент времени, предотвращая гонку данных.
         */
        void increment() {
            lock.lock();
            try {
                count++;
            } finally {
                lock.unlock();
            }
        }

        /**
         * Возвращает текущее значение счетчика.
         *
         * @return текущее значение счетчика.
         */
        int value() {
            return count;
        }
    }


    static class Flag {
        private volatile boolean flag = false;

        void setFlag(boolean value) {
            flag = value;
        }

        boolean getFlag() {
            return flag;
        }
    }
}

