import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		for (int testCase = 0; testCase < 10; testCase++) {
			boolean[][] graph = new boolean[101][101];
			StringTokenizer st = new StringTokenizer(br.readLine());
			int dataLength = Integer.parseInt(st.nextToken());
			int startPhone = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < dataLength/2; i++) {
				int transmit = Integer.parseInt(st.nextToken());
				int receive = Integer.parseInt(st.nextToken());
				graph[transmit][receive] = true;
			}
			
			int[] visited = bfs(graph, startPhone);
			int maxCountIndex = 0;
			for (int i = 0; i < visited.length; i++) {
				if(visited[i] >= visited[maxCountIndex]) {
					maxCountIndex = i;
				}
			}
			System.out.printf("#%d %d\n",testCase+1, maxCountIndex);
		}
	}

	private static int[] bfs(boolean[][] graph, int startPhone) {
		int[] visited = new int[101];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(startPhone);
		visited[startPhone] = 1;
		while(!queue.isEmpty()) {
			int nowNode = queue.poll();
			for (int i = 1; i < graph.length; i++) {
				if(graph[nowNode][i] && visited[i] == 0) {
					queue.add(i);
					visited[i] = visited[nowNode]+1; 
				}
			}
		}
		return visited;
	}
}