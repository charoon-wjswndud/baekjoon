import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, result=1;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];

		int max = 0; 
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]>max) max = map[i][j];
			}
		}

		for (int h = 1; h <= max; h++) {
			init();

			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j]>h && !visited[i][j]) {
						cnt++;
						dfs(i,j,h);
					}
				}
			}
			result = Math.max(cnt, result);
		}
		System.out.println(result);
	}

	private static void init() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				visited[i][j]=false;
			}
		}
	}

	private static void dfs(int r, int c, int h) {
		visited[r][c]=true;

		for (int i = 0; i < 4; i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];

			if(nr<0||nc<0||nr>=N||nc>=N||
					map[nr][nc]<=h||visited[nr][nc]) continue;

			dfs(nr,nc,h);
		}
	}

	private static void bfs(int r, int c, int h) {
		Queue<int[]> queue = new LinkedList<>();
		visited[r][c]=true;
		queue.offer(new int[]{r,c});

		while(queue.size()>0){
			int[] cur = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nr = cur[0]+dr[i];
				int nc = cur[1]+dc[i];

				if(nr<0||nc<0||nr>=N||nc>=N||
						map[nr][nc]<=h||visited[nr][nc]) continue;

				visited[nr][nc] = true;
				queue.offer(new int[]{nr,nc});
			}
		}
	}
}