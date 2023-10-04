import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        while (0 < N--) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("push")) {
                queue.add(Integer.parseInt(st.nextToken()));
            }else if (command.equals("pop")) {
                if (queue.isEmpty())
                    sb.append(-1);
                else
                    sb.append(queue.poll());
                sb.append("\n");
            } else if (command.equals("size")) {
                sb.append(queue.size()).append("\n");
            } else if (command.equals("empty")) {
                sb.append(queue.isEmpty()?1:0).append("\n");
            } else if (command.equals("front")) {
                if (queue.isEmpty())
                    sb.append(-1);
                else
                    sb.append(queue.peek());
                sb.append("\n");
            } else {
                if (queue.isEmpty())
                    sb.append(-1);
                else
                    sb.append(queue.peekLast());
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }
}