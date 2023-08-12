import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			initDp(k, n);
			calcHuman(k, n-1);
			System.out.println(dp[k][n-1]);
		}
	}

	private static void initDp(int k, int n) {
		dp = new int[k+1][n];
		for (int i = 0; i < k+1; i++)
			dp[i][0] = 1;
		for (int i = 0; i < n; i++)
			dp[0][i] = i+1;
	}

	private static int calcHuman(int k, int n) {
		if (dp[k][n] == 0)
			dp[k][n] = calcHuman(k,n-1) + calcHuman(k-1, n);
		return dp[k][n];
	}
}
/*
2 1|4|10
1 1|3|6
0 1|2|3
 */
