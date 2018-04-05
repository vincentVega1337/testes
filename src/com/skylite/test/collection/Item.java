package com.skylite.test.collection;

/**
 * Class realise  item object
 * Contains object, and links to next and previous element
 *
 * @author vi.fu.ve.ri.th@gmail.com
 */
public class Item {
    private Object object;

    private Item previous;

    private Item next;

    public Item(Object object) {
        this.object = object;
        previous = null;
        next = null;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public Item getPrevious() {
        return previous;
    }

    public void setPrevious(Item previous) {
        this.previous = previous;
    }

    public Item getNext() {
        return next;
    }

    public void setNext(Item next) {
        this.next = next;
    }
}