import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N; 
    private static int[][] map;
    private static boolean[] visited; 
    private static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited[0] = true;
        dfs(0, 0, 0, 0, visited);
        System.out.println(result);
    }

    private static void dfs(int depth, int start, int prev, int cost, boolean[] visited) { 
        if (depth == N - 1) {
            if (map[prev][start] != 0) {
                result = Math.min(result, cost + map[prev][start]); 
            }
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (map[prev][i] != 0) {
                    dfs(depth + 1, start, i, cost + map[prev][i], visited);
                }
                visited[i] = false;
            }
        }
    }
}
