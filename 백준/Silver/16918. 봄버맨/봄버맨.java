import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int R, C;

    static final int NONE = -1;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken())-1;

        map = new int[R][C];
        for (int i = 0; i < R; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                map[i][j] = line[j] == '.' ? NONE : 2;
            }
        }

        while (N-- > 0) {
            setBomb();
            explode();
        }
        StringBuilder sb = new StringBuilder();
        for (int[] row :
                map) {
            for (int col :
                    row) {
                sb.append(col == NONE ? '.' : 'O');
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }

    private static void explode() {
        final int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] != 0)
                    continue;
                for (int[] nd :
                        direction) {
                    int ny = i + nd[0];
                    int nx = j + nd[1];
                    if (ny < 0 || R <= ny || nx <0 || C <= nx)
                        continue;
                    if (map[ny][nx] == 0)
                        continue;
                    map[ny][nx] = NONE;
                }
                map[i][j] = NONE;
            }
        }
    }

    private static void setBomb() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                map[i][j] = map[i][j] == -1 ? 3 : map[i][j]-1;
            }
        }
    }
}