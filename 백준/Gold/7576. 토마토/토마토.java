import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		boolean[][] map = new boolean[Y][X];
		Queue<Tomato> queue = new LinkedList<>();

		boolean check = false;
		for (int y = 0; y < Y; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < X; x++) {
				String state = st.nextToken();
				if (state.equals("1")) {
					queue.add(new Tomato(y, x));
					map[y][x] = false;
				} else if (state.equals("0")){
					map[y][x] = true;
					check = true;
				} else
					map[y][x] = false;
			}
		}
		//저장될 때부터 모든 토마토가 익어있는 상태이면 0을 출력
		if (!check) {
			System.out.println(0);
			return;
		}

		int[][] nd = {{0, 1},{1, 0},{0, -1},{-1, 0}};
		Tomato last = null;
		while (!queue.isEmpty()) {
			last = queue.poll();
			for (int i = 0; i < 4; i++) {
				int ny = last.y + nd[i][0];
				int nx = last.x + nd[i][1];
				if (ny < 0 || Y <= ny || nx < 0 || X <= nx)
					continue;
				if (!map[ny][nx])
					continue;
				queue.add(new Tomato(ny, nx, last.day+1));
				map[ny][nx] = false;
			}
		}
		for (boolean[] b1: map){
			for (boolean b2:b1) {
				if (b2){
					System.out.println("-1");
					return;
				}
			}
		}

		System.out.println(last.day);

	}

	static class Tomato{
		int y;
		int x;
		int day;
		boolean state;

		public Tomato(int y, int x) {
			this.y = y;
			this.x = x;
			state = true;
			day = 0;
		}

		public Tomato(int y, int x, int day) {
			this.y = y;
			this.x = x;
			state = true;
			this.day = day;
		}
	}
}
