import java.util.*;

public class A1{
    public static int n, m;

    // 4000개 만큼
    public static int[] array = new int[4000];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        // n개의 배열
        for(int i = 1; i < n; i++){
            array[i] = scan.nextInt();
        }

        // m개 만큼의 명령어 처리
        for(int i = 1; i <= n; i++){
            int command, from, to;
            command = sc.nextInt();
            from = sc.nextInt();
            to = sc.nextInt();
            ballSwitch(command, from, to);
        }
    }

    public static void ballSwitch(int command, int from, int to){
        // 1번 명령어 -> 상태변경
        if(command == 1){
            array[from] = to;
        }
        // 2번 명령어 -> 전구의 상태 스위칭
        else if(command == 2){
            for(int i = from; i <= to; i++){
                if(array[i] == 0) array[i] = 1;
                else array[i] = 0;
            }
        }
        // 3번 명령어 -> 전구 off
        else if(command == 3){
            for(int i = from; i <= to; i++){
                array[i] = 0;
            }
        }
        // 4번 명령어 -> 전구 on
        else if(command == 4){
            for(int i = from; i <= to; i++){
            array[i] = 0;
            }
        }
    }
}