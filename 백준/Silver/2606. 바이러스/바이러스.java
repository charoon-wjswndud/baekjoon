import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine())+1;
		int M = Integer.parseInt(br.readLine());
		boolean[][] graph = new boolean[N][N];

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			graph[node1][node2] = true;
			graph[node2][node1] = true;
		}

		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N];
		int cnt = 0;
		queue.add(1);
		visited[1] = true;
		while (!queue.isEmpty()) {
			int node = queue.poll();
			for (int i = 1; i < N; i++) {
				if (graph[node][i] && !visited[i]) {
					queue.add(i);
					visited[i] = true;
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}
