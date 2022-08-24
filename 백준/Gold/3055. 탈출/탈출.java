import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
class Main {
	static int R;
	static int C;
	static char[][] map;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		Dochi startPoint = null;
		List<River> riverList = new ArrayList<>();
		for (int row = 0; row < R; row++) {
			String line = br.readLine();
			for (int column = 0; column < C; column++) {
				map[row][column] = line.charAt(column);
				if(map[row][column] == 'S') startPoint = new Dochi(row, column);
				else if(map[row][column] == '*') riverList.add(new River(row, column));
			}
		}
		visited = new boolean[R][C];
		int time = bfs(startPoint, riverList);
		System.out.println(time == 0 ? "KAKTUS" : time);
	}
	
	private static int bfs(Dochi startPoint, List<River> riverList) {
		Queue<Dochi> queue = new LinkedList<>();
		queue.add(startPoint);
		visited[startPoint.row][startPoint.column] = true;
		int depth = -1;
		while(!queue.isEmpty()) {
			if(depth != queue.peek().time) {
				int size = riverList.size();
				for (int i = 0; i < size; i++) {
					riverList.get(i).flooding(riverList);
				}
				depth++;
			}
			Dochi now = queue.poll();
			if(map[now.row][now.column] == 'D') return now.time; 
			for (int directionNum = 0; directionNum < 4; directionNum++) {
				Dochi next = now.move(directionNum);
				if(next != null) {
					queue.add(next);
					visited[next.row][next.column] = true;
				}
			}
		}
		return 0;
	}
	static class Dochi extends Util{
		static int[] dy = {0, 1, 0, -1};
		static int[] dx = {1, 0, -1, 0};
		int row;
		int column;
		int time = 0;
		public Dochi(int row, int column) {
			super();
			this.row = row;
			this.column = column;
		}
		public Dochi(int row, int column, int time) {
			super();
			this.row = row;
			this.column = column;
			this.time = time;
		}
		public Dochi move(int directionNum) {	//우 하 좌 상
			int nextRow = this.row + dy[directionNum];
			int nextColumn = this.column + dx[directionNum];
			if(isPossible(nextRow, nextColumn)) {
				return new Dochi(nextRow, nextColumn, this.time+1);
			}
			return null;
		}
	}
	
	static class River extends Util{
		static int[] dy = {0, 1, 0, -1};
		static int[] dx = {1, 0, -1, 0};
		
		int row;
		int column;
		public River(int row, int column) {
			super();
			this.row = row;
			this.column = column;
		}
		private void flooding(List<River> riverList){
			int nextRow;
			int nextColumn;
			for (int i = 0; i < 4; i++) {
				nextRow = row + dy[i];
				nextColumn = column + dx[i];
				if(isPossible(nextRow, nextColumn)) {
					if(map[nextRow][nextColumn] != '*'){
						riverList.add(new River(nextRow, nextColumn));
					}
					map[nextRow][nextColumn] = '*';
				}
			}
			
		}
		
		@Override
		public boolean isPossible(int nextRow, int nextColumn) {
			if(0 <= nextRow && nextRow < R &&
					0 <= nextColumn && nextColumn < C &&
					(map[nextRow][nextColumn] == '.')) {
				return true;
			}else {
				return false;
			}
		}
		
	}
	static class Util{
		public boolean isPossible(int nextRow, int nextColumn) {
			if(0 <= nextRow && nextRow < R &&
					0 <= nextColumn && nextColumn < C &&
					(map[nextRow][nextColumn] == '.' || map[nextRow][nextColumn] == 'D')&&
					!visited[nextRow][nextColumn]) {
				return true;
			}else {
				return false;
			}
		}
	}
}