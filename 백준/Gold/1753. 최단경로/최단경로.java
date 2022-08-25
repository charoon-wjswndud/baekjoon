import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());	//정점 수
		int E = Integer.parseInt(st.nextToken());	//간선 수
		int sV = Integer.parseInt(br.readLine());//시작 정점
		
		//graph 생성
		List<ArrayList<Node>> graph = new ArrayList<>();
		for (int i = 0; i < V+1; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph.get(u).add(new Node(v, w));
		}
		
		boolean[] visited = new boolean[V+1];	//방문한 노드 확인
		int[] dist = new int[V+1];				//시작노드에서 각 노드까지 거리 배열
		for (int i = 1; i < dist.length; i++) {	//최대거리로 초기화
			dist[i] = Integer.MAX_VALUE;
		}
		dist[sV] = 0;
		
		//다익스트라 시작
		for (int i = 0; i < V; i++) {
			// 4 - 1. 현재 거리 비용 중 최소인 지점을 선택한다.
			// 해당 노드가 가지고 있는 현재 비용.
			int nodeValue = Integer.MAX_VALUE;
			// 해당 노드의 인덱스(번호).
			int nodeIdx = 0;
			// 인덱스 0은 생각하지 않기 때문에 0부터 반복을 진행한다.
			for (int j = 1; j < V + 1; j++) {
				// 해당 노드를 방문하지 않았고, 현재 모든 거리비용 중 최솟값을 찾는다.
				if (!visited[j] && dist[j] < nodeValue) {
					nodeValue = dist[j];
					nodeIdx = j;
				}
			}
			// 최종 선택된 노드를 방문처리 한다.
			visited[nodeIdx] = true;

			// 4 - 2. 해당 지점을 기준으로 인접 노드의 최소 거리 값을 갱신한다.
			for (int j = 0; j < graph.get(nodeIdx).size(); j++) {
				// 인접 노드를 선택한다.
				Node node = graph.get(nodeIdx).get(j);
				// 인접 노드가 현재 가지는 최소 비용과
				// 현재 선택된 노드의 값 + 현재 노드에서 인접 노드로 가는 값을 비교하여 더 작은 값으로 갱신한다.
				if (dist[node.num] > dist[nodeIdx] + node.cost) {
					dist[node.num] = dist[nodeIdx] + node.cost;
				}
			}
		}
		// 5. 최종 비용을 출력한다.
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < V + 1; i++) {
			if (dist[i] == Integer.MAX_VALUE) {
				sb.append("INF" + "\n");
			} else {
				sb.append(dist[i] + "\n");
			}
		}
		System.out.println(sb);
	}
	static class Node{
		int num;
		int cost;
		public Node(int num, int cost) {
			super();
			this.num = num;
			this.cost = cost;
		}
	}
}
