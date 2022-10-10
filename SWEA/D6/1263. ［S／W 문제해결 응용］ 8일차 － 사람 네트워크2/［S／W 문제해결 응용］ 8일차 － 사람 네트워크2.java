import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            sb.append("#").append(tc).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken())+1;
            boolean[][] graph = new boolean[N][N];
            for (int i = 1; i < N; i++) {
                for (int j = 1; j < N; j++) {
                    graph[i][j] = st.nextToken().equals("1");
                }
            }

            //solution
            int minCC = Integer.MAX_VALUE;
            for (int start = 1; start < N; start++) {
                int CC = 0;
                int[] dist = new int[N];
                for (int j = 0; j < N; j++) {
                    dist[j] = Integer.MAX_VALUE;
                }

                dijkstra(graph, start, dist);
                for (int d :
                        dist) {
                    if(d != Integer.MAX_VALUE)CC += d;
                }
                minCC = Math.min(minCC, CC);
            }

            sb.append(minCC).append("\n");
        }
        System.out.println(sb);
    }

    private static void dijkstra(boolean[][] graph, int start, int[] dist) {
        boolean[] visited = new boolean[N];
        visited[start] = true;
        for (int i = 1; i < N; i++) {
            if(graph[start][i]) dist[i] = 1;
        }
        for (int i = 1; i < N-2; i++) {
            int current = getSmallIndex(dist, visited);
            visited[current] = true;
            for (int j = 1; j < N; j++) {
                if(visited[j]) continue;
                if(graph[current][j] && dist[current] + 1 < dist[j]) dist[j] = dist[current] + 1;
            }
        }
    }

    private static int getSmallIndex(int[] dist, boolean[] visited) {
        int small = Integer.MAX_VALUE;
        int smallIndex = -1;
        for (int i = 1; i < N; i++) {
            if(!visited[i] && dist[i] < small) {
                smallIndex = i;
                small = dist[i];
            }
        }
        return smallIndex;
    }
}
