import java.util.*;

public class StockSpan {
    public static void main(String[] args) {
        int[] price = {100, 80, 60, 70, 60, 75, 85};
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < price.length; i++) {
            while (!st.isEmpty() && price[st.peek()] <= price[i]) {
                st.pop();
            }

            int span = st.isEmpty() ? i + 1 : i - st.peek();
            System.out.print(span + " ");
            st.push(i);
        }
    }
}
