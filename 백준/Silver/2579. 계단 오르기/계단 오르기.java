import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] scores = new int[N];
		for (int i = 0; i < N; i++)
			scores[i] = Integer.parseInt(br.readLine());

		if (N == 1)
			System.out.println(scores[0]);
		else if (N == 2)
			System.out.println(scores[0] + scores[1]);
		else {
			int[] dp = new int[N];
			dp[0] = scores[0];
			dp[1] = Math.max(scores[0] + scores[1], scores[1]);
			dp[2] = Math.max(scores[0] + scores[2], scores[1] + scores[2]);
			for (int i = 3; i < N; i++)
				dp[i] = Math.max(scores[i - 1] + dp[i - 3] + scores[i], dp[i - 2] + scores[i]);
			System.out.println(dp[N-1]);
		}
	}
}
