import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(A, 1));
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            if (now.num == B) {
                System.out.println(now.cnt);
                return;
            }
            if (now.num*2 <= B)
                queue.add(new Node(now.num*2, now.cnt+1));
            if (now.num*10+1 <= B)
                queue.add(new Node(now.num*10+1, now.cnt+1));
        }

        System.out.println(-1);
    }

    public static class Node {
        long num;
        int cnt;

        public Node(long num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }
}