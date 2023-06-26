import java.util.*;

public class A3 {
    public static int n, x;
    public static int[] array = new int[500000];

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();
        for(int i = 0; i < n; i++){
            array[i] = scan.nextInt();
        }
        x = scan.nextInt();

        long sum = 0;
        long count = 0;
        for(int i = 0; i < n; i++){
            if(gcd(x, array[i]) == 1){
                sum += array[i];
                count ++;
            }
        }
        System.out.printf("%.6f", (double) sum / count);
    }
    public static long gcd(long x, long y){
        while(y != 0){
            long temp = x % y;
            x = y;
            y = temp;
        }
        return x;
    }
}
