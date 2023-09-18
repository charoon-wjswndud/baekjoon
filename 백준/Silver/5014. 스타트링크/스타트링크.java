import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int F = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int U = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());

		int[] visited = new int[F+1];
		Arrays.fill(visited, Integer.MIN_VALUE);
		Queue<Integer> queue = new LinkedList<>();
		queue.add(S);
		visited[S] = 0;
		while (!queue.isEmpty()) {
			if (visited[G] != Integer.MIN_VALUE)
				break;

			int now = queue.poll();
			//UP
			if (now + U <= F && visited[now + U] == Integer.MIN_VALUE) {
				queue.add(now + U);
				visited[now + U] = visited[now] + 1;
			}

			//DOWN
			if (0 < now - D && visited[now - D] == Integer.MIN_VALUE) {
				queue.add(now - D);
				visited[now - D] = visited[now] + 1;
			}
		}
		if (visited[G] != Integer.MIN_VALUE)
			System.out.println(visited[G]);
		else
			System.out.println("use the stairs");
	}
}
