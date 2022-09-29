import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    final static int COLOR = 3;
    final static int RED = 0;
    final static int GREEN = 1;
    final static int BLUE = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine())+1;

        //cost배열 입력
        int[][] cost = new int[N][COLOR];
        for (int n = 1; n < N; n++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int color = 0; color < COLOR; color++){
                cost[n][color] = Integer.parseInt(st.nextToken());
            }
        }

        //dp배열 딥카피
        int[][] dp = new int[N][COLOR];
        for (int row = 1; row < N; row++) {
            dp[row] = cost[row].clone();
        }

        for (int n = 2; n < N; n++) {
            dp[n][RED] = Math.min(dp[n-1][GREEN], dp[n-1][BLUE]) + dp[n][RED];
            dp[n][GREEN] = Math.min(dp[n-1][RED], dp[n-1][BLUE]) + dp[n][GREEN];
            dp[n][BLUE] = Math.min(dp[n-1][GREEN], dp[n-1][RED]) + dp[n][BLUE];
        }
        int minCost = Math.min(Math.min(dp[N-1][RED], dp[N-1][GREEN]), dp[N-1][BLUE]);
        System.out.println(minCost);

    }
}
