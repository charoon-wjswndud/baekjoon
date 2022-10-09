import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    final static char WALL = '#';
    final static char EXIT = '1';
    final static int[][] direction = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    final static int Y = 0, X = 1;
    static int ROW;
    static int COL;
    static char[][] MAP;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //MAP init
        ROW = Integer.parseInt(st.nextToken());
        COL = Integer.parseInt(st.nextToken());
        MAP = new char[ROW][COL];
        Minsick start = null;
        for (int row = 0; row < ROW; row++) {
            String line = br.readLine();
            for (int col = 0; col < COL; col++) {
                MAP[row][col] = line.charAt(col);
                if (MAP[row][col] == '0') start = new Minsick(row, col,0, 0);
            }
        }

        //Solution
        boolean[][][] visited = new boolean[64][ROW][COL];
        Queue<Minsick> queue = new LinkedList<>();
        visited[0][start.row][start.col] = true;
        queue.add(start);
        while (!queue.isEmpty()){
            Minsick now = queue.poll();
            if(MAP[now.row][now.col] == EXIT){
                System.out.println(now.distance);
                return;
            }
            for (int d = 0; d < 4; d++) {
                int ny = now.row + direction[d][Y];
                int nx = now.col + direction[d][X];
                Minsick next = new Minsick(ny, nx, now.distance+1, now.key);
                //범위 확인
                if(ny < 0 || ROW <= ny || nx < 0 || COL <= nx) continue;
                //구성 확인
                if(MAP[ny][nx] == WALL) continue;
                else if ('a' <= MAP[ny][nx] && MAP[ny][nx] <= 'f') {
                    int key = 1 << (MAP[ny][nx]-'a');
                    next.key = now.key | key;
                } else if ('A' <= MAP[ny][nx] && MAP[ny][nx] <= 'F') {
                    int door = 1 << (MAP[ny][nx]-'A');
                    if( (next.key & door) == 0) continue;
                }
                //방문 확인
                if(visited[next.key][ny][nx]) continue;

                visited[next.key][ny][nx] = true;
                queue.add(next);
            }
        }
        System.out.println(-1);
    }
    static class Minsick {
        int row;
        int col;
        int distance;
        int key;
        public Minsick(int row, int col, int distance, int key) {
            this.row = row;
            this.col = col;
            this.distance = distance;
            this.key = key;
        }
    }
}
