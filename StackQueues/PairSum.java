import java.util.*;

public class PairSum {
    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 9;

        HashSet<Integer> set = new HashSet<>();

        for (int num : arr) {
            if (set.contains(target - num)) {
                System.out.println("Pair exists");
                return;
            }
            set.add(num);
        }
        System.out.println("No pair");
    }
}
