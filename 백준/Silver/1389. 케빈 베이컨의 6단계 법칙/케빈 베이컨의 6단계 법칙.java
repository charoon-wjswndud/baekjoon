import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] graph;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		graph = new boolean[N+1][N+1];
		for (int i = 0; i < M; i++) {
			st= new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a][b] = true;
			graph[b][a] = true;
		}

		int minIndex = -1;
		int min = Integer.MAX_VALUE;
		for (int a = 1; a <= N; a++) {
			int temp = 0;
			for (int b = 1; b <= N; b++) {
				if (a == b)
					continue;
				temp += bfs(a, b);
			}

			if (temp < min) {
				minIndex = a;
				min = temp;
			}else if (temp == min)
				minIndex = Math.min(minIndex, a);
		}

		System.out.println(minIndex);

	}

	private static int bfs(int a, int b) {
		Queue<Point> queue = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		queue.add(new Point(a, 0));
		visited[a] = true;

		while (!queue.isEmpty()) {
			Point now = queue.poll();
			if (now.x == b)
				return now.y;
			for (int i = 1; i <= N; i++) {
				if (now.x == i)
					continue;
				if (!graph[now.x][i])
					continue;
				if (visited[i])
					continue;
				queue.add(new Point(i, now.y+1));
				visited[i] = true;
			}
		}
		return 0;
	}
}
