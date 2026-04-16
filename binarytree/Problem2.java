package binarytree;

class Node {
    String data;
    Node left, right;

    Node(String data) {
        this.data = data;
    }
}

public class Problem2 {

    static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    static void preorder(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    static void postorder(Node root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {

        Node root = new Node("root");
        root.left = new Node("home");
        root.right = new Node("var");

        root.left.left = new Node("user");
        root.left.right = new Node("docs");

        root.left.left.left = new Node("config");
        root.right.right = new Node("log");

        inorder(root);
        System.out.println();
        preorder(root);
        System.out.println();
        postorder(root);
    }
}
