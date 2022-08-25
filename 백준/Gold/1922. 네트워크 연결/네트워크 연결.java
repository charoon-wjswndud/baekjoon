import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());	//컴퓨터 수
		int M = Integer.parseInt(br.readLine());	//연결 수
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();	//우선 순위 큐 생성(cost값 오름차순 정렬)
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			pq.add(new Edge(start, end, cost));
		}

		int[] parent = new int[N+1];
		DisjointSet ds = new DisjointSet();	//서로소 집합 도구 생성
		ds.make(parent);
		int sum = 0;	//결과값
	
		//프림 알고리즘
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			int start = ds.find(parent, edge.start);
			int end = ds.find(parent, edge.end);
			if(start == end) continue;
			ds.union(parent, start, end);
			sum += edge.cost;
			
		}
		System.out.println(sum);
	}
	static class DisjointSet{
		public void make(int[] parent) {
			for (int i = 0; i < parent.length; i++) {
				parent[i] = i;
			}
		}
		public int find(int[] parent, int node) {
			return parent[node] == node ? node : find(parent, parent[node]);
		}
		
		public void union(int[] parent, int node1, int node2) {
			parent[find(parent, node1)] = find(parent, node2);
		}
	}
	static class Edge implements Comparable<Edge>{
		int start;
		int end;
		int cost;
		public Edge(int start, int end, int cost) {
			super();
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.cost, o.cost);
		}
	}
}
