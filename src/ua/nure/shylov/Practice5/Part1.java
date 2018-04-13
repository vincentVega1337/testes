package ua.nure.shylov.Practice5;

public class Part1 {

    public static void main(String[] args) throws InterruptedException {
        ThreadExtend te = new ThreadExtend();
        te.start();

        te.join();

        Thread t1 = new Thread(new ThreadImpl());
        t1.start();
        t1.join();
    }


}

class ThreadExtend extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

class ThreadImpl implements Runnable {
    @Override
    public void run() {
        ThreadExtend te = new ThreadExtend();
        te.run();
    }
}
