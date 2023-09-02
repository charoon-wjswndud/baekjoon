import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int Y, X;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		int startY = 0, startX = 0;
		boolean[][] map = new boolean[Y][X];
		int[][] distance = new int[Y][X];
		for (int y = 0; y < Y; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < X; x++) {
				String num = st.nextToken();
				if (num.equals("2")) {
					map[y][x] = true;
					startY = y;
					startX = x;
				}else
					map[y][x] = num.equals("1");
				distance[y][x] = Integer.MAX_VALUE;
			}
		}

		bfs(map, distance, startY, startX);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < Y; i++) {
			for (int j = 0; j < X; j++) {
				if (!map[i][j])
					sb.append(0).append(" ");
				else if(distance[i][j] == Integer.MAX_VALUE)
					sb.append(-1).append(" ");
				else
					sb.append(distance[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}

	private static void bfs(boolean[][] map, int[][] distance, int startY, int startX) {
		int[][] np = {{0, 1},{-1, 0}, {0, -1}, {1, 0}};
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(startY, startX, 0));
		distance[startY][startX] = 0;
		while (!queue.isEmpty()) {
			Point now = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nextY = now.y+np[i][0];
				int nextX = now.x+np[i][1];
				int nextDistance = now.distance +1;
				//index 범위 체크
				if (nextY < 0 || Y <= nextY || nextX < 0 || X <= nextX)
					continue;
				//지도 체크
				if (!map[nextY][nextX])
					continue;
				//최솟값 확인
				if (nextDistance >= distance[nextY][nextX])
					continue;
				queue.add(new Point(nextY, nextX, nextDistance));
				distance[nextY][nextX] = nextDistance;
			}
		}
	}

	private static class Point{
		int y;
		int x;
		int distance;

		public Point(int y, int x, int distance) {
			this.y = y;
			this.x = x;
			this.distance = distance;
		}
	}
}
