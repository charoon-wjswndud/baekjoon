import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (0 < t--) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[2][N];
			int[][] dp = new int[2][N];

			for (int i = 0; i < 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int x = 0; x < N; x++) {
					arr[i][x] = Integer.parseInt(st.nextToken());
				}
			}
			if (N == 1) {
				System.out.println(Math.max(arr[0][0], arr[1][0]));
				continue;
			}

			dp[0][0] = arr[0][0];
			dp[1][0] = arr[1][0];
			dp[0][1] = dp[1][0] + arr[0][1];
			dp[1][1] = dp[0][0] + arr[1][1];
			for (int n = 2; n < N; n++) {
				dp[0][n] = Math.max(dp[1][n - 1], dp[1][n - 2]) + arr[0][n];
				dp[1][n] = Math.max(dp[0][n - 1], dp[0][n - 2]) + arr[1][n];
			}
			sb.append(Math.max(dp[0][N - 1], dp[1][N - 1])).append("\n");
		}
		System.out.print(sb);
	}
}
