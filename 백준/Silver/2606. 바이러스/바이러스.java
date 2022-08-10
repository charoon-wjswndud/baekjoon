import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int infection = 0;
		int vertex = Integer.parseInt(br.readLine());	
		int edge = Integer.parseInt(br.readLine());		
		
		int[][] graph = new int[vertex+1][vertex+1];
		
		for (int com = 0; com < edge; com++) {
			st = new StringTokenizer(br.readLine());
			int vertex1 = Integer.parseInt(st.nextToken());
			int vertex2 = Integer.parseInt(st.nextToken());
			graph[vertex1][vertex2] = 1;
			graph[vertex2][vertex1] = 1;
		}
		boolean[] visited = new boolean[vertex+1];
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		visited[1] = true;
		while(!stack.isEmpty()) {
			int computer = stack.pop();
			infection++;
			for (int row = 1; row <= vertex; row++) {
				if(graph[computer][row] == 1 && !visited[row]) {
					stack.push(row);
					visited[row] = true;
				}
			}
		}
		System.out.println(infection-1);
	}
}