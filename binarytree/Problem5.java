package binarytree;

class Node {
    String data;
    Node left, right;

    Node(String data) {
        this.data = data;
    }
}

public class Problem5 {

    static void inorder(Node root) {
        if (root == null) return;
        System.out.print("(");
        inorder(root.left);
        System.out.print(root.data);
        inorder(root.right);
        System.out.print(")");
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

        Node root = new Node("*");
        root.left = new Node("+");
        root.right = new Node("-");

        root.left.left = new Node("3");
        root.left.right = new Node("5");

        root.right.left = new Node("8");
        root.right.right = new Node("2");

        inorder(root);
        System.out.println();
        preorder(root);
        System.out.println();
        postorder(root);
    }
}
