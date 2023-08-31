import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{
	static int[] dp = new int[11];
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for (int i = 4; i < 11; i++)
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
		while (0 < T--) {
			int N = Integer.parseInt(br.readLine());
			System.out.println(dp[N]);
		}
	}
}
