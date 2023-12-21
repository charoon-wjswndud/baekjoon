import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int K, cnt, N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] set = new int[N];
        for (int i = 0; i < N; i++)
            set[i] = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[N];
        cnt = 0;
        permutation(visited, set, 0, 500);
        System.out.println(cnt);
    }

    private static void permutation(boolean[] visited, int[] set, int i, int weight) {
        if (i == N) {
            cnt++;
            return;
        }
        for (int j = 0; j < N; j++) {
            if (visited[j])
                continue;
            visited[j] = true;
            int temp = weight - K + set[j];
            if (temp >= 500)
                permutation(visited, set, i + 1, temp);
            visited[j] = false;
        }
    }
}