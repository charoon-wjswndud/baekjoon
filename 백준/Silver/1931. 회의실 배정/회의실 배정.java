import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main {
	static int r, c;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		PriorityQueue<Point> list = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		int cnt = 1;
		Point now = list.poll();
		while (!list.isEmpty()) {
			Point next = list.poll();
			if (now.y <= next.x) {
				now = next;
				cnt++;
			}
		}

		System.out.println(cnt);
	}

	private static class Point implements Comparable<Point>{
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Point o) {
			if (this.y == o.y)
				return Integer.compare(this.x, o.x);
			else
				return Integer.compare(this.y, o.y);
		}
	}
}
