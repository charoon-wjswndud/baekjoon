import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int R, C, N;
    static Bomb[][] map;
    public static void main(String[] args) throws IOException {
        init();

        for (int time = 2; time <= N; time++) {
            plusTime();
            if(time%2 == 0) setBomb();
            else explosion();
        }

        //print
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if(map[r][c] == null) sb.append('.');
                else sb.append('O');
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void explosion() {
        final int[][] direction = {{0, 1}, {1, 0} ,{0, -1}, {-1, 0}};
        for(int r = 0; r <R; r++) {
            for(int c = 0; c <C; c++) {
                if(map[r][c] != null && 3 <= map[r][c].time) {
                    map[r][c].status = false;
                    for (int d = 0; d < direction.length; d++) {
                        int nr = r+direction[d][0];
                        int nc = c+direction[d][1];
                        if(0 <= nr && nr < R && 0 <= nc && nc < C && map[nr][nc] != null){
                            map[nr][nc].status= false;
                        }
                    }
                }
            }
        }

        for(int r = 0; r <R; r++) {
            for(int c = 0; c <C; c++) {
                if(map[r][c] != null && map[r][c].status == false) map[r][c] = null;
            }
        }
    }

    private static void setBomb() {
        for(int r = 0; r <R; r++) {
            for(int c = 0; c <C; c++) {
                if(map[r][c] == null) map[r][c] = new Bomb(0);
            }
        }
    }

    private static void plusTime() {
        for(int r = 0; r <R; r++) {
            for(int c = 0; c <C; c++) {
                if(map[r][c] != null) map[r][c].time++;
            }
        }
    }

    private static void init() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new Bomb[R][C];

        for(int r = 0; r <R; r++) {
            String string = br.readLine();
            for(int c = 0; c <C; c++) {
                if(string.charAt(c) == 'O') map[r][c] = new Bomb(1);
            }
        }
    }

    static class Bomb{
        int time;
        boolean status;
        public Bomb(int time) {
            this.time = time;
            this.status = true;
        }
    }
}
