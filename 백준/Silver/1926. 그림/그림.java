import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] nd = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        boolean[][] map = new boolean[n][m];
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = st.nextToken().equals("1");
            }
        }

        int cnt = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!map[i][j] || visited[i][j])
                    continue;
                max = Math.max(max, bfs(map, visited, i, j));
                cnt++;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(cnt).append("\n").append(max);
        System.out.println(sb);
    }

    private static int bfs(boolean[][] map, boolean[][] visited, int y, int x) {
        int cnt = 1;
        Queue<Point> queue = new LinkedList<>();

        visited[y][x] = true;
        queue.add(new Point(x, y));

        while (!queue.isEmpty()) {
            Point now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = now.y + nd[i][0];
                int nx = now.x + nd[i][1];
                if (ny < 0 || n <= ny || nx < 0 || m <= nx)
                    continue;
                if (!map[ny][nx])
                    continue;
                if (visited[ny][nx])
                    continue;
                queue.add(new Point(nx, ny));
                visited[ny][nx] = true;
                cnt++;
            }
        }
        return cnt;
    }
}