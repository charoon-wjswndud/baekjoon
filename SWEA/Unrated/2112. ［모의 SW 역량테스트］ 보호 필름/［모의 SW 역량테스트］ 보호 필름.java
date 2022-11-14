import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int D, W, K;
    static boolean[][] map;
    static final boolean A = false, B = true;
    static int min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            init(br);
            //D comb 1~D
            boolean[] visited = new boolean[D];
            for (int d = 0; d <= D; d++) {
                comb(visited, 0, D, d);
            }
            sb.append("#").append(tc).append(" ").append(min).append("\n");
        }
        System.out.println(sb);
    }

    private static void comb(boolean[] visited, int start, int n, int r) {
        if(r == 0){
            boolean[][] copyMap = copy();
            dfs(visited, copyMap, 0);
            return;
        }
        for (int i = start; i < n; i++) {
            visited[i] = true;
            comb(visited, i+1, n, r-1);
            visited[i] = false;
        }
    }

    private static boolean[][] copy() {
        boolean[][] copyMap = new boolean[D][];
        for (int row = 0; row < D; row++) {
            copyMap[row] = map[row].clone();
        }
        return copyMap;
    }

    private static void dfs(boolean[] visited, boolean[][] copyMap, int cnt) {
        if(cnt == visited.length){
            if(check(copyMap)){
                int injectionNum = 0;
                for (boolean b :
                        visited) {
                    if (b) injectionNum++;
                }
                min = Math.min(min, injectionNum);
            }
            return;
        }
        if(!visited[cnt])
            dfs(visited, copyMap, cnt+1);
        else{
            injection(copyMap, cnt, A);
            dfs(visited, copyMap, cnt+1);
            injection(copyMap, cnt, B);
            dfs(visited, copyMap, cnt+1);
        }
    }

    private static boolean check(boolean[][] copyMap) {
        for (int col = 0; col < W; col++) {
            boolean now = copyMap[0][col];
            int cnt = 1;
            for (int row = 1; row < D; row++) {
                if(copyMap[row][col] == now) {
                    cnt++;
                    if(cnt >= K) break;
                }else{
                    now = copyMap[row][col];
                    cnt = 1;
                }
            }
            if(cnt < K) return false;
        }
        return true;
    }

    private static void injection(boolean[][] copyMap, int cnt, boolean a) {
        for (int col = 0; col < W; col++) {
            copyMap[cnt][col] = a;
        }
    }

    private static void init(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        D = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new boolean[D][W];
        min = Integer.MAX_VALUE;
        for (int row = 0; row < D ; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < W ; col++) {
                map[row][col] = st.nextToken().charAt(0) == '0' ? false : true;
            }
        }
    }
}
