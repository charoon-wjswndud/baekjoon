import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int R;
	static int C;
	final static int[] dx = {1, 1, 1};
	final static int[] dy = {-1, 0, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		int pip = 0;
		for (int r = 0; r < R; r++) {
			if(search(map, r, 0)) pip++;
		}
		
		System.out.println(pip);
	}
	private static boolean search(char[][] map, int y, int x) {
		map[y][x] = '=';
		
		//종료 조건
		if(x == C-1) return true;
		
		//오른쪽 위
		if(0 < y && map[y + dy[0]][x + dx[0]] == '.') {
			if(search(map, y + dy[0], x + dx[0])) return true;
		}
		
		//오른쪽
		if(map[y + dy[1]][x + dx[1]] == '.') {
			if(search(map, y + dy[1], x + dx[1])) return true;
		}
		
		//오른쪽 아래
		if(y+1 < R && map[y + dy[2]][x + dx[2]] == '.') {
			if(search(map, y + dy[2], x + dx[2])) return true;
		}
		
		return false;
	}

}
