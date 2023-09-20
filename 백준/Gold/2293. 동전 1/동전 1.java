import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] coins = new int[N];

		for (int n = 0; n < N; n++)
			coins[n] = Integer.parseInt(br.readLine());


		int[] dp = new int[K + 1];
		dp[0] = 1;

		for (int n = 0; n < N; n++)
			for (int j = coins[n]; j <= K; j++)
				dp[j] += dp[j - coins[n]];

		System.out.println(dp[K]);
	}
}
