import java.util.*;

public class SortStack {

    static void sortStack(Stack<Integer> st) {
        if (st.isEmpty()) return;
        int x = st.pop();
        sortStack(st);
        insert(st, x);
    }

    static void insert(Stack<Integer> st, int x) {
        if (st.isEmpty() || st.peek() <= x) {
            st.push(x);
            return;
        }
        int temp = st.pop();
        insert(st, x);
        st.push(temp);
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(3); st.push(1); st.push(2);

        sortStack(st);
        System.out.println(st);
    }
}
