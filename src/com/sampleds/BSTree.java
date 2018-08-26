package com.sampleds;

public class BSTree {

    Node root;

    public BSTree() {
        this.root = null;
    }

    private void insert(int data) {
        root = insert(root, data);
    }

    private Node insert(Node root, int data) {
        if (root == null)
            root = new Node(data);
        else {
            if (data <= root.payLoad)
                root.lTree = insert(root.lTree, data);
            else
                root.rTree = insert(root.rTree, data);
        }
        return root;
    }

    private void displayInOrder(Node root) {
        if (root == null)
            return;
        displayInOrder(root.lTree);
        System.out.print(root.payLoad + " ");
        displayInOrder(root.rTree);
    }

    private void displayPreOrder(Node root) {
        if (root == null)
            return;
        System.out.print(root.payLoad + " ");
        displayPreOrder(root.lTree);
        displayPreOrder(root.rTree);
    }

    private void displayPostOrder(Node root) {
        if (root == null)
            return;
        displayPostOrder(root.lTree);
        displayPostOrder(root.rTree);
        System.out.print(root.payLoad + " ");
    }

    private boolean search(int id) {
        Node current = root;
        while (current != null) {
            if (current.payLoad == id) {
                return true;
            } else if (current.payLoad > id) {
                current = current.lTree;
            } else {
                current = current.rTree;
            }
        }
        return false;
    }
    private boolean isValidBST(Node root, int minValue, int maxValue) {
        if (root == null)
            return true;
        if(root.payLoad > minValue && root.payLoad < maxValue && isValidBST(root.lTree,minValue,root.payLoad) && isValidBST(root.rTree, root.payLoad, maxValue))
            return true;
        else
            return false;
    }

    private int getHeightBST(Node root) {
        if(root == null)
            return 0;
        int lHeight = getHeightBST(root.lTree);
        int rHeight = getHeightBST(root.rTree);
        return 1 + Math.max(lHeight,rHeight);
    }

    public static void main(String[] args) {
        BSTree b = new BSTree();
        b.insert(8);
        b.insert(5);
        b.insert(3);
        b.insert(7);
        b.insert(10);
        b.insert(15);
        b.insert(2);
        System.out.println("Original Tree : ");
        b.displayInOrder(b.root);
        System.out.println();
        System.out.println("Pre Order Original Tree : ");
        b.displayPreOrder(b.root);
        System.out.println();
        System.out.println("Post Order Original Tree : ");
        b.displayPostOrder(b.root);
        System.out.println();
        System.out.println("Search for 24");
        System.out.println(b.search(24));
        System.out.println("Search for 15");
        System.out.println(b.search(15));
        System.out.println("Is It a Valid BST? ");
        System.out.println(b.isValidBST(b.root,Integer.MIN_VALUE,Integer.MAX_VALUE));
        System.out.println("height of BST is");
        System.out.println(b.getHeightBST(b.root));
    }


    class Node {
        private int payLoad;
        private Node lTree;
        private Node rTree;

        public Node(int payLoad) {
            this.payLoad = payLoad;
            this.lTree = null;
            this.rTree = null;
        }
    }
}
