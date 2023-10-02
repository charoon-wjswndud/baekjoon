import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int w, h;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0)
                break;

            boolean[][] map = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = st.nextToken().equals("1");
                }
            }

            int cnt = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!map[i][j])
                        continue;
                    bfs(map, i, j);
                    cnt++;
                }
            }

            sb.append(cnt).append("\n");
        }
        System.out.print(sb);
    }

    private static void bfs(boolean[][] map, int i, int j) {
        int[][] nd = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(j, i));
        map[i][j] = false;

        while (!queue.isEmpty()) {
            Point now = queue.poll();
            for (int k = 0; k < 8; k++) {
                int ny = now.y + nd[k][0];
                int nx = now.x + nd[k][1];

                if (ny < 0 || h <= ny || nx < 0 || w <= nx)
                    continue;
                if (!map[ny][nx])
                    continue;
                queue.add(new Point(nx, ny));
                map[ny][nx] = false;
            }
        }
    }
}