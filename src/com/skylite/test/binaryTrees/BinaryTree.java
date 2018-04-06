package com.skylite.test.binaryTrees;

public class BinaryTree {



    private class Node implements Comparable<Node>{
        private Node left;
        private Node right;
        private int key;
        private String value;

        @Override
        public int compareTo(Node o) {
            return o.getKey() - this.key;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
