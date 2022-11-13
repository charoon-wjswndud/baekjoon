import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//부분집합
public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static int N, B;
    static int[] S;
    static int min;
    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            sb.append("#").append(tc).append(" ");
            init();

            for (int r = 1; r <= N; r++) {
                boolean[] visited = new boolean[N];
                comb(visited, 0, N, r);
            }
            sb.append(min).append("\n");
        }
        System.out.println(sb);
    }

    private static void comb(boolean[] visited, int start, int n, int r) {
        if(r == 0){
            int sum = 0;
            for (int index = 0; index < visited.length; index++) {
                if(visited[index]){
                    sum += S[index];
                    if(sum - B > min) return;
                }
            }
            if(sum - B < 0) return;
            min = sum - B;
            return;
        }
        for (int i = start; i < n; i++) {
            visited[i] = true;
            comb(visited, i+1, n, r-1);
            visited[i] = false;
        }
    }

    private static void init() throws IOException {
        min = Integer.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        S = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }
    }
}
