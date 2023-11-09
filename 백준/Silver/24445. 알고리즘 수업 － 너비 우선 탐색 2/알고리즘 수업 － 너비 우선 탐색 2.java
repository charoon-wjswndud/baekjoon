import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= N; i++)
            graph.add(new LinkedList<>());


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for (int i = 1; i <= N; i++)
            graph.get(i).sort(Comparator.reverseOrder());

        Queue<Integer> queue = new LinkedList<>();
        queue.add(R);

        int[] visited = new int[N+1];
        int cnt = 1;
        visited[R] = cnt;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next :
                    graph.get(now)) {
                if (visited[next] != 0)
                    continue;
                queue.add(next);
                visited[next] = ++cnt;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++)
            sb.append(visited[i]).append("\n");

        System.out.print(sb);
    }
}