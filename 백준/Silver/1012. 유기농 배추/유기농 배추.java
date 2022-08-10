import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testCase = Integer.parseInt(br.readLine());
		for (int i = 1; i <= testCase; i++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());	//가로
			int N = Integer.parseInt(st.nextToken());	//세로
			int cabbage = Integer.parseInt(st.nextToken());
			
			//농경지 배추 심기
			boolean[][] farm = new boolean[N+2][M+2];	//쉬운 탐색을 위해 false로 감싸기
			for (int j = 0; j < cabbage; j++) {
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken())+1;
				int Y = Integer.parseInt(st.nextToken())+1;
				farm[Y][X] = true;
			}
			boolean[][] visited = new boolean[N+2][M+2];	//탐색한 곳 체크할 배열
			int earthworm = 0;
			for (int row = 1; row < farm.length; row++) {
				for (int column = 1; column < farm[0].length; column++) {
					if(farm[row][column] && !visited[row][column]) {
						dfs(new Coordinate(row, column), farm, visited);
						earthworm++;
					}
				}
			}
			System.out.println(earthworm);
		}
	}
	private static void dfs(Coordinate coordinate, boolean[][] farm, boolean[][] visited) {
		int[] dx = {1, 0, -1, 0};	//우 하 좌 상
		int[] dy = {0, 1, 0, -1};	//우 하 좌상 
		Stack<Coordinate> stack = new Stack<>();		
		stack.push(coordinate);
		while(!stack.isEmpty()) {
			Coordinate temp = stack.pop();
			visited[temp.row][temp.column] = true;
			for (int i = 0; i < 4; i++) {
				if(farm[temp.row+dy[i]][temp.column+dx[i]] && !visited[temp.row+dy[i]][temp.column+dx[i]]) {
					stack.push(new Coordinate(temp.row+dy[i], temp.column+dx[i]));
				}
			}
		}
	}
	static class Coordinate{
		int row;
		int column;
		public Coordinate(int row, int column) {
			super();
			this.row = row;
			this.column = column;
		}
	}
}
