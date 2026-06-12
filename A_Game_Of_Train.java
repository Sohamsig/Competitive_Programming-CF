import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            int minH = Integer.MAX_VALUE;
            int maxH = Integer.MIN_VALUE;

            for (int i = 0; i < n; i++) {
                int h = sc.nextInt();
                minH = Math.min(minH, h);
                maxH = Math.max(maxH, h);
            }

            System.out.println(maxH - minH + 1);
        }

        sc.close();
    }
}
