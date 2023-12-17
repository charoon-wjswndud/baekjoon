import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] participants = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        Queue<Participant> queue = new LinkedList<>();
        for (int i = 0; i < N; i++)
            queue.add(new Participant(i, Integer.parseInt(st.nextToken())));

        int time = 1;
        while (!queue.isEmpty()) {
            Participant now = queue.poll();
            now.pizza--;
            if (now.pizza == 0)
                participants[now.th] = time;
            else
                queue.add(now);
            time++;
        }

        StringBuilder sb = new StringBuilder();
        for (int th :
                participants) {
            sb.append(th).append(" ");
        }

        System.out.println(sb);
    }
    public static class Participant {
        int th;
        int pizza;

        public Participant(int th, int pizza) {
            this.th = th;
            this.pizza = pizza;
        }
    }
}