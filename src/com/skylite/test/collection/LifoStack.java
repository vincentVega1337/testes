package com.skylite.test.collection;

public class LifoStack {

    private int currentSize;

    private Item last;

    public LifoStack() {
        this.currentSize = 0;
        this.last = null;
    }

    public void push(Object object) {
        if (isEmpty()) {
            this.last = new Item(object);
            currentSize++;
            return;
        }
        Item newItem = new Item(object);
        this.last.setNext(newItem);   // Set link with current last and new element
        newItem.setPrevious(this.last); // Set link with current last and new element
        this.last = newItem;    // Set new element as last in queue
        currentSize++;
    }

    public Object pop() {
        Object result = this.last.getObject();
        this.last = this.last.getPrevious();
        currentSize--;
        return result;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public int size() {
        return currentSize;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (isEmpty()) {
            return "empty";
        }
        Item currentItem = this.last;
        while (currentItem != null) {
            sb.append(currentItem.getObject().toString()).append(" ");
            currentItem = currentItem.getPrevious();
        }
        return sb.toString();
    }
}
