package com.skylite.test.sortAlgorithms;

import java.util.Random;

public class MyHashTable {

    private Node[] container;
    private int capacity;

    public MyHashTable() {
        this.capacity = 15;
        this.container = new Node[capacity];
    }

    public void add(Integer key, String value) {
        if (contains(key)) {
            return;
        }
        Node n = new Node(key, value);
        int tableIndex = n.hashCode() % capacity;
        if (container[tableIndex] == null) {
            container[tableIndex] = n;
        } else {
            container[tableIndex].add(n);
        }

    }

    public boolean contains(int key) {
        return this.find(key) != null;
    }

    public String find(int key) {
        Node n = new Node(key, "");
        int tableIndex = n.hashCode() % capacity;

        n = container[tableIndex];
        while (n != null) {
            if (n.getKey() == key) {
                return n.getValue();
            }
            n = n.next;
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node n;
        for (int i = 0; i < container.length; i++) {
            sb.append("index").append(i).append(": ");
            n = container[i];
            while (n != null) {
                sb.append(n.toString()).append(" ");
                n = n.next;
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private class Node {
        private Integer key;
        private String value;
        private Node next;

        public Integer getKey() {
            return key;
        }

        public void setKey() {
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node(Integer key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        public void add(Node n) {
            if (this.next == null) {
                this.next = n;
            } else {
                this.next.add(n);
            }
            Object o = new Object();
        }

        @Override
        public int hashCode() {
            return this.key * 2017;
        }

        @Override
        public String toString() {
            return "[" +
                    "key:" + key +
                    ", value:" + value +
                    ']';
        }

    }
}
