import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{
	static int[] dp = new int[1001];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		if (N < 3)
			System.out.println(N);
		else
			System.out.println(topdown(N));
	}

	private static int topdown(int n) {
		if (n < 3)
			return dp[n] = n;
		else if (dp[n] == 0)
			return dp[n] = (topdown(n-1) + topdown(n-2))%10007;
		else
			return dp[n];
	}
}
