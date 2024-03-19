import java.util.*;
class Solution {
    static int n, m;
    public int solution(int[][] land) {
        n = land.length;
        m = land[1].length;

        int[] arr = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1) {
                    bfs(arr, land, new Point(i, j));
                }
            }
        }
        int answer = 0;
        for (int num :
                arr) {
            answer = Math.max(answer, num);
        }
        return answer;
    }

    private void bfs(int[] arr, int[][] land, Point point) {
        int[][] dr = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Set<Integer> set = new HashSet<>();
        set.add(point.x);

        Queue<Point> queue = new LinkedList<>();
        queue.add(point);
        land[point.y][point.x] = 0;

        int cnt = 1;
        while (!queue.isEmpty()) {
            Point now = queue.poll();

            for (int[] nd :
                    dr) {
                int ny = now.y + nd[0];
                int nx = now.x + nd[1];

                if (ny < 0 || n <= ny || nx < 0 || m <= nx)
                    continue;
                if (land[ny][nx] == 0)
                    continue;
                set.add(nx);
                queue.add(new Point(ny, nx));
                land[ny][nx] = 0;
                cnt++;
            }
        }
        for (int x :
                set) {
            arr[x] += cnt;
        }
    }

    private static class Point {
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}