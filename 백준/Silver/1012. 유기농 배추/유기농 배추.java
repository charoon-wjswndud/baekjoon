import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
	static int[][] np = {{1,0},{0,1},{-1,0},{0,-1}};
	static int M, N;
 	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		while (0 < T--) {
			//입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			boolean[][] map = new boolean[N][M];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				map[Y][X] = true;
			}

			int wormNum = 0;
			boolean[][] visited = new boolean[N][M];
			for (int m = 0; m < M; m++) {
				for (int n = 0; n < N; n++) {
					if (map[n][m] && !visited[n][m]) {
						wormNum++;
						bfs(map, visited, n, m);
					}
				}
			}
			sb.append(wormNum).append("\n");
		}
		System.out.print(sb);
	}

	private static void bfs(boolean[][] map, boolean[][] visited, int y, int x) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(x, y));
		visited[y][x] = true;
		while (!queue.isEmpty()) {
			Point p = queue.poll();
			for (int k = 0; k < 4; k++) {
				int nx = p.x + np[k][1];
				int ny = p.y + np[k][0];
				//인덱스 범위 밖 제외
				if (nx < 0 || M <= nx || ny < 0 || N <= ny)
					continue;
				//배추가 없는 곳 제외
				if (!map[ny][nx])
					continue;
				//이미 방문한 곳 제외
				if (visited[ny][nx])
					continue;
				queue.add(new Point(nx, ny));
				visited[ny][nx] = true;
			}
		}
	}
}
