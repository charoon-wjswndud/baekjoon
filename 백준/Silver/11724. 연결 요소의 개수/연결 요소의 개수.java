import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int N, M;
 	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		boolean[][] graph = new boolean[N+1][N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			graph[node1][node2] = true;
			graph[node2][node1] = true;
		}

		int cnt = 0;
		boolean[] visited = new boolean[N+1];
		for (int i = 1; i <= N; i++) {
			if (visited[i]) {
				continue;
			}
			bfs(graph,visited, i);
			cnt++;
		}
		System.out.println(cnt);
	}

	private static void bfs(boolean[][] graph, boolean[] visited, int i) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(i);
		visited[i] = true;
		while (!queue.isEmpty()) {
			int num = queue.poll();
			for (int j = 1; j <= N; j++) {
				if (graph[num][j] && !visited[j]) {
					queue.add(j);
					visited[j] = true;
				}
			}
		}
	}
}
