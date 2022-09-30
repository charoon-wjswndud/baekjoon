import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int K;
    static int ROW;
    static int COL;
    static int[][] MAP;
    final static int Y = 0;
    final static int X = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Util util = new Util();
        util.init(br);
        int result = solution();
        System.out.println(result-1);
    }

    private static int solution() {
        final int[][] horesMove = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-1, -2}};
        final int[][] monkeyMove = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        //bfs
        int[][][] visitedArr = new int[ROW][COL][K];
        Queue<Coordinates> queue = new LinkedList<>();
        queue.add(new Coordinates(0, 0, 0));
        for (int k = 0; k < K; k++) {
            visitedArr[0][0][k] = 1;
        }
        while(!queue.isEmpty()){
            Coordinates now = queue.poll();
            if(now.row == ROW-1 && now.col == COL-1) {
                return visitedArr[now.row][now.col][now.k];
            }
            //8방 탐색
            if(now.k < K-1) {
                for (int[] move:horesMove) {
                    Coordinates next = new Coordinates(now.row + move[Y], now.col + move[X], now.k+1);
                    if(movePossible(visitedArr, next)){
                        queue.add(next);
                        visitedArr[next.row][next.col][next.k] = visitedArr[now.row][now.col][now.k] + 1;
                    }
                }
            }
            //4방 탐색
            for (int[] move:monkeyMove) {
                Coordinates next = new Coordinates(now.row + move[Y], now.col + move[X], now.k);
                if(movePossible(visitedArr, next)){
                    queue.add(next);
                    visitedArr[next.row][next.col][next.k] = visitedArr[now.row][now.col][now.k] + 1;
                }
            }
        }
        return 0;
    }

    private static boolean movePossible(int[][][] visitedArr, Coordinates next) {
        return 0 <= next.row && next.row < ROW &&
                0 <= next.col && next.col < COL &&
                0 <= next.k && next.k < K &&
                visitedArr[next.row][next.col][next.k] == 0 &&
                MAP[next.row][next.col] == 0;
    }

    static class Util {
        public void init(BufferedReader br) throws IOException {
            K = Integer.parseInt(br.readLine()) + 1;
            StringTokenizer st = new StringTokenizer(br.readLine());
            COL = Integer.parseInt(st.nextToken());
            ROW = Integer.parseInt(st.nextToken());
            MAP = new int[ROW][COL];

            for (int r = 0; r < ROW; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < COL; c++) {
                    MAP[r][c] = Integer.parseInt(st.nextToken());
                }
            }
        }
    }

    static class Coordinates {
        int row;
        int col;
        int k;
        public Coordinates(int row, int col, int k) {
            this.row = row;
            this.col = col;
            this.k = k;
        }
    }
}