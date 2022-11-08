import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[][] MAP;
    static final int[][] direction = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
    static final int MINE=-1, CLICK=-2;
    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            init();
            scan();
            sb.append("#").append(tc).append(" ").append(click()).append("\n");
        }
        System.out.println(sb);
    }

    private static int click() {
        int count = 0;
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                if(MAP[row][col] == 0) {
                    bfs(row, col);
                    count++;
                }
            }
        }
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                if(MAP[row][col] != MINE && MAP[row][col] != CLICK) {
                    count++;
                }
            }
        }
        return count;
    }

    private static void scan() {
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                if(MAP[row][col] == MINE) continue;
                int mineCount = 0;
                for (int d = 0; d < direction.length; d++) {    //8방 탐색
                    int nextY = row + direction[d][0];
                    int nextX = col + direction[d][1];
                    if(nextY < 0 || N <= nextY || nextX < 0 || N <= nextX)continue;
                    if (MAP[nextY][nextX] == MINE) mineCount++;
                }
                MAP[row][col] = mineCount;
            }
        }
    }

    private static boolean checkDirection(int row, int col) {
        for (int d = 0; d < direction.length; d++) {    //8방 탐색
            int nextY = row + direction[d][0];
            int nextX = col + direction[d][1];
            if(nextY < 0 || N <= nextY || nextX < 0 || N <= nextX)continue;
            if(MAP[nextY][nextX] == MINE) return false;
        }
        return true;
    }

    private static void bfs(int row, int col) {
        Queue<Point> queue = new LinkedList();
        MAP[row][col] = CLICK;
        queue.add(new Point(col, row));

        while(!queue.isEmpty()){
            Point now = queue.poll();
            for (int d = 0; d < direction.length; d++) {
                int nextY = now.y + direction[d][0];
                int nextX = now.x + direction[d][1];
                if(nextY < 0 || N <= nextY || nextX < 0 || N <= nextX || MAP[nextY][nextX] == CLICK)continue;
                if(MAP[nextY][nextX] == 0){
                    queue.add(new Point(nextX, nextY));
                }
                MAP[nextY][nextX] = CLICK;
            }
        }
    }

    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        MAP = new int[N][N];
        for (int row = 0; row < N; row++) {
            String string = br.readLine();
            for (int col = 0; col < N; col++) {
                MAP[row][col] = string.charAt(col) == '*' ? MINE:0;
            }
        }
    }
}