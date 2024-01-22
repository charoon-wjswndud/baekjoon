import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int UNVISITED = -1;

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] check = new int[100001];
        Arrays.fill(check, UNVISITED);

        check[N] = 0;

        Deque<Integer> deque = new LinkedList<>();
        deque.add(N);

        while (!deque.isEmpty()) {
            int now = deque.poll();

            if (now == K)
                break;

            if (now * 2 <= 100000 && check[now * 2] == -1) {
                deque.addFirst(now * 2);
                check[now * 2] = check[now];
            }

            if (now > 0 && check[now - 1] == UNVISITED) {
                deque.addLast(now - 1);
                check[now - 1] = check[now] + 1;
            }

            if (now < 100000 && check[now + 1] == UNVISITED) {
                deque.addLast(now + 1);
                check[now + 1] = check[now] + 1;
            }
        }

        System.out.println(check[K]);
    }
}