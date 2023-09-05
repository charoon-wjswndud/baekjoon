import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[][] map = new boolean[N][N];
		boolean[][] visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			char[] line = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				map[i][j] = line[j] == '1';
			}
		}

		List<Integer> townList = new LinkedList<>();
		int[] dy = {0, 1, 0, -1};
		int[] dx = {1, 0, -1, 0};
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				if (!map[y][x])
					continue;
				if (visited[y][x])
					continue;
				Queue<Point> queue = new LinkedList<>();
				queue.add(new Point(x, y));
				visited[y][x] = true;
				int cnt = 1;
				while (!queue.isEmpty()) {
					Point now = queue.poll();
					for (int i = 0; i < 4; i++) {
						int ny = now.y + dy[i];
						int nx = now.x + dx[i];
						if (ny < 0 || N <= ny || nx < 0 ||N <= nx)
							continue;
						if (visited[ny][nx])
							continue;
						if (!map[ny][nx])
							continue;
						queue.add(new Point(nx, ny));
						visited[ny][nx] = true;
						cnt++;
					}
				}
				townList.add(cnt);
			}
		}
		Collections.sort(townList);
		StringBuilder sb = new StringBuilder().append(townList.size()).append("\n");
		for (int town:
			 townList) {
			sb.append(town).append("\n");
		}
		System.out.print(sb);
	}
}
