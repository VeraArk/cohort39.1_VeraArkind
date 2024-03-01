public class ThreadName implements Runnable{
    /*
Создайте несколько потоков (не менее трех), присвойте им осмысленные имена и различные приоритеты. Реализуйте в этих потоках бесконечные циклы, в которых потоки выводят свое имя и приоритет.

Пример вывода
Thread-1, Priority: 5 Thread-2, Priority: 3 Thread-3, Priority: 8
     */



    @Override
    public void run() {
     while (true){
         if (Thread.currentThread().isInterrupted()) {
             System.out.println("Поток " + Thread.currentThread().getName() + " хотят прервать. Он останавливает работу");
             return;
         }
         System.out.println("Работает поток с именем " + Thread.currentThread().getName() + ". Его приоритет " +
                 Thread.currentThread().getPriority());
         }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1= new Thread(new ThreadName());
        Thread thread2= new Thread(new ThreadName());
        Thread thread3= new Thread(new ThreadName());

        thread1.setPriority(Thread.MIN_PRIORITY);
        thread1.setName("First");
        thread2.setPriority(Thread.NORM_PRIORITY);
        thread2.setName("Second");
        thread3.setPriority(Thread.MAX_PRIORITY);
        thread3.setName("Third");
        thread1.start();
        thread2.start();
        thread3.start();

        Thread.sleep(1000);

        System.out.println("\n Main подождал, и теперь остановит потоки\n");
        thread1.interrupt();
        thread2.interrupt();
        thread3.interrupt();
    }

}
