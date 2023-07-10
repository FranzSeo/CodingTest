package BOJ1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int M;
    private static int N;
    private static int K;
    private static int[][] farm;
    private static boolean[][] isVisit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String[] temp = br.readLine().split(" ");

            M = Integer.parseInt(temp[0]);
            N = Integer.parseInt(temp[1]);
            K = Integer.parseInt(temp[2]);

            farm = new int[M][N];
            isVisit = new boolean[M][N];

            int worms = 0;

            for (int j = 0; j < K; j++) {
                temp = br.readLine().split(" ");

                int x = Integer.parseInt(temp[0]);
                int y = Integer.parseInt(temp[1]);

                farm[x][y] = 1;
            }

            for (int l = 0; l < N; l++) {
                for (int k = 0; k < M; k++) {
                    if (farm[k][l] == 1 && !isVisit[k][l]) {
                        worms++;

                        dfs(k, l);
                    }
                }
            }
            System.out.println(worms);
        }
        br.close();
    }

    private static void dfs(int x, int y) {
        int[] dirX = {0, 0, -1, 1};
        int[] dirY = {-1, 1, 0, 0};

        isVisit[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int xn = x + dirX[i];
            int yn = y + dirY[i];

            if ((xn > -1 && xn < M) && (yn > -1 && yn < N) && farm[xn][yn] == 1 && !isVisit[xn][yn]) {
                dfs(xn, yn);
            }
        }
    }
}
