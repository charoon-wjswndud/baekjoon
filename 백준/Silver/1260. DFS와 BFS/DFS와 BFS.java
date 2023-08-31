import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
	static int[] dp = new int[11];
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());

		//입력
		boolean[][] graph1 = new boolean[N+1][N+1];
		boolean[][] graph2 = new boolean[N+1][N+1];
		boolean[] visited1 = new boolean[N+1];
		boolean[] visited2 = new boolean[N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			graph1[node1][node2] = true;
			graph1[node2][node1] = true;
			graph2[node1][node2] = true;
			graph2[node2][node1] = true;
		}

		//dfs
		Stack<Integer> stack = new Stack<>();
		stack.add(V);
		sb.append(V).append(" ");
		visited1[V] = true;
		while (!stack.isEmpty()) {
			int pop = stack.peek();
			boolean check = true;
			for (int i = 1; i <= N; i++) {
				if (graph1[pop][i] && !visited1[i]) {
					stack.add(i);
					visited1[i] = true;
					check = false;
					sb.append(i).append(" ");
					break;
				}
			}
			if (check)
				stack.pop();
		}
		sb.append("\n");

		//bfs;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(V);
		visited2[V] = true;
		while (!queue.isEmpty()) {
			int pop = queue.poll();
			sb.append(pop).append(" ");
			for (int i = 1; i <= N; i++) {
				if (graph2[pop][i] && !visited2[i]){
					queue.add(i);
					visited2[i] = true;
				}
			}
		}

		//print
		System.out.println(sb);
	}
}
