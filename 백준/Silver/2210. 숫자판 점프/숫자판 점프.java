import java.io.*;
import java.util.*;

public class Main {
    static Set<String> set = new HashSet<>();
    static String[][] map = new String[5][5];
    static int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++)
                map[i][j] = st.nextToken();
        }
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                dfs(i, j, 0, new StringBuilder(map[i][j]));
        System.out.println(set.size());
    }

    public static void dfs(int y, int x, int cnt, StringBuilder sb) {
        if (cnt == 5) {
            set.add(sb.toString());
            return;
        }
        for (int[] nd :
                direction) {
            int nx = x + nd[1];
            int ny = y + nd[0];
            if (ny < 0 || 5 <= ny || nx < 0 || 5 <= nx)
                continue;
            dfs(ny, nx, cnt + 1, sb.append(map[ny][nx]));
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}