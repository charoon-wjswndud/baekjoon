import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N+1][M+1];
		for (int i = 1; i <= N; i++) {
			int sum = 0;
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				sum += Integer.parseInt(st.nextToken());
				arr[i][j] = arr[i-1][j] + sum;
			}
		}

		int tc = Integer.parseInt(br.readLine());
		while (tc-- > 0) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int sum = arr[x][y] - arr[i-1][y] - arr[x][j-1] + arr[i-1][j-1];
			sb.append(sum).append("\n");
		}

		System.out.print(sb);
	}
}
