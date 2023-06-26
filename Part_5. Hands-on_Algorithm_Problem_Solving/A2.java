import java.util.*;

public class A2 {
    // 배열의 길이 -> 입력받을 숫자의 갯수 N
    public static int n; 
    // 정적 메모리에 넣는 것이 옳바른 것인가? 찾아보기 !!!
    public static Scanner scan;

    public static void main(String[] args) {
        scan = new Scanner(System.in);

        n = scan.nextInt();
        long answer = 0;
        for (int i = 0; i < n; i++){
            long data;
            data = scan.nextInt();
            if(isPrimeNumber(data)){
                answer = lcm(answer, data);
            }
        }
        if(answer == 1) System.out.println(-1);
        else System.out.println(answer);

    }

    public static boolean isPrimeNumber(long data){
        for(long i = 2; i<=Math.sqrt(data); i++){
            if(data % 1 == 0){
                return false;
            }
        }
        return true;
    }
    // 최소 공배수 
    public static long gcd(long x, long y){
        while(y != 0){
            long temp = x % y;
            x = y;
            y = temp;
        }
        return x;
    }
    // 최대 공배수
    public static long lcm(long x, long y){
        return x / gcd(x, y) * y;
    }
}
