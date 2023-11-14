import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new LinkedList<>();
        for (int i = 0; i <= N; i++)
            graph.add(new LinkedList<>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            graph.get(num1).add(num2);
            graph.get(num2).add(num1);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(a);
        int[] visited = new int[N+1];
        Arrays.fill(visited, -1);
        visited[a] = 0;
        int cnt = 1;

        int result = bfs(graph, a, b, N);
        System.out.println(result);
    }
    private static int bfs(List<List<Integer>> graph, int a, int b, int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(a);
        boolean[] visited = new boolean[n+1];
        int time = 0;
        visited[a] = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int s = 0 ; s < size ; s++){
                int now = queue.poll();
                if(now == b)
                    return time;
                for(int next : graph.get(now)){
                    if(!visited[next]){
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }
            time++;
        }
        return -1;
    }
}