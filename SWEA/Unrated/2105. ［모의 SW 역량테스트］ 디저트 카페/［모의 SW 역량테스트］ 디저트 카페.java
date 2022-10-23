import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static BufferedReader br;
    static StringBuilder sb;
    static int N;
    static int[][] map;
    static final int[][] direction = {{1, 1}, {1, -1}, {-1, -1}, {-1, 1}};
    static final int DR = 0, DL = 1, UL = 2, UR = 3, X = 1, Y = 0;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            sb.append("#").append(tc).append(" ");
            init();
            solution();
            if(max == 0) sb.append(-1).append("\n");
            else sb.append(max).append("\n");
        }
        System.out.println(sb);
    }

    private static void solution() {
        for (int row = 0; row < N - 2; row++) {
            for (int col = 1; col < N-1; col++) {
                boolean[][] visited = new boolean[N][N];
                boolean[] checkList = new boolean[101];
                int count = 1;
                Point oriPoint = new Point(col, row);
                Point point = new Point(col, row);
                visited[row][col] = true;
                checkList[map[row][col]] = true;
                dfs(count, visited, checkList,  oriPoint, point, DR);
            }
        }

    }

    private static void dfs(int count, boolean[][] visited, boolean[] checkList, Point oriPoint, Point point, int dr) {
        for (int d = dr; d < 4; d++) {
            Point nextP = new Point(point.x+direction[d][X], point.y+direction[d][Y]);

            if(0 <= nextP.x && nextP.x < N && 0 <= nextP.y && nextP.y < N){
                if(oriPoint.x == nextP.x && oriPoint.y == nextP.y && 2 < count ) {
                    max = Math.max(max, count);
                    return;
                }
                if (!visited[nextP.y][nextP.x] && !checkList[map[nextP.y][nextP.x]]){
                    visited[nextP.y][nextP.x] = true;
                    checkList[map[nextP.y][nextP.x]] = true;
                    dfs(count+1, visited, checkList, oriPoint, nextP, d);
                    visited[nextP.y][nextP.x] = false;
                    checkList[map[nextP.y][nextP.x]] = false;
                }
            }
        }
    }

    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        max = 0;
        for (int row = 0; row < N; row++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int col = 0; col < N; col++) {
                map[row][col] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
