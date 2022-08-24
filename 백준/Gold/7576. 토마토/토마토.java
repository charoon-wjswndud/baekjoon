import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dy = {0, 1, 0, -1};
	static int[] dx = {1, 0, -1, 0};
	static int R;
	static int C;
	static int[][] box;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		box = new int[R][C];
		List<Tomato> ripeTomatoList = new ArrayList<>();
		for (int row = 0; row < R; row++) {
			st = new StringTokenizer(br.readLine());
			for (int column = 0; column < C; column++) {
				box[row][column] = Integer.parseInt(st.nextToken());
				if(box[row][column] == 1) ripeTomatoList.add(new Tomato(row, column, 0));
			}
		}
		int time = bfs(ripeTomatoList);
		
		if(searchUnripeTomato()) System.out.println(-1);
		else System.out.println(time);
	}
	private static boolean searchUnripeTomato() {
		for (int[] row : box) {
			for (int column : row) {
				if(column == 0) return true;
			}
		}
		return false;
	}
	private static int bfs(List<Tomato> ripeTomatoList) {
		Tomato lastTomato = null;
		Queue<Tomato> queue = new LinkedList<>();
		boolean[][] visited = new boolean[R][C];
		for (Tomato ripeTomato : ripeTomatoList) {
			queue.add(ripeTomato);
			visited[ripeTomato.row][ripeTomato.column] = true;
		}
		while(!queue.isEmpty()) {
			Tomato now = queue.poll();
			lastTomato = now;
			//4방탐색
			for (int direction = 0; direction < 4; direction++) {
				if(isPossible(visited, now, direction)) {
					int nextRow = now.row+dy[direction];
					int nextColumn = now.column+dx[direction];
					queue.add(new Tomato(now.row+dy[direction], now.column+dx[direction], now.time+1));
					visited[nextRow][nextColumn] = true;
					box[nextRow][nextColumn] = 1;
				}
			}
		}
		return lastTomato != null ? lastTomato.time : 0;
	}
	
	private static boolean isPossible(boolean[][] visited, Tomato now, int direction) {
		int nextRow = now.row + dy[direction];
		int nextColumn = now.column + dx[direction];
		if(0 <= nextRow && nextRow < R &&
				0 <= nextColumn && nextColumn < C &&
				box[nextRow][nextColumn] == 0 &&
				!visited[nextRow][nextColumn]) {
			return true;
		}
		return false;
	}
	static class Tomato{
		int row;
		int column;
		int time;
		public Tomato(int row, int column, int time) {
			super();
			this.row = row;
			this.column = column;
			this.time = time;
		}
	}
}
