import java.io.*;
import java.util.*;

public class Main {
    public static Deque<Integer> deque;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[][] map = new boolean[N][M];

        for (int r = 0; r < N; r++) {
            char[] row = br.readLine().toCharArray();
            for (int c = 0; c < M; c++) {
                map[r][c] = row[c] == '1';
            }
        }

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0, 1));
        map[0][0] = false;
        int[][] dr = {{0, 1},{1, 0},{-1, 0},{0, -1}};
        Point now = queue.peek();
        while (!queue.isEmpty()) {
            now = queue.poll();
            if (now.r == N-1 && now.c == M-1) {
                break;
            }
            for (int[] nd : dr) {
                int nr = now.r + nd[0];
                int nc = now.c + nd[1];
                if (nr < 0 || N <= nr || nc < 0 || M <= nc)
                    continue;
                if (!map[nr][nc])
                    continue;
                queue.add(new Point(nr, nc, now.cnt+1));
                map[nr][nc] = false;
            }
        }

        System.out.println(now.cnt);
    }

    private static class Point {
        int r;
        int c;
        int cnt;

        public Point(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
}