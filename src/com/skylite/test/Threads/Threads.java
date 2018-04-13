package com.skylite.test.Threads;

import java.util.concurrent.atomic.AtomicInteger;

public class Threads {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(" Get start already, you fuck!");
        Counter c = new Counter();
        System.out.println("Counter: " + c.getCount());
        for (int i = 0; i < 1000; i++) {
            new Thread(new MyRunnableImpl(c)).start();
        }
        Thread.sleep(3000);
        System.out.println("Counter: " + c.getCount());
    }

}

class MyRunnableImpl implements Runnable {

    Counter counter;

    public MyRunnableImpl(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            this.counter.increase();
        }
    }
}

class Counter {

    private AtomicInteger count;

    public Counter() {
        this.count = new AtomicInteger(0);
    }

    public AtomicInteger getCount() {
        return count;
    }

    public void setCount(AtomicInteger count) {
        this.count = count;
    }

    public void increase() {
        count.incrementAndGet();
    }

}
