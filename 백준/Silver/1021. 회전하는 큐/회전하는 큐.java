import java.io.*;
import java.util.*;

public class Main {
    public static Deque<Integer> deque;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] set = new int[M];
        for (int i = 0; i < M; i++)
            set[i] = Integer.parseInt(st.nextToken());

        deque = new LinkedList<>();
        for (int i = 1; i <= N; i++)
            deque.addLast(i);

        int cnt = 0;
        for (int num : set) {
            if (deque.peekFirst() == num) {
                deque.removeFirst();
                continue;
            }

            int targetIndex = ((LinkedList) deque).indexOf(num);
            int halfIndex;
            if (deque.size()%2 == 1)
                halfIndex = deque.size()/2;
            else
                halfIndex = deque.size()/2-1;

            if (halfIndex >= targetIndex) {
                while (num != deque.peekFirst()) {
                    moveLeft();
                    cnt++;
                }
            } else {
                while (num != deque.peekFirst()) {
                    moveRight();
                    cnt++;
                }
            }
            deque.removeFirst();
        }

        System.out.println(cnt);
    }

    private static void moveLeft() {
        deque.addLast(deque.removeFirst());
    }

    private static void moveRight() {
        deque.addFirst(deque.removeLast());
    }
}