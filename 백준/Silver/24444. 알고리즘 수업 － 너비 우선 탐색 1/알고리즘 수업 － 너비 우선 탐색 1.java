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

        List<Integer>[] graph = new LinkedList[N+1];
        for (int i = 0; i <= N; i++)
            graph[i] = new LinkedList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        for (List list : graph)
            Collections.sort(list);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(R);
        int order = 1;
        int[] visited = new int[N+1];
        visited[R] = order;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : graph[now]) {
                if (visited[next] != 0)
                    continue;
                queue.add(next);
                visited[next] = ++order;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++)
            sb.append(visited[i]).append("\n");

        System.out.print(sb);
    }
}