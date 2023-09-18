import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static Iceberg[][] map;
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new Iceberg[N][M];
		Queue<Iceberg> queue = new LinkedList<>();
		for (int y = 0; y < N; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < M; x++) {
				int num = Integer.parseInt(st.nextToken());
				if (num != 0){
					map[y][x] = new Iceberg(x, y, num);
					queue.add(map[y][x]);
				}
			}
		}

		int day = 0;
		while (!queue.isEmpty()) {
			for (Iceberg iceberg : queue)
				iceberg.melt(iceberg.cntSurface());
			day++;

			int queueSize = queue.size();
			for (int i = 0; i < queueSize; i++) {
				Iceberg iceberg = queue.poll();
				if (iceberg.height <= 0)
					map[iceberg.y][iceberg.x] = null;
				else
					queue.add(iceberg);
			}
			if (queue.isEmpty())
				break;
			boolean[][] visited = new boolean[N][M];
			int link = bfs(visited, queue.peek().getLocation());

			if (link != queue.size())
				break;
		}
		if (queue.isEmpty())
			System.out.println(0);
		else
			System.out.println(day);
	}

	private static int bfs(boolean[][] visited, Point point) {
		int[][] nd = {{0,1},{1,0},{0,-1},{-1,0}};
		int cnt = 0;
		Queue<Point> queue = new LinkedList<>();
		queue.add(point);
		visited[point.y][point.x] = true;
		while (!queue.isEmpty()) {
			Point now = queue.poll();
			cnt++;
			for (int i = 0; i < 4; i++) {
				int ny = now.y + nd[i][0];
				int nx = now.x + nd[i][1];
				if (ny < 0 || N <= ny || nx <0 || M <= nx)
					continue;
				if (map[ny][nx] == null)
					continue;
				if (visited[ny][nx])
					continue;
				queue.add(new Point(nx, ny));
				visited[ny][nx] = true;
			}
		}
		return cnt;
	}

	private static class Iceberg extends Point {
		static int[][] nd = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
		int height;

		public Iceberg(int x, int y, int height) {
			super(x, y);
			this.height = height;
		}

		public void melt(int serface) {
			height -= serface;
		}

		public int cntSurface() {
			int cnt = 0;
			for (int i = 0; i < 4; i++) {
				int ny = y + nd[i][0];
				int nx = x + nd[i][1];
				if (ny < 0 || N <= ny || nx < 0 || M <= nx)
					continue;
				if (map[ny][nx] == null)
					cnt++;
			}
			return cnt;
		}
	}
}
