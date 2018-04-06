package com.skylite.test.binaryTrees;

public class BinaryTree {

    private Node root;

    public BinaryTree(int key, String value) {
        this.root = new Node(key, value);
    }

    public void add(int key, String value) {
        this.root.add(new Node(key, value));
    }

    public String findValueByKey(int key) {
        return root.findValueByKey(key);
    }

    @Override
    public String toString() {
        return this.root.toString();
    }


    private class Node implements Comparable<Node> {
        private Node left;
        private Node right;
        private int key;
        private String value;

        private Node(int key, String value) {
            this.key = key;
            this.value = value;
            this.right = null;
            this.left = null;
        }

        @Override
        public int compareTo(Node o) {
            if (this.key - o.getKey() < 0) {
                return -1;
            } else if (this.key - o.getKey() > 0) {
                return 1;
            }
            return 0;
        }

        private String findValueByKey(int key) {
            Node n = new Node(key, null);
            switch (this.compareTo(n)) {
                case -1: {
                    if (this.left == null) {
                        return null;
                    } else {
                        return this.left.findValueByKey(key);
                    }
                }
                case 0: {
                    return this.getValue();
                }
                case 1: {
                    if (this.right == null) {
                        return null;
                    } else {
                        return this.right.findValueByKey(key);
                    }
                }
            }
            return null;
        }

        private void add(Node node) {
            switch (this.compareTo(node)) {
                case -1: {
                    if (this.left == null) {
                        this.left = node;
                    } else {
                        this.left.add(node);
                    }
                    break;
                }
                case 0: {
                    this.setValue(node.getValue());
                    break;
                }
                case 1: {
                    if (this.right == null) {
                        this.right = node;
                    } else {
                        this.right.add(node);
                    }
                    break;
                }
            }
        }

        ////Setters and getters
        //////////////////////////////////////////

        //////////////////////////////////////////

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

        private int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        private String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[").append(this.getKey()).append(":").append(this.getValue()).append("]");

            if (this.left != null) {
                sb.append(this.left.toString());
            }
            if (this.right != null) {
                sb.append(this.right.toString());
            }

            return sb.toString();
        }
    }
}




