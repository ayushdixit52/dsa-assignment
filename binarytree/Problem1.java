package binarytree;

class Node {
    String data;
    Node left, right;

    Node(String data) {
        this.data = data;
        left = right = null;
    }
}

public class Problem1 {

    static int height(Node root) {
        if (root == null) return -1;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    static int findDepth(Node root, String key, int depth) {
        if (root == null) return -1;

        if (root.data.equals(key))
            return depth;

        int left = findDepth(root.left, key, depth + 1);
        if (left != -1) return left;

        return findDepth(root.right, key, depth + 1);
    }

    static void printLeaves(Node root) {
        if (root == null) return;

        if (root.left == null && root.right == null)
            System.out.println(root.data);

        printLeaves(root.left);
        printLeaves(root.right);
    }

    public static void main(String[] args) {

        Node CEO = new Node("CEO");
        CEO.left = new Node("CTO");
        CEO.right = new Node("CFO");

        CEO.left.left = new Node("Dev Lead");
        CEO.right.right = new Node("HR");

        CEO.left.left.left = new Node("Dev1");
        CEO.left.left.right = new Node("Dev2");

        printLeaves(CEO);
        System.out.println(height(CEO));
        System.out.println(findDepth(CEO, "Dev Lead", 0));
    }
}
