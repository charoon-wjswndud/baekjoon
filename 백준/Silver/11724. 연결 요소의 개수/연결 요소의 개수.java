import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken())+1;
		int M = Integer.parseInt(st.nextToken());
		boolean[][] graph = new boolean[N][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			graph[start][end] = true;
			graph[end][start] = true;
		}
		solution(graph, N);
	}

	private static void solution(boolean[][] graph, int N) {
		int result = 0;
		boolean[] visited = new boolean[N];
		for (int row = 1; row < graph.length; row++) {
			for (int column = 1; column < graph.length; column++) {
				if(graph[row][column] && !visited[row]) {
					bfs(graph, visited, N, row);
					result++;
				}
			}
		}
		for (int i = 1; i < visited.length; i++) {
			if(!visited[i]) result++;
		}
		System.out.println(result);
	}
	
	private static void bfs(boolean[][] graph, boolean[] visited, int N, int row) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(row);
		visited[row] = true;
		while(!queue.isEmpty()) {
			int now = queue.poll();
			for (int i = 1; i < graph[now].length; i++) {
				if(graph[now][i] && !visited[i]) {
					queue.add(i);
					visited[i] = true;
				}
			}
		}
	}
}
