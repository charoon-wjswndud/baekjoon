import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        LinkedList<Integer> deque = new LinkedList<Integer>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= N; i++)
            deque.offer(i);

        int[] arr = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int cnt = 0;
        for(int i = 0; i < M; i++) {
            int targetIdx = deque.indexOf(arr[i]);
            int halfIdx;

            if(deque.size() % 2 == 0)
                halfIdx = deque.size() / 2 - 1;
            else
                halfIdx = deque.size() / 2;

            if(targetIdx <= halfIdx) {
                for(int j = 0; j < targetIdx; j++) {
                    deque.offerLast(deque.pollFirst());
                    cnt++;
                }
            } else {
                for(int j = 0; j < deque.size() - targetIdx; j++) {
                    deque.offerFirst(deque.pollLast());
                    cnt++;
                }
            }
            deque.pollFirst();
        }
        System.out.println(cnt);
    }
}