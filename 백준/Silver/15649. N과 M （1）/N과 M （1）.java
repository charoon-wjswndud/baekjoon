import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[N+1];

        solution(sb, visited, 0);

        System.out.print(sb);
    }

    private static void solution(StringBuilder sb, boolean[] visited, int cnt) {
        if (cnt == M) {
            for (int num : stack)
                sb.append(num).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (visited[i])
                continue;
            visited[i] = true;
            stack.push(i);
            solution(sb, visited, cnt+1);
            visited[i] = false;
            stack.pop();
        }
    }
}