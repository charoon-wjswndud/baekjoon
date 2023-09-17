import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static final int WALL = 1, DUST = 0, CLEAN = 2;
	static int N, M;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());	//세로
		M = Integer.parseInt(st.nextToken());	//가로
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int y = 0; y < N; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < M; x++)
				map[y][x] = Integer.parseInt(st.nextToken());
		}

		int cnt = 0;
		Robot robot = new Robot(r, c, d);
		while (robot.isOn()) {
			if (!robot.checkClean()) 	//현재 위치에서 청소가 되지 않았을 때
				robot.clean();

			if (robot.searchDust()){
				robot.turn();
				if (robot.checkFront()){
					robot.move();
				}
			} else {
				if (robot.canReverse()) {
					robot.reverse();
				}else {
					robot.stop();
				}
			}
		}
		System.out.println(robot.cntClean);
	}
	static class Robot{
		static int[][] dist = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
		int y;
		int x;
		int d;
		int cntClean;
		boolean power;

		public Robot(int y, int x, int d) {
			this.y = y;
			this.x = x;
			this.d = d;
			this.cntClean = 0;
			this.power = true;
		}

		public boolean isOn() {
			return power;
		}

		public boolean checkClean() {
			return map[y][x] != DUST;
		}

		public void clean() {
			map[y][x] = CLEAN;
			cntClean++;
		}

		public boolean searchDust() {
			for (int i = 0; i < 4; i++) {
				int ny = this.y + dist[i][0];
				int nx = this.x + dist[i][1];
				if (ny < 0 || N <= ny || nx < 0 || M <= nx)
					continue;
				if (map[ny][nx] == DUST)
					return true;
			}
			return false;
		}

		public boolean canReverse() {
			int ny = this.y - dist[d][0];
			int nx = this.x - dist[d][1];
			if (ny < 0 || N <= ny || nx < 0 || M <= nx)
				return false;
			return map[ny][nx] != WALL;
		}

		public void reverse() {
			this.y = this.y - dist[d][0];
			this.x = this.x - dist[d][1];
		}

		public void stop() {
			this.power = false;
		}

		public void turn() {
			if (this.d == 0)
				this.d = 3;
			else
				this.d--;
		}

		public boolean checkFront() {
			int ny = this.y + dist[d][0];
			int nx = this.x + dist[d][1];
			if (ny < 0 || N <= ny || nx < 0 || M <= nx)
				return false;
			return map[ny][nx] == DUST;
		}

		public void move() {
			this.y = this.y + dist[d][0];
			this.x = this.x + dist[d][1];
		}
	}
}
