import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N + 1];
        Deque<Integer> deque = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            deque.add(i);
        }

        while (deque.size() > 1) {
            int num = deque.pollFirst();
            sb.append(num).append(" ");
            if (arr[num] > 0)
                turnRight(deque, Math.abs(arr[num]));
            else
                turnLeft(deque, Math.abs(arr[num]));
        }

        sb.append(deque.poll()).append(" ");
        System.out.println(sb);
    }

    private static void turnLeft(Deque<Integer> deque, int cnt) {
        for (int i = 0; i < cnt; i++) {
            deque.addFirst(deque.pollLast());
        }
    }

    private static void turnRight(Deque<Integer> deque, int cnt) {
        for (int i = 1; i < cnt; i++) {
            deque.addLast(deque.pollFirst());
        }
    }
}