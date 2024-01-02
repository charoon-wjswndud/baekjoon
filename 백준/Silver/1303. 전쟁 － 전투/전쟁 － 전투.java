import java.awt.*;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        boolean[][] map = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                map[i][j] = line[j] == 'W';
            }
        }
        int wPower = 0;
        int bPower = 0;
        boolean[][] visited = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j])
                    continue;
                int groupCnt = bfs(map, visited, i, j);
                if (map[i][j])
                    wPower += groupCnt * groupCnt;
                else
                    bPower += groupCnt * groupCnt;
            }
        }

        System.out.println(wPower + " " + bPower);
    }

    private static int bfs(boolean[][] map, boolean[][] visited, int r, int c) {
        final int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        visited[r][c] = true;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(c, r));

        int cnt = 1;

        while (!queue.isEmpty()) {
            Point now = queue.poll();
            for (int[] nd :
                    direction) {
                int nr = now.y + nd[0];
                int nc = now.x + nd[1];
                if (nr < 0 || M <= nr || nc < 0 || N <= nc)
                    continue;
                if (map[nr][nc] != map[r][c])
                    continue;
                if (visited[nr][nc])
                    continue;
                queue.add(new Point(nc, nr));
                cnt++;
                visited[nr][nc] = true;
            }
        }
        return cnt;
    }
}