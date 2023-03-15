import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];

        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m = 0; m < M; m++) {
                arr[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] sumArr = new int[N+1][M+1];
        for (int n = 1; n < N + 1; n++) {
            for (int m = 1; m < M + 1; m++) {
                sumArr[n][m] = arr[n-1][m-1] + sumArr[n-1][m] + sumArr[n][m-1] - sumArr[n-1][m-1];
            }
        }

        StringBuilder sb = new StringBuilder();
        int K = Integer.parseInt(br.readLine());
        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            sb.append(sumArr[x][y] - sumArr[i-1][y] - sumArr[x][j-1] + sumArr[i-1][j-1]).append("\n");
        }
        System.out.print(sb);
    }
}
