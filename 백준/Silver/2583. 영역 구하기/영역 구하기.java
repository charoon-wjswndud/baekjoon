import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class Main {
    static int N, M;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[][] map = new boolean[M][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            for (int j = startY; j < endY; j++) {
                for (int k = startX; k < endX; k++) {
                    map[j][k] = true;
                }
            }
        }
        int cnt = 0;
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j])
                    continue;
                list.add(bfs(map, i, j));
                cnt++;
            }
        }
        sb.append(cnt).append("\n");
        Collections.sort(list);
        for (int n:list) {
            sb.append(n).append(" ");
        }
        System.out.println(sb);
    }

    private static int bfs(boolean[][] map, int y, int x) {
        int[][] nd = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        map[y][x] = true;
        int cnt = 1;
        while (!queue.isEmpty()) {
            Point now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = now.y + nd[i][0];
                int nx = now.x + nd[i][1];
                if (ny < 0 || M <= ny || nx < 0 || N <= nx)
                    continue;
                if (map[ny][nx])
                    continue;
                queue.add(new Point(nx, ny));
                map[ny][nx] = true;
                cnt++;
            }
        }
        return cnt;
    }
}