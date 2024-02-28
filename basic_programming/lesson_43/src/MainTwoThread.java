public class MainTwoThread {

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new MyThread1());
        Thread thread2 = new Thread(new MyThread2());
        thread1.start();
        thread1.join();
        thread2.start();
    }
}
