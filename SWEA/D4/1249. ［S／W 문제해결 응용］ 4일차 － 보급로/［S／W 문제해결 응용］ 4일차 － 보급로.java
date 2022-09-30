import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
bfs
 */
public class Solution {
    static int T;
    static int N;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            sb.append("#").append(testCase).append(" ");
            Util.init(br);

            int min = solution();
            sb.append(min).append("\n");
        }
        System.out.println(sb);
    }

    private static int solution() {
        final int X = 1;
        final int Y = 0;
        int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[][] visitedArr = new int[N][N];

        //최대값로 초기화
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                visitedArr[row][col] = Integer.MAX_VALUE;
            }
        }

        visitedArr[0][0] = 0;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));
        while(!queue.isEmpty()){
            Point now = queue.poll();
            for (int[] d : direction) {
                Point next = new Point(now.x+d[X], now.y+d[Y]);
                if (movePossible(visitedArr, next, now)) {
                    queue.add(next);
                    visitedArr[next.y][next.x] = visitedArr[now.y][now.x] + map[next.y][next.x];
                }
            }
        }
        return visitedArr[N-1][N-1];
    }

    private static boolean movePossible(int[][] visitedArr, Point next, Point now) {
        return 0 <= next.x && next.x < N &&
                0 <= next.y && next.y < N &&
                visitedArr[next.y][next.x] > visitedArr[now.y][now.x] + map[next.y][next.x];
    }

    static class Util{
        public static void init(BufferedReader br) throws IOException {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            for (int row = 0; row < N; row++) {
                String line = br.readLine();
                for (int col = 0; col < N; col++) {
                    map[row][col] = Character.getNumericValue(line.charAt(col));
                }
            }
        }
    }
}
