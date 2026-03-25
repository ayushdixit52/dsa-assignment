public class CircularTour {
    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int[] dist = {6, 5, 3, 5};

        int start = 0, balance = 0, deficit = 0;

        for (int i = 0; i < petrol.length; i++) {
            balance += petrol[i] - dist[i];

            if (balance < 0) {
                start = i + 1;
                deficit += balance;
                balance = 0;
            }
        }

        if (balance + deficit >= 0)
            System.out.println("Start at index: " + start);
        else
            System.out.println("Not possible");
    }
}
