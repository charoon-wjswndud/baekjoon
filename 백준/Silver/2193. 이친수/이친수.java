import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] dp = new long[91];

		dp[1] = 1;
		dp[2] = 1;

		for (int n = 3; n <= N; n++)
			dp[n] = dp[n -1] + dp[n -2];

		System.out.println(dp[N]);
	}
}
