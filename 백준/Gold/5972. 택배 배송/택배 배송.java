import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            graph.get(A).add(new Node(B, C));
            graph.get(B).add(new Node(A, C));
        }

        PriorityQueue<Node> queue = new PriorityQueue<>(((o1, o2) -> Integer.compare(o1.weight, o2.weight)));
        boolean[] visited = new boolean[N + 1];
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        queue.add(new Node(1, 0));
        dist[1] = 0;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            if (visited[now.dest])
                continue;
            visited[now.dest] = true;

            for (Node next :
                    graph.get(now.dest)) {
                if (visited[next.dest])
                    continue;
                if (dist[now.dest] + next.weight < dist[next.dest]) {
                    dist[next.dest] = dist[now.dest] + next.weight;
                    queue.add(new Node(next.dest, dist[next.dest]));
                }
            }
        }

        System.out.println(dist[N]);
    }

    public static class Node {
        int dest;
        int weight;

        public Node(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }
}