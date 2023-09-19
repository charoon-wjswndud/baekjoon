import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		while (0 < t--) {
			int n = Integer.parseInt(br.readLine());

			st = new StringTokenizer(br.readLine());
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			Point start = new Point(startX, startY);

			List<Point> list = new LinkedList<>();
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int martX = Integer.parseInt(st.nextToken());
				int martY = Integer.parseInt(st.nextToken());
				list.add(new Point(martX, martY));
			}

			st = new StringTokenizer(br.readLine());
			int endX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());
			Point end = new Point(endX, endY);
			list.add(end);

			Queue<Point> queue = new LinkedList<>();
			queue.add(start);
			Point last = start;
			while (!queue.isEmpty()) {
				Point now = last = queue.poll();
				if (now.equals(end))
					break;
				for (int i = list.size()-1; 0 <= i ; i--) {
					if (distance(now, list.get(i)) > 20*50)
						continue;
					queue.add(list.get(i));
					list.remove(i);
				}
			}

			if (last.equals(end))
				sb.append("happy").append("\n");
			else
				sb.append("sad").append("\n");
		}
		System.out.print(sb);
	}
	private static int distance(Point now, Point next) {
		return Math.abs(now.x - next.x) + Math.abs(now.y - next.y);
	}
}
