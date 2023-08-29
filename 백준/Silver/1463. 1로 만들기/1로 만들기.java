import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.acmicpc.net/problem/1463
public class Main {
	static int[][] dp;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[1_000_001];
		dp[1] = 0;
		for (int i = 2; i <= N; i++) {
			if (i%2 != 0 && i%3 != 0)
				dp[i] = dp[i-1]+1;
			else if (i%2 == 0 && i%3 != 0)
				dp[i] = Math.min(dp[i-1], dp[i/2]) + 1;
			else if (i%2 != 0 && i%3 == 0)
				dp[i] = Math.min(dp[i-1], dp[i/3]) + 1;
			else
				dp[i] = Math.min(dp[i-1], Math.min(dp[i/2], dp[i/3])) + 1;
		}
		System.out.println(dp[N]);
	}
}

