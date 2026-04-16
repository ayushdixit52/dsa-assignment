package binarytree;
class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
    }
}

public class Problem4 {

    static Node insert(Node root, int key) {
        if (root == null) return new Node(key);

        if (key < root.data)
            root.left = insert(root.left, key);
        else
            root.right = insert(root.right, key);

        return root;
    }

    static Node findMin(Node root) {
        while (root.left != null)
            root = root.left;
        return root;
    }

    static Node delete(Node root, int key) {
        if (root == null) return null;

        if (key < root.data)
            root.left = delete(root.left, key);
        else if (key > root.data)
            root.right = delete(root.right, key);
        else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            Node min = findMin(root.right);
            root.data = min.data;
            root.right = delete(root.right, min.data);
        }
        return root;
    }

    static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {

        int arr[] = {15, 10, 20, 8, 12, 17, 25};
        Node root = null;

        for (int x : arr)
            root = insert(root, x);

        root = delete(root, 10);
        root = insert(root, 14);
        root = insert(root, 9);

        inorder(root);
    }
}
