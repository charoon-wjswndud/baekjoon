import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			StringBuffer sb = new StringBuffer("#" + testCase + " ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			//graph 생성 및 초기화, 입력
			List<ArrayList<Edge>> graph = new ArrayList<>();
			for (int i = 0; i <= V; i++) {
				graph.add(new ArrayList<>());
			}
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int node1 = Integer.parseInt(st.nextToken());
				int node2 = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				
				graph.get(node1).add(new Edge(node2, cost));
				graph.get(node2).add(new Edge(node1, cost));
			}
			boolean[] visited = new boolean[V+1];
			sb.append(prim(graph, visited, V));
			System.out.println(sb);
		}
	}
	private static long prim(List<ArrayList<Edge>> graph, boolean[] visited, int V) {
		long totalCost = 0;
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(1, 0));
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			if(visited[edge.node]) continue;
			else {
				visited[edge.node] = true;
				totalCost += edge.cost;
				for (Edge temp : graph.get(edge.node)) {
					if(!visited[temp.node]) pq.add(temp);
				}
			}
		}
		return totalCost;
	}
	static class Edge implements Comparable<Edge>{
		int node;
		long cost;
		public Edge(int node, int cost) {
			super();
			this.node = node;
			this.cost = cost;
		}
		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.cost, o.cost);
		}
	}
}
