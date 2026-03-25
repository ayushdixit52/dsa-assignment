public class CustomHashMap {

    static class Node {
        int key, value;
        Node next;
        Node(int k, int v) { key = k; value = v; }
    }

    static Node[] table = new Node[10];

    static int hash(int key) {
        return key % 10;
    }

    static void put(int key, int value) {
        int i = hash(key);
        Node newNode = new Node(key, value);
        newNode.next = table[i];
        table[i] = newNode;
    }

    static int get(int key) {
        int i = hash(key);
        Node head = table[i];

        while (head != null) {
            if (head.key == key) return head.value;
            head = head.next;
        }
        return -1;
    }

    public static void main(String[] args) {
        put(1, 10);
        put(2, 20);
        System.out.println(get(1));
    }
}