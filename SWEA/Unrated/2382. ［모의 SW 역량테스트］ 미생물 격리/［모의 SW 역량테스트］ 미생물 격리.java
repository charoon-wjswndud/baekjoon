import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Solution {
    final static int UP = 1;
    final static int DOWN = 2;
    final static int LEFT = 3;
    final static int RIGHT = 4;
    static int N;
    static int M;
    static int K;
    static Queue<Cluster>[][] MAP;
    static List<Cluster> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            sb.append("#").append(testCase).append(" ");
            Util util = new Util();
            util.init(br);
            int total = solution();
            sb.append(total).append("\n");
        }

        System.out.println(sb);
    }

    private static int solution() {
        for (int time = 0; time < M; time++) {
            //TODO 1. 각 군집들은 1시간마다 이동방향에 있는 다음 셀로 이동한다.
            for (Cluster c: list) {
                c.move();
            }

            //TODO 2. 약품 셀 처리
            for (Cluster c: list) {
                c.death();
            }

            //TODO 3. 군집 합치기
            List<Cluster> deleteList = new LinkedList<>();
            for (Cluster c: list) {
                if(MAP[c.y][c.x].size() >= 2){
                    int totalClusterNum = 0;
                    while (MAP[c.y][c.x].size() != 1) {
                        Cluster c1 = MAP[c.y][c.x].remove();
                        Cluster c2 = MAP[c.y][c.x].remove();
                        if(c1.num < c2.num){
                            MAP[c.y][c.x].add(c2);
                            deleteList.add(c1);
                            totalClusterNum += c1.num;
                        }
                        else{
                            MAP[c.y][c.x].add(c1);
                            deleteList.add(c2);
                            totalClusterNum += c2.num;
                        }
                    }
                    MAP[c.y][c.x].peek().num += totalClusterNum;
                }
            }
            for (Cluster dc:deleteList) {
                list.remove(dc);
            }
        }
        int total= 0;
        for (Cluster c: list) {
            total += c.num;
        }
        return total;
    }

    static class Util{
        public void init(BufferedReader br) throws IOException {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            MAP = new Queue[N][N];
            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    MAP[row][col] = new LinkedList<>();
                }
            }

            list = new LinkedList<>();
            for (int k = 0; k < K; k++) {
                st = new StringTokenizer(br.readLine());
                int row = Integer.parseInt(st.nextToken());
                int col = Integer.parseInt(st.nextToken());
                int num = Integer.parseInt(st.nextToken());
                int direction = Integer.parseInt(st.nextToken());
                Cluster cluster = new Cluster(row, col, num, direction);
                list.add(cluster);
                MAP[row][col].add(cluster);
            }
        }
    }
    static class Cluster {
        int num;
        int direction;

        int y;
        int x;
        public Cluster(int row, int col, int num, int direction) {
            this.y = row;
            this.x = col;
            this.num = num;
            this.direction = direction;
        }

        public void move() {
            Cluster me = MAP[y][x].remove();
            //if: 약품위치이면 반대 방향으로
            if(x == 0 || x == N-1 || y == 0 || y == N-1) {
                switch (direction){
                    case UP:
                        direction = DOWN;
                        break;
                    case DOWN:
                        direction = UP;
                        break;
                    case LEFT:
                        direction = RIGHT;
                        break;
                    case RIGHT:
                        direction = LEFT;
                        break;
                }
            }
            //else:
            switch (direction){
                case UP:
                    y--;
                    break;
                case DOWN:
                    y++;
                    break;
                case LEFT:
                    x--;
                    break;
                case RIGHT:
                    x++;
                    break;
            }
            MAP[y][x].add(me);
        }

        public void death() {
            double bNum = num;
            if(x == 0 || x == N-1 || y == 0 || y == N-1){
                bNum = bNum/2;
                num = (int)bNum;
            }
        }
    }
}
