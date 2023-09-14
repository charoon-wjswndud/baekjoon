import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());

		int M = Integer.parseInt(br.readLine());

		boolean[][] graph = new boolean[N+1][N+1];
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			graph[x][y] = true;
			graph[y][x] = true;
		}

		Queue<Point> queue = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		queue.add(new Point(X, 0));
		visited[X] = true;
		while (!queue.isEmpty()) {
			Point now = queue.poll();
			if (now.x == Y) {
				System.out.println(now.y);
				return;
			}
			for (int i = 1; i <= N; i++) {
				if (!graph[now.x][i])
					continue;
				if (visited[i])
					continue;
				queue.add(new Point(i, now.y+1));
				visited[i] = true;
			}
		}

		System.out.println(-1);
	}
}
