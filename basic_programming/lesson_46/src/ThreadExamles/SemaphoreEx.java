package ThreadExamles;
import java.util.concurrent.Semaphore;
public class SemaphoreEx {
    /* В классе SemaphoreEx демонстрируется работа синхронизатора Semaphore. Это синхронизатор
     * принимает в конструкторе число потоков, которые согут работать одновременно. Остальные потоки будут ждать,
     * когда предыдущие закончат работу.
     * В этом классе создаются четыре потока - группы студентов, которые должны посетить занятия. Аудиторий всего две.
     * Semaphore ограничивает доступ к аудиториям. Используются два метода этого синхронизатора acquire() - проверяет, если ли
     * свободный доступ к выполнению действий(аудитории). И метод release() освобождает доступ и увеличивает счетчик
     * синхронизатора на единицу, открывая таким образом для других потоков(групп) доступ к выполнению задачи(посещению занятия).
     */

    public void runThreads() {
        Semaphore semaphore = new Semaphore(2);
        Thread thread1 = new Thread(() -> {
            try {
                System.out.println("Студенты 1-й группы ждут, когда аудитория освободится");
                semaphore.acquire();
                System.out.println("Студенты 1-й группы занимаются");
                Thread.sleep(3000);
                System.out.println("Студенты 1-й группы закончили заниматься");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            finally {
                semaphore.release();
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                System.out.println("Студенты 2-й группы ждут, когда аудитория освободится");
                semaphore.acquire();
                System.out.println ("Студенты 2-й группы занимаются");
                Thread.sleep(3000);
                System.out.println ("Студенты 2-й группы закончили заниматься");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            finally {
                semaphore.release();
            }
        });

        Thread thread3 = new Thread(() -> {
            try {
                System.out.println("Студенты 3-й группы ждут, когда аудитория освободится");
                semaphore.acquire();
                System.out.println("Студенты 3-й группы занимаются");
                Thread.sleep(2000);
                System.out.println("Студенты 3-й группы закончили заниматься");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            finally {
                semaphore.release();
            }
        });

        Thread thread4 = new Thread(() -> {
            try {
                System.out.println("Студенты 4-й группы ждут, когда аудитория освободится");
                semaphore.acquire();
                System.out.println("Студенты 4-й группы занимаются");
                Thread.sleep(2000);
                System.out.println("Студенты 4-й группы закончили заниматься");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            finally {
                semaphore.release();
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (
                InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}