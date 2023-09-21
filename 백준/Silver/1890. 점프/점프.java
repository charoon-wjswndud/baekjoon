import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		long[][] dp = new long[N][N];
		dp[0][0] = 1;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				if (dp[y][x] == 0)
					continue;
				if (y == N-1 && x == N-1)
					break;

				int nx = x + map[y][x];
				if (nx < N)
					dp[y][nx] += dp[y][x];

				int ny = y + map[y][x];
				if (ny < N)
					dp[ny][x] += dp[y][x];

			}
		}
		System.out.println(dp[N-1][N-1]);
	}
}
