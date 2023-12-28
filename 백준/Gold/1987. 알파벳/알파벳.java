import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	static int R, C, maxCnt;
	static boolean[][] visited;
	static char[][] map;
	static int[][] dr = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];

		for (int r = 0; r < R; r++) {
			char[] line = br.readLine().toCharArray();
			System.arraycopy(line, 0, map[r], 0, C);
		}

		maxCnt = 1;

		visited = new boolean[R][C];
		visited[0][0] = true;

		boolean[] check = new boolean[26];
		check[map[0][0] - 'A'] = true;

		dfs(0, 0, 1, check);
		System.out.println(maxCnt);
	}

	private static void dfs(int r, int c, int cnt, boolean[] check) {
		for (int[] nd:
			 dr) {
			int nr = r + nd[0];
			int nc = c + nd[1];
			if (nr < 0 || R <= nr || nc < 0 || C <= nc)
				continue;
			if (visited[nr][nc])
				continue;
			if (check[map[nr][nc] - 'A'])
				continue;
			visited[nr][nc] = true;
			check[map[nr][nc] - 'A'] = true;
			dfs(nr, nc, cnt+1, check);
			visited[nr][nc] = false;
			check[map[nr][nc] - 'A'] = false;
		}
		maxCnt = Math.max(maxCnt, cnt);
	}
}
