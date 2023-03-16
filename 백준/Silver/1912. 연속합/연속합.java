import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        dp[0] = arr[0] = Integer.parseInt(st.nextToken());
        int max = Integer.MIN_VALUE;
        max = Math.max(max, dp[0]);
        for (int n = 1; n < N; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
            dp[n] = Math.max(dp[n-1] + arr[n], arr[n]);
            max = Math.max(max, dp[n]);
        }
        System.out.print(max);
    }
}