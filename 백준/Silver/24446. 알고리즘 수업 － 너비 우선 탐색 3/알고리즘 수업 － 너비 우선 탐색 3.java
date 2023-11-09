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

        boolean[] visited = new boolean[N+1];
        visited[R]=true;

        int dep = 0;
        int[] depth = new int[N+1];
        Arrays.fill(depth, -1);

        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                int now = queue.poll();
                depth[now] = dep;
                for(int next : graph.get(now)) {
                    if(!visited[next]) {
                        visited[next] = true;
                        queue.add(next);
                    }
                }
            }
            dep++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++)
            sb.append(depth[i]).append("\n");

        System.out.println(sb);

    }
}