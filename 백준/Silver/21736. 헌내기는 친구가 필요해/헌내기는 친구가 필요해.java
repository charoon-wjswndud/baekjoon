import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static final int EMPTY = 0, WALL = 1, PERSON = 3, DOYEON = 2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		boolean[][] visited = new boolean[N][M];
		Queue<Point> queue = new LinkedList<>();

		for (int y = 0; y < N; y++) {
			char[] line = br.readLine().toCharArray();
			for (int x = 0; x < M; x++) {
				if (line[x] == 'O')
					map[y][x] = EMPTY;
				else if (line[x] == 'X')
					map[y][x] = WALL;
				else if (line[x] == 'P')
					map[y][x] = PERSON;
				else {
					map[y][x] = DOYEON;
					queue.add(new Point(x, y));
					visited[y][x] = true;
				}
			}
		}

		int friend = 0;
		int[] dy = {0, 1, 0, -1};
		int[] dx = {1, 0, -1, 0};
		while (!queue.isEmpty()) {
			Point now = queue.poll();
			for (int i = 0; i < 4; i++) {
				int ny = now.y+dy[i];
				int nx = now.x+dx[i];
				if (ny < 0 || N <= ny || nx < 0 || M <= nx)
					continue;
				if (map[ny][nx] == WALL)
					continue;
				if (visited[ny][nx])
					continue;
				if (map[ny][nx] == PERSON)
					friend++;
				queue.add(new Point(nx, ny));
				visited[ny][nx] = true;
			}
		}

		System.out.println(friend==0?"TT":friend);
	}
}
