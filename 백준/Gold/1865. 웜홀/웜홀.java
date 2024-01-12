import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        while (TC-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            List<Edge> graph = new ArrayList<>();
            for (int i = 0; i < M + W; i++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());

                if (i < M) {
                    graph.add(new Edge(S, E, T));
                    graph.add(new Edge(E, S, T));
                } else
                    graph.add(new Edge(S, E, -T));
            }

            sb.append(bellmanFord_cycle(graph, N)?"NO":"YES").append("\n");
        }
        System.out.print(sb);
    }

    private static boolean bellmanFord_cycle(List<Edge> graph, int N) {
        int[] dist = new int[N+1];

        for (int i = 0; i < N; i++) {
            for (Edge e :
                    graph) {
                dist[e.destination] = Math.min(dist[e.source] + e.weight, dist[e.destination]);
            }
        }

        for (Edge e :
                graph) {
            if (dist[e.source] + e.weight < dist[e.destination])
                return false;
        }

        return true;
    }

    public static class Edge {
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }
}