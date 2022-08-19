import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static final int[] dx = {1, 0, -1, 0};
	static final int[] dy = {0, 1, 0, -1};
	static int maxCount = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		char[][] arr = new char[R][C];
		boolean[] checkAlphabet = new boolean['Z'-('A'-1)]; 
		for (int i = 0; i < R; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		dfs(new Position(0, 0), arr, checkAlphabet, 0);
		System.out.println(maxCount);
	}
	private static void dfs(Position position, char[][] arr, boolean[] checkAlphabet, int count) {
		if(checkAlphabet[arr[position.row][position.column]-'A']) {
			maxCount = Math.max(count, maxCount);
			return;
		}
		checkAlphabet[arr[position.row][position.column]-'A'] = true;
		for (int i = 0; i < 4; i++) {
			int x = position.column + dx[i];
			int y = position.row + dy[i];
			if((0 <= x) && (x < arr[0].length) && (0 <= y) && (y < arr.length)) {
				dfs(new Position(y, x), arr, checkAlphabet, count+1);
			}
		}
		checkAlphabet[arr[position.row][position.column]-'A'] = false;
	}
	static class Position{
		int row;
		int column;
		public Position(int row, int column) {
			super();
			this.row = row;
			this.column = column;
		}
	}
}
