
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[][] connect = new boolean[N+1][N+1];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++)
				connect[i][j] = st.nextToken().equals("1");
		}

		for (int i = 1; i <= N; i++) {
			for (int y = 1; y <= N; y++) {
				for (int x = 0; x <= N; x++) {
					if (connect[y][i] && connect[i][x])
						connect[y][x] = true;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				sb.append(connect[i][j]?1:0).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
