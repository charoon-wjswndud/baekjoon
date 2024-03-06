import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j*(j+1)*(j+2)/6 <= i; j++) {
                int cannonballs = j*(j+1)*(j+2)/6;

                if (cannonballs <= i) {
                    dp[i] = Math.min(dp[i], dp[i-cannonballs] + 1);
                }
            }
        }

        System.out.println(dp[N]);
    }
}

