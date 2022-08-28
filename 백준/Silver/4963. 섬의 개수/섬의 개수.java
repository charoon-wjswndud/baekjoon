import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dRow= {0, 1, 1, 1, 0, -1, -1, -1};
	static int[] dColumn = {1, 1, 0, -1, -1, -1, 0, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			int count = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int column = Integer.parseInt(st.nextToken());
			int row = Integer.parseInt(st.nextToken());
			if(column == 0 && row == 0) break;
			
			int[][] map = new int[row][column];
			for (int r = 0; r < row; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < column; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			boolean[][] visited = new boolean[row][column];
			for (int r = 0; r < row; r++) {
				for (int c = 0; c < column; c++) {
					if(map[r][c] == 1 && !visited[r][c]) {
						dfs(map, visited, r, c);
						count++;
					}
				}
			}
			sb.append(count + "\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int[][] map, boolean[][] visited, int r, int c) {
		visited[r][c] = true;
		for (int i = 0; i < 8; i++) {
			int nextRow = r + dRow[i];
			int nextColumn = c + dColumn[i];
			if(0 <= nextRow && nextRow < visited.length &&
					0 <= nextColumn && nextColumn < visited[0].length &&
					!visited[nextRow][nextColumn] &&
					map[nextRow][nextColumn] == 1) {
					dfs(map, visited, nextRow, nextColumn);
			}
		}
	}
}
