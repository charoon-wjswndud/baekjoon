import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int[][] direction = {{1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}};
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		while (T-- > 0) {
			int i = Integer.parseInt(br.readLine());
			int[][] visited = new int[i][i];
			int y, x;

			st = new StringTokenizer(br.readLine());
			y = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			Point start = new Point(x, y);

			st = new StringTokenizer(br.readLine());
			y = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			Point end = new Point(x, y);

			Queue<Point> queue = new LinkedList<>();
			queue.add(start);
			visited[start.y][start.x] = 0;
			while (!queue.isEmpty()) {
				Point now = queue.poll();
				if (now.equals(end))
					break;
				for (int[] nd :
						direction) {
					Point next = new Point(now.x + nd[1], now.y + nd[0]);
					if (next.x < 0 || i <= next.x || next.y < 0 || i <= next.y)
						continue;
					if (visited[next.y][next.x] != 0)
						continue;

					queue.add(next);
					visited[next.y][next.x] = visited[now.y][now.x] + 1;
				}
			}

			sb.append(visited[end.y][end.x]).append("\n");
		}
		System.out.print(sb);
	}
}
