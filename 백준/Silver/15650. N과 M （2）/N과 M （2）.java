import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int minDistance = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        boolean[] visited = new boolean[M];
        comb(sb, visited, M, N, 0);

        System.out.print(sb);
    }

    private static void comb(StringBuilder sb, boolean[] visited, int m, int n, int i) {
        if (n == 0) {
            for (int j = 0; j < m; j++)
                if (visited[j])
                    sb.append(j+1).append(" ");
            sb.append("\n");
            return;
        }

        for (int j = i; j < m; j++) {
            visited[j] = true;
            comb(sb, visited, m, n-1, j+1);
            visited[j] = false;
        }
    }
}