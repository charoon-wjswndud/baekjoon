import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 도시의 개수
        int M = Integer.parseInt(st.nextToken());   // 도로의 개수
        int K = Integer.parseInt(st.nextToken());   // 거리 정보
        int X = Integer.parseInt(st.nextToken());   // 출발 도시의 번호

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph.putIfAbsent(A, new ArrayList<>());
            graph.get(A).add(B);
        }

        int[] distances = new int[N + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[X] = 0;

        //다익스트라
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{X, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentNode = current[0];
            int distance = current[1];

            if (distances[currentNode] < distance) {
                continue;
            }

            List<Integer> neighbors = graph.getOrDefault(currentNode, new ArrayList<>());
            for (int neighbor : neighbors) {
                int newDist = distance + 1;
                if (newDist < distances[neighbor]) {
                    distances[neighbor] = newDist;
                    pq.offer(new int[]{neighbor, newDist});
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        boolean exists = false;
        for (int i = 1; i <= N; i++) {
            if (distances[i] == K) {
                sb.append(i).append("\n");
                exists = true;
            }
        }

        if (!exists) {
            sb.append("-1");
        }

        // 최종 결과 출력
        System.out.println(sb);
    }
}