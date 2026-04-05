import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        while (a-- > 0) {
            int x = in.nextInt();
            int[] arr = new int[7];
            int sum = 0;
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < 7; i++) {
                arr[i] = in.nextInt();
                sum+=arr[i];
                max = Math.max(max, arr[i]);
            }
            
        }
    }
}
