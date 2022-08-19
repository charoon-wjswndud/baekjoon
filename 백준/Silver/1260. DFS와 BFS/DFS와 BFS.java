import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] graph;
	static int N;
	static int M;
	static int V;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		graph = new boolean[N+1][N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			graph[node1][node2] = true;
			graph[node2][node1] = true;
		}
		
		toString(dfs());
		toString(bfs());
	}
	private static LinkedList<Integer> bfs() {
		boolean[] visited = new boolean[N+1];
		Queue<Integer> queue = new LinkedList<>();
		LinkedList<Integer> list = new LinkedList<>();
		queue.add(V);
		visited[V] = true;
		while(!queue.isEmpty()) {
			int temp = queue.remove();
			list.add(temp);
			for (int b = 1; b < N+1; b++) {
				if(graph[temp][b] && !visited[b]) {
					queue.add(b);
					visited[b] = true;
				}
			}
		}
		return list;
	}
	
	private static LinkedList<Integer> dfs() {
		boolean[] visited = new boolean[N+1];
		Stack<Integer> stack = new Stack<>();
		LinkedList<Integer> list = new LinkedList<>();
		stack.add(V);
		visited[V] = true;
		while(!stack.isEmpty()) {
			findFirstChildNode(stack, visited, list);
		}
		
		return list;
	}
	
	private static void findFirstChildNode(Stack<Integer> stack, boolean[] visited, LinkedList<Integer> list) {
		int temp = stack.peek();
		list.add(temp);
		for (int b = 1; b < N+1; b++) {
			if(graph[temp][b] && !visited[b]) {
				stack.add(b);
				visited[b] = true;
				findFirstChildNode(stack, visited, list);
			}
		}
		stack.pop();
		return;
	}
	public static void toString(LinkedList<Integer> list) {
		StringBuilder sb = new StringBuilder();
		for (Integer integer : list) {
			sb.append(integer + " ");
		}
		System.out.println(sb);
	}
}
