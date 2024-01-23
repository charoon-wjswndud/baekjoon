import java.util.*;
import java.io.*;

class Main {
    static int N, K;
    static int[] parent = new int[100001];
    static int[] time = new int[100001];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs();

        Stack<Integer> stack = new Stack<>();
        stack.push(K);
        int index = K;

        while (index != N) {
            stack.push(parent[index]);
            index = parent[index];
        }

        sb.append(time[K] - 1).append("\n");
        
        while (!stack.isEmpty()) 
            sb.append(stack.pop()).append(" ");

        System.out.println(sb);
    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(N);
        time[N] = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (now == K) 
                return;

            for (int i=0; i<3; i++) {
                int next;

                if (i == 0)         
                    next = now + 1;
                else if (i == 1)    
                    next = now - 1;
                else               
                    next = now * 2;

                if (next < 0 || next > 100000) 
                    continue;

                if (time[next] == 0) {
                    queue.add(next);
                    time[next] = time[now] + 1;
                    parent[next] = now;
                }
            }
        }
    }
}