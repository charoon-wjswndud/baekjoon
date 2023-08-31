import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static Point[] dp = new Point[41];
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while (0 < T--) {
			int N = Integer.parseInt(br.readLine());
			fibo(N);
			sb.append(dp[N].x).append(" ").append(dp[N].y).append("\n");
		}
		System.out.print(sb);
	}

	private static Point fibo(int n) {
		if (n == 0)
			return dp[0] = new Point(1, 0);
		else if(n == 1)
			return dp[1] = new Point(0, 1);
		else if(dp[n] != null)
			return dp[n];
		else  {
			Point p1 = fibo(n-1);
			Point p2 = fibo(n-2);
			return dp[n] = new Point(p1.x + p2.x, p1.y + p2.y);
		}
	}
}
