import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int cnt = 0;
    static int R, C, K;
    static int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static boolean[][] map, visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                map[i][j] = line[j] == 'T';
            }
        }

        visited = new boolean[R][C];
        visited[R-1][0] = true;
        dfs(R-1, 0, 1);

        System.out.println(cnt);
    }

    private static void dfs(int r, int c, int k) {
        if (r == 0 && c == C-1) {
            if (k == K)
                cnt++;
            return;
        }

        for (int[] nd :
                direction) {
            int nr = r + nd[0];
            int nc = c + nd[1];
            if (nr < 0 || nr >= R || nc < 0 || nc >= C)
                continue;
            if (visited[nr][nc] || map[nr][nc])
                continue;
            visited[nr][nc] = true;
            dfs(nr, nc, k+1);
            visited[nr][nc] = false;
        }
    }

    public static class Point {
        int y;
        int x;
        int distance;

        public Point(int y, int x, int distance) {
            this.y = y;
            this.x = x;
            this.distance = distance;
        }
    }
}