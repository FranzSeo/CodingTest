import java.util.*;
public class A4 {
    public static int n, x;
    public static int[] array = new int[250000 + 1];

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        x = scan.nextInt();

        int sum = 0;
        for(int i = 1; i <= n; i++){
            array[i] = scan.nextInt();
            if(i <= x) sum += array[i];
        }
        int max_sum = sum;
        int count = 1;

        int left = 1;
        int right = x;
        while(true){
            left++;
            right++;
            if(right > n) break;
            sum = sum + array[right] - array[left -1];
            if(max_sum == sum){
                count++;
            }
            else if(max_sum < sum){
                max_sum = sum;
                count = 1;
            }
        }
        if(max_sum == 0){
            System.out.println("zero");
        }
        else {
            System.out.println(max_sum);
            System.out.println(count);
        }
    }
}
