import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N;
	static int[][] paper;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		paper = new int[N][N];

		for (int i = 0; i < N; i++) {
			char[] line = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				if (line[j] == 'R')
					paper[i][j] = 0;
				else if (line[j] == 'G')
					paper[i][j] = 1;
				else
					paper[i][j] = 2;
			}
		}

		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		//적록색약이 아닌 사람
		boolean[][] visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j])
					continue;
				bfs(visited, i, j, false);
				cnt++;
			}
		}
		sb.append(cnt).append(" ");

		//적록색약인 사람
		cnt = 0;
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j])
					continue;
				bfs(visited, i, j, true);
				cnt++;
			}
		}
		sb.append(cnt);

		System.out.println(sb);
	}

	private static void bfs(boolean[][] visited, int y, int x, boolean dyschromatopsia) {
		int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(x, y));
		visited[y][x] = true;
		while (!queue.isEmpty()) {
			Point now = queue.poll();
			for (int i = 0; i < 4; i++) {
				int ny = now.y + direction[i][0];
				int nx = now.x + direction[i][1];

				if (ny < 0 || N <= ny || nx < 0 || N <= nx)
					continue;
				if (dyschromatopsia) {
					if (paper[now.y][now.x] == 2) {
						if (paper[ny][nx] < 2)
							continue;
					} else
						if (paper[ny][nx] == 2)
							continue;
				} else
					if (paper[ny][nx] != paper[now.y][now.x])
						continue;
				if (visited[ny][nx])
					continue;
				queue.add(new Point(nx, ny));
				visited[ny][nx] = true;
			}
		}
	}
}
