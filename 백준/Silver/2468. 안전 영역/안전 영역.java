import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		int max = 0;
		for (int y = 0; y < N; y++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int x = 0; x < N; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
				max = Math.max(max, map[y][x]);
			}
		}
		int maxSafeArea = Integer.MIN_VALUE;
		for (int r = 0; r <= max; r++) {
			int cnt = 0;
			boolean[][] visited = new boolean[N][N];
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < N; x++) {
					if (r < map[y][x] && !visited[y][x]){
						bfs(visited, r, new Point(x, y));
						cnt++;
					}
				}
			}
			maxSafeArea = Math.max(maxSafeArea, cnt);
		}
		System.out.println(maxSafeArea);
	}

	private static void bfs(boolean[][] visited, int r, Point point) {
		int[][] nd = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
		Queue<Point> queue = new LinkedList<>();
		queue.add(point);
		visited[point.y][point.x] = true;
		while (!queue.isEmpty()) {
			Point now = queue.poll();
			for (int i = 0; i < 4; i++) {
				int ny = now.y + nd[i][0];
				int nx = now.x + nd[i][1];
				if (ny < 0 || N <= ny || nx < 0 || N <= nx)
					continue;
				if (visited[ny][nx])
					continue;
				if (map[ny][nx] <= r)
					continue;
				queue.add(new Point(nx, ny));
				visited[ny][nx] = true;
			}
		}
	}
}
