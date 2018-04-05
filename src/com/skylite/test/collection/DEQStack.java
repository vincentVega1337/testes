package com.skylite.test.collection;

public class DEQStack {

    private int currentSize;

    private Item left;

    private Item right;

    public DEQStack() {
        this.currentSize = 0;
        this.left = null;
        right = null;
    }

    public void pushLeft(Object object){
        Item item = new Item(object);
        if(isEmpty()){
            this.left = item;
            this.right = item;
            currentSize++;
            return;
        }
        item.setNext(this.left);
        this.left.setPrevious(item);
        this.left = item;
        currentSize++;
    }

    public void pushRight(Object object){
        Item item = new Item(object);
        if(isEmpty()){
            this.left = item;
            this.right = item;
            currentSize++;
            return;
        }
        item.setPrevious(this.right);
        this.right.setNext(item);
        this.right = item;
        currentSize++;
    }

    public boolean isEmpty(){
        return currentSize == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if(isEmpty()){
            return "empty";
        }
        Item currentItem = this.left;
        while (currentItem != null){
            sb.append(currentItem.getObject().toString()).append(" ");
            currentItem = currentItem.getNext();
        }
        return sb.toString();
    }
}
