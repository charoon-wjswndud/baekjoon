import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int source = Integer.parseInt(st.nextToken());
            int destination = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(source).add(new Node(destination, weight));
        }

        st = new StringTokenizer(br.readLine());

        int source = Integer.parseInt(st.nextToken());
        int destination = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(source, 0));

        boolean[] visited = new boolean[N+1];

        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            if(visited[now.destination])
                continue;
            visited[now.destination] = true;

            for (Node next :
                    graph.get(now.destination)) {
                if (next.weight + dist[now.destination] < dist[next.destination]) {
                    dist[next.destination] = dist[now.destination] + next.weight;
                    queue.add(new Node(next.destination, dist[next.destination]));
                }
            }
        }

        System.out.println(dist[destination]);
    }

    public static class Node implements Comparable<Node>{
        int destination;
        int weight;

        public Node(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
}