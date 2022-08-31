import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][][] directions = {{{1, 0}, {1, 1}},
								  {{0, 1}, {1, 1}},
								  {{1, 0}, {1, 1}, {0, 1}}};
	static final int E = 0;
	static final int SE = 1;
	static final int S = 2;
	static int N;
	static int count;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		int[][] home = new int[N][N];
		for (int row = 0; row < N; row++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int column = 0; column < N; column++) {
				home[row][column] = Integer.parseInt(st.nextToken());
			}
		}
		count = 0;
		Pipe point = new Pipe(new Point(0, 0), new Point(1, 0));
		dfs(home, point);
		
		System.out.println(count);
	}
	private static void dfs(int[][] home, Pipe pipe) {
		if(pipe.front.equals(new Point(N-1, N-1))){
			count++;
			return;
		}
		int direction = -1;
		
		if(pipe.back.y == pipe.front.y) direction = E;
		else if(pipe.back.x == pipe.front.x) direction = SE;
		else direction = S;
		
		for (int i = 0; i < directions[direction].length; i++) {
			int nextColumn = pipe.front.x + directions[direction][i][0];
			int nextRow = pipe.front.y + directions[direction][i][1];
			if(0 <= nextColumn && nextColumn < N && 0 <= nextRow && nextRow < N) {
				if(home[nextRow][nextColumn] == 1) {
					continue;
				}else if(i == 1 && 
						( home[nextRow-1][nextColumn] == 1 || home[nextRow][nextColumn-1] == 1)) {
					continue;
				}
				Pipe next = new Pipe(pipe.front, new Point(nextColumn, nextRow));
				dfs(home, next);
			}
		}
	}
	static class Pipe{
		Point front;
		Point back;
		public Pipe(Point back, Point front) {
			super();
			this.front = front;
			this.back = back;
		}
	}
}
