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
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] map = new int[101];
		int[] record = new int[101];
		Arrays.fill(record, Integer.MAX_VALUE);
		for (int i = 0; i < N+M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			map[start] = end;
		}

		Queue<Player> queue = new LinkedList<>();
		queue.add(new Player(1, 0));
		Player last = queue.peek();
		record[1] = 0;
		while (!queue.isEmpty()) {
			Player now = last = queue.poll();
			if (now.num == 100)
				break;
			for (int i = 1; i <= 6; i++) {
				int next = now.num + i;
				if (100 < next)
					continue;
				while (map[next] != 0)
					next = map[next];
				if (record[next] <= now.time+1)
					continue;
				queue.add(new Player(next, now.time+1));
				record[next] = now.time+1;
			}
		}
		System.out.println(last.time);
	}

	private static class Player {
		int num;
		int time;

		public Player(int num, int time) {
			this.num = num;
			this.time = time;
		}
	}
}
