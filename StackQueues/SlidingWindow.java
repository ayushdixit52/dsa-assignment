import java.util.*;

public class SlidingWindow {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;

        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {

            while (!dq.isEmpty() && dq.peek() < i - k + 1)
                dq.poll();

            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i])
                dq.pollLast();

            dq.offer(i);

            if (i >= k - 1)
                System.out.print(nums[dq.peek()] + " ");
        }
    }
}