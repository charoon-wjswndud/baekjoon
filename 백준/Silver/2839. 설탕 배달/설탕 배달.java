import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] dp = new int[50001];
		dp[3] = 1;
		dp[5] = 1;

		for (int i = 6; i <= N; i++) {
			if (i % 5 == 0)
				dp[i] = dp[i-5]+1;
			else if (i % 3 == 0)
				dp[i] = dp[i-3]+1;
			else
				if (dp[i-5] != 0 && dp[i-3] != 0)
					dp[i] = Math.max(dp[i-3], dp[i-5])+1;
		}
		System.out.println(dp[N]!=0?dp[N]:"-1");
	}
}
