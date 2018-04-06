package ua.nure.shylov.Practice2;

import java.util.Iterator;

public class MyListImpl implements MyList {

    private Object[] container;

    private int capacity;

    private int currentSize;

    public MyListImpl() {
        this.capacity = 15;
        this.container = new Object[this.capacity];
        currentSize = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (currentSize == 0) {
            return "{}";
        }
        sb.append("{");
        for (int i = 0; i < currentSize - 1; i++) {
            if (container[i] == null) {
                sb.append("[null], ");
                continue;
            }
            sb.append("[").append(container[i].toString()).append("], ");
        }
        if (currentSize != 0 && container[currentSize - 1] == null) {
            sb.append("[null], ");
        } else {
            sb.append("[").append(container[currentSize - 1].toString()).append("]");
        }
        sb.append("}");
        return sb.toString();
    }

    /**
     * Realise add object to container. Container auto-extend.
     *
     * @param e add object
     */
    @Override
    public void add(Object e) {
        if (currentSize == this.container.length - 1) {
            Object[] newArray = new Object[capacity * 2];
            capacity *= 2;
            System.arraycopy(this.container, 0, newArray, 0, currentSize);
            this.container = newArray;
        }
        container[currentSize++] = e;
    }

    /**
     * Clear current container and set capacity to initial value
     */
    @Override
    public void clear() {
        capacity = 15;
        currentSize = 0;
        this.container = new Object[capacity];
    }

    /**
     * Remove first match with parameter object
     *
     * @param o object that must remove
     * @return result of operation
     */
    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < currentSize; i++) {
            if (container[i] == o) {
                System.arraycopy(container, i + 1, container, i, currentSize - i - 1);
                currentSize--;
                return true;
            }
        }
        return false;
    }

    /**
     * Create new array with current size length
     *
     * @return copy of container
     */
    @Override
    public Object[] toArray() {
        Object[] result = new Object[currentSize];
        System.arraycopy(container, 0, result, 0, currentSize);
        return result;
    }

    /**
     * Return current size of container
     *
     * @return current size
     */
    @Override
    public int size() {
        return currentSize;
    }

    /**
     * Return boolean flag of contains parameter object in collection
     *
     * @param o object to compare
     * @return boolean contains object in parameter
     */
    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < currentSize; i++) {
            if (container[i] == o) {
                return true;
            }
        }
        return false;
    }

    /**
     * Return boolean flag of compare lists
     *
     * @param c list to compare
     * @return boolean flag compare of lists
     */
    @Override
    public boolean containsAll(MyList c) {
        Object[] array = c.toArray();
        for (Object anArray : array) {
            if (!this.contains(anArray)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Create ad returns iterator of collection
     *
     * @return iterator
     */
    @Override
    public Iterator<Object> iterator() {
        return new MyIterator();
    }

    /**
     * Realise iterator for  MyListImpl class
     *
     * @author vi.fu.ve.ri.th@gmail.com
     */
    private class MyIterator implements Iterator<Object> {

        private int iteratorIndex;

        private boolean nextFlag;

        public MyIterator() {
            this.iteratorIndex = -1;
            nextFlag = false;
        }

        @Override
        public boolean hasNext() {
            return iteratorIndex < currentSize - 1;
        }

        @Override
        public Object next() {
            nextFlag = true;
            return container[++iteratorIndex];
        }

        @Override
        public void remove() {
            if (nextFlag) {
                System.arraycopy(container, iteratorIndex + 1, container, iteratorIndex, currentSize - iteratorIndex - 1);
                currentSize--;
                nextFlag = false;
                return;
            }
            throw new IllegalStateException();
        }
    }
}
