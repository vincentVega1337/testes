package com.skylite.test;

import com.skylite.test.collection.FifoStack;

public class Demo {
    public static void main(String[] args) {
        FifoStack fifo = new FifoStack();
        fifo.enqueue("one");
        fifo.enqueue("two");
        fifo.enqueue("three");
        fifo.enqueue("for");
        System.out.println(fifo.toString());
        System.out.println(fifo.dequeue());
        System.out.println(fifo.toString());
    }
}
