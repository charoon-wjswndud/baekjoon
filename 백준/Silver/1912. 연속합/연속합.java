import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        int[] dp = new int[100_001];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++)
            dp[i] = arr[i] = Integer.parseInt(st.nextToken());

        for (int i = 2; i <= n; i++)
            dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++)
            max = Math.max(max, dp[i]);

        System.out.println(max);
    }
}