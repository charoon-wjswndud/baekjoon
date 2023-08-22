import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			int[] arr = new int[N];
			Queue<Page> queue = new LinkedList<>();
			for (int i = 0; i < N; i++) {
				int num = Integer.parseInt(st.nextToken());
				arr[i] = num;
				if (M != i)
					queue.add(new Page(num, false));
				else
					queue.add(new Page(num, true));
			}

			Arrays.sort(arr);

			int cnt = 0;
			for (int i = N-1; i >= 0; i--) {
				while(queue.peek().weight != arr[i]){
					queue.add(queue.poll());
				}
				Page page = queue.poll();
				cnt++;
				if (page.target)
					break;
			}
			sb.append(cnt).append("\n");
		}
		System.out.print(sb);
	}

	private static class Page {
		int weight;
		boolean target;

		public Page(int weight, boolean target) {
			this.weight = weight;
			this.target = target;
		}
	}
}
