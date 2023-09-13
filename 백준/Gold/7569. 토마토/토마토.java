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
		int Z = Integer.parseInt(st.nextToken());
		int[][][] boxes = new int[Z+1][Y+1][X+1];
		Queue<Tomato> tomatoes = new LinkedList<>();
		for (int z = 1; z <= Z; z++) {
			for (int y = 1; y <= Y; y++) {
				st = new StringTokenizer(br.readLine());
				for (int x = 1; x <= X; x++) {
					boxes[z][y][x] = Integer.parseInt(st.nextToken());
					if (boxes[z][y][x] == 1) {
						tomatoes.add(new Tomato(z, y, x, 0));
					}
				}
			}
		}

		int[] dz = {0, 0, 0, 0, -1, 1};
		int[] dy = {0, -1, 0, 1, 0, 0};
		int[] dx = {1, 0, -1, 0, 0, 0};

		Tomato lastTomato = tomatoes.peek();
		while (!tomatoes.isEmpty()) {
			lastTomato = tomatoes.poll();
			for (int i = 0; i < 6; i++) {
				int nz = lastTomato.z + dz[i];
				int ny = lastTomato.y + dy[i];
				int nx = lastTomato.x + dx[i];
				if (nz < 1 || Z < nz || ny < 1 || Y < ny || nx < 1 || X < nx)
					continue;
				if (boxes[nz][ny][nx] == -1 || boxes[nz][ny][nx] == 1)
					continue;
				tomatoes.add(new Tomato(nz, ny, nx, lastTomato.day+1));
				boxes[nz][ny][nx] = 1;
			}
		}

		for (int i = 1; i <= Z; i++) {
			for (int j = 1; j <= Y; j++) {
				for (int k = 1; k <= X; k++) {
					if (boxes[i][j][k] == 0) {
						System.out.println(-1);
						return;
					}
				}
			}
		}
		System.out.println(lastTomato.day);
	}
	private static class Tomato {
		int z;
		int y;
		int x;
		int day;

		public Tomato(int z, int y, int x, int day) {
			this.z = z;
			this.y = y;
			this.x = x;
			this.day = day;
		}
	}
}
