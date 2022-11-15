import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static boolean[][] map, whirlpool;
    static int N;
    static Point start, end;
    static final boolean ROCK = true;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            init(br);
            sb.append("#").append(tc).append(" ").append(bfs()).append("\n");
        }
        System.out.println(sb);
    }

    /**
     1. 4방탐색
     2. 장애물 x
     3. 주변에 소용돌이 있으면 3초안에 진입
     4. 한 지역에 3초(waitTime) 이상 머무면 삭제
     5. 방문지역 x
     */
    private static int bfs() {
        final int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        final int Y = 0, X = 1;
        map[start.y][start.x] = true;
        Queue<Samsung> queue = new LinkedList<>();
        queue.add(new Samsung(start.y, start.x));
        while(!queue.isEmpty()){
            boolean checkAround = false;
            Samsung now = queue.poll();
            //도착
            if(now.point.y == end.y && now.point.x == end.x) return now.time;
            for (int[] d :
                    direction) {
                int nextY = now.point.y+d[Y];
                int nextX = now.point.x+d[X];
                //범위확인
                if(N <= nextX || nextX < 0 || N <= nextY || nextY < 0 ) continue;
                //방문, 장애물확인
                if(map[nextY][nextX]) continue;
                //주위소용돌이확인
                if(whirlpool[nextY][nextX]){
                    //TODO 4방 소용돌이 시간 이동
                    if(now.time%3 == 2) {
                        queue.add(new Samsung(nextY, nextX, now.time+1));
                        map[nextY][nextX] = true;
                    }
                    else checkAround = true;
                }else{
                    queue.add(new Samsung(nextY, nextX, now.time+1));
                    map[nextY][nextX] = true;
                }
            }
            //주위에 소용돌이 있으면 이동 x
            if(checkAround) queue.add(new Samsung(now.point.y, now.point.x, now.time+1));
        }
        return -1;
    }

    private static void init(BufferedReader br) throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new boolean[N][N];
        whirlpool = new boolean[N][N];

        for (int row = 0; row < N; row++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int col = 0; col < N; col++) {
                char c = st.nextToken().charAt(0);
                if(c == '1') map[row][col] = true;
                else if(c == '2') whirlpool[row][col] = true;
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        start = new Point(x, y);


        st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        end = new Point(x, y);
    }
    static class Samsung{
        Point point;
        int time = 0;

        public Samsung(int row, int col) {
            this.point = new Point(col, row);
        }

        public Samsung(int row, int col, int time){
            this.point = new Point(col, row);
            this.time = time;
        }
    }
}
