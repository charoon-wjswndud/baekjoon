import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		List<List<Integer>> graph = new ArrayList<>();

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			graph.get(A).add(B);
			graph.get(B).add(A);
		}

		int[] parentTree = new int[N+1];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		parentTree[1] = -1;

		StringBuilder sb = new StringBuilder();
		while (!queue.isEmpty()) {
			int now = queue.poll();
			for (int next :
					graph.get(now)) {
				if (parentTree[next] != 0)
					continue;
				parentTree[next] = now;
				queue.add(next);
			}
		}

		for (int i = 2; i <= N; i++) {
			sb.append(parentTree[i]).append("\n");
		}

		System.out.print(sb);
	}
}
