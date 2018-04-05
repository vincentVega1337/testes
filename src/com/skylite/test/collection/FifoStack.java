package com.skylite.test.collection;

/**
 * Class realise FIFO stack with public API
 *
 * @author vi.fu.ve.ri.th@gmail.com
 */
public class FifoStack {

    private Item first;

    private Item last;

    private int currentSize;

    /**
     * Default constructor create empty queue and initialize parameters
     */
    public FifoStack() {
        this.currentSize = 0;
        this.first = null;
        this.last = null;
    }

    /**
     * Method add new item in collection
     *
     * @param object new object in collection
     */
    public void enqueue(Object object) {
        if (isEmpty()) {
            this.first = new Item(object);
            this.last = this.first;
            currentSize++;
            return;
        }
        Item newItem = new Item(object);
        this.last.setNext(newItem);   // Set link with current last and new element
        newItem.setPrevious(this.last); // Set link with current last and new element
        this.last = newItem;    // Set new element as last in queue
        currentSize++;
    }

    /**
     * Get first object in collection and delete it
     *
     * @return First object in collection
     */
    public Object dequeue() {
        if (isEmpty()) {
            return null;
        }
        Item item = this.first;
        this.first = item.getNext();
        currentSize--;
        return item.getObject();
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    int size() {
        return currentSize;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "empty";
        }
        StringBuilder sb = new StringBuilder();
        Item item = this.first;
        while (item != null) {
            sb.append(item.getObject().toString()).append(" ");
            item = item.getNext();
        }
        return sb.toString();
    }




}
