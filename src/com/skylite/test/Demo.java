package com.skylite.test;

import com.skylite.test.collection.FifoStack;
import com.skylite.test.collection.LifoStack;

public class Demo {
    public static void main(String[] args) {
//        FIFODemo();
        LIFODemo();
    }

    private static void FIFODemo() {
        FifoStack fifo = new FifoStack();
        fifo.enqueue("one");
        fifo.enqueue("two");
        fifo.enqueue("three");
        fifo.enqueue("for");
        System.out.println(fifo.toString());
        System.out.println(fifo.dequeue());
        System.out.println(fifo.toString());
    }

    private static void LIFODemo() {
        LifoStack lifo = new LifoStack();
        lifo.push("one");
        lifo.push("two");
        lifo.push("three");
        lifo.push("for");
        System.out.println(lifo.toString());
        System.out.println(lifo.pop());
        System.out.println(lifo.toString());
    }
}
