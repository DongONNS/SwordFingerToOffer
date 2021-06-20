package edu.csu.DataStructure.tree;

import javax.swing.*;

public class RedBlackBST<Key extends Comparable<Key>,Value> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;

    private class Node{
        private Key key;
        private Value value;
        private Node left,right;
        private boolean color;
        private int size;

        private Node(Key key, Value value,boolean color,int size){
            this.key = key;
            this.value = value;
            this.color = color;
            this.size = size;
        }

        private boolean isRed(Node node){
            if (node == null) return false;
            return node.color;
        }

        private int size(Node node){
            if(node == null) return 0;
            return node.size;
        }

        public int size(){
            return size(root);
        }

        public boolean isEmpty(){
            return root == null;
        }

        public Value get(Key key){
            if (key == null) {
                throw new IllegalArgumentException();
            }
            return get(root,key);
        }

        private Value get(Node node,Key key){
            while(node != null){
                int cmp = key.compareTo(node.key);
                if (cmp > 0){
                    node = node.left;
                }else if(cmp < 0){
                    node = node.right;
                }else {
                    return node.value;
                }
            }
            return null;
        }

        public boolean contains(Key key){
            return get(key) != null;
        }

        public void put(Key key,Value value){
            if (key == null) throw new IllegalArgumentException();
            if (value == null){
                delete(key);
                return;
            }

            root = put(root,key,value);
            root.color = BLACK;
        }

        public Node put(Node h,Key key,Value value){
            if (h == null){
                return new Node(key,value,RED,1);
            }

            int cmp = key.compareTo(h.key);

            if (cmp > 0) put(h.right,key,value);
            else if (cmp < 0) put(h.left,key,value);
            else h.value = value;

            // 调整产生的红色右链接
            if (isRed(h.right) && !isRed(h.left)) rotateLeft(h);
            if (isRed(h.left) && isRed(h.left.left)) rotateRight(h);
            if (isRed(h.left) && isRed(h.right)) flipColors(h);
            h.size = size(h.left) + size(h.right) + 1;

            return h;
        }

        public void delete(Key key){
            if (key == null){
                throw new IllegalArgumentException();
            }
            if (contains(key)) return;
            if (!isRed(root.left) && !isRed(root.right)){
                root.color = RED;
            }
            delete(root,key);
            if (!isEmpty()) root.color = BLACK;
        }



        private Node delete(Node h,Key key){
            // 待删除节点在h的左侧
            if (key.compareTo(h.key) < 0){
                if (isRed(h.left) && isRed(h.left.left)){
                    moveRedLeft(h);
                }
                h.left = delete(h.left,key);
            // 待删除节点为h或者在h的右侧
            } else {
                if(isRed(h.left)){
                    h = rotateRight(h);
                }
                if (key.compareTo(h.key) == 0 && (h.right == null)){
                    return null;
                }
                if (!isRed(h.right) && !isRed(h.right.left)){
                    moveRedRight(h);
                }
                if (key.compareTo(h.key) == 0){
                    Node x = min(h.right);
                    h.key =x.key;
                    h.value = x.value;
                    h.right = deleteMin(h.right);
                }else {
                    h.right = delete(h.right,key);
                }
            }
            return balance(h);
        }

        private Node deleteMin(Node x){
            if (x.left == null) return null;
            if (!isRed(x.left) && !isRed(x.left.left)){
                x = moveRedLeft(x);
            }
            x.left = deleteMin(x.left);
            return balance(x);
        }

        private Node balance(Node h){
            if (isRed(h.right) && !isRed(h.left)) rotateLeft(h);
            if (isRed(h.left) && isRed(h.left.left)) rotateRight(h);
            if (isRed(h.left) && isRed(h.right)) flipColors(h);

            h.size = size(h.left) + size(h.right) + 1;
            return h;
        }

        private Node min(Node x){
            if (x.left == null) return x;
            return min(x.left);
        }

        /**
         * 假定h为红节点，并且h的左孩子及左孙子都是黑节点，使h的左孩子或者左孩子的节点为红节点
         * @param h
         * @return
         */
        private Node moveRedLeft(Node h){
            flipColors(h);
            if (isRed(h.right.left)){
                rotateRight(h.right);
                rotateLeft(h);
                flipColors(h);
            }
            return h;
        }

        /**
         * 假定h为红节点并且h的右孩子及h右孩子的左孩子为黑节点，使h的右孩子或者右孩子的孩子节点为红节点
         * @param h
         * @return
         */
        private Node moveRedRight(Node h){
            flipColors(h);
            if (isRed(h.left.left)){
                h = rotateRight(h);
                flipColors(h);
            }
            return h;
        }


        /**
         * 把h的红色右链接转换位红色左连接
         * @param h
         * @return
         */
        private Node rotateLeft(Node h){
            Node x = h.right;

            h.right = x.left;
            x.left = h;

            x.color = x.left.color;
            x.left.color = RED;

            x.size = h.size;
            h.size = size(h.left) + size(h.right) + 1;

            return x;
        }

        /**
         * 把红色左链接转换位右链接
         * @param h
         */
        private Node rotateRight(Node h){
            Node x = h.left;

            h.left = x.right;
            x.right = h;

            x.color = x.right.color;
            x.right.color = RED;

            x.size = h.size;
            h.size = size(h.left) + size(h.right) + 1;

            return x;
        }

        private void flipColors(Node h){
            h.color = !h.color;
            h.left.color = !h.left.color;
            h.right.color = !h.right.color;
        }
    }
}
