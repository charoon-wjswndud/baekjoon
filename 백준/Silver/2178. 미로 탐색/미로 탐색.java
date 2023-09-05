import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int Y = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		boolean[][] map = new boolean[Y][X];
		boolean[][] visited = new boolean[Y][X];
		for (int i = 0; i < Y; i++) {
			char[] line = br.readLine().toCharArray();
			for (int j = 0; j < X; j++) {
				map[i][j] = line[j] == '1';
			}
		}

		int[] dy = {0, 1, 0, -1};
		int[] dx = {1, 0, -1, 0};
		Queue<CustomPoint> queue = new LinkedList<>();
		queue.add(new CustomPoint(0, 0, 1));
		visited[0][0] = true;
		CustomPoint last = null;
		while (!queue.isEmpty()) {
			CustomPoint now = queue.poll();
			last = now;
			if (now.x == X-1 && now.y == Y-1)
				break;
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (nx < 0 || X <= nx || ny < 0 || Y <= ny)
					continue;
				if (visited[ny][nx])
					continue;
				if (!map[ny][nx])
					continue;
				queue.add(new CustomPoint(nx, ny, now.cnt+1));
				visited[ny][nx] = true;
			}
		}
		System.out.println(last.cnt);
	}
	private static class CustomPoint extends Point{
		int cnt;

		public CustomPoint(int x, int y, int cnt) {
			super(x, y);
			this.cnt = cnt;
		}
	}
}
