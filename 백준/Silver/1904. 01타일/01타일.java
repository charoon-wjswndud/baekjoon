import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[1000001];

		dp[1] = 1;
		dp[2] = 2;

		for (int n = 3; n <= N; n++)
			dp[n] = (dp[n -1] + dp[n -2]) % 15746;

		System.out.println(dp[N]);
	}
}
