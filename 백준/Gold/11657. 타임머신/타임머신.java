import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		List<Edge> graph = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			graph.add(new Edge(A, B, C));
		}

		long[] dist = new long[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[1] = 0;
		for (int i = 0; i < N-1; i++) {
			for (Edge e :
					graph) {
				if (dist[e.source] == Integer.MAX_VALUE)
					continue;
				if (dist[e.source] + e.weight < dist[e.destination]) {
					dist[e.destination] = dist[e.source] + e.weight;
				}
			}
		}

		for (Edge e:
			 graph) {
			if (dist[e.source] == Integer.MAX_VALUE)
				continue;
			if (dist[e.source] + e.weight < dist[e.destination]) {
				System.out.println(-1);
				return;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 2; i <= N; i++) {
			sb.append(dist[i] != Integer.MAX_VALUE ? dist[i] : -1).append("\n");
		}
		System.out.print(sb);
	}
	public static class Edge {
		int source;
		int destination;
		int weight;

		public Edge(int source, int destination, int weight) {
			this.source = source;
			this.destination = destination;
			this.weight = weight;
		}
	}
}
