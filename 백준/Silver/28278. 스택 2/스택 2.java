import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        Stack<String> stack = new Stack<>();
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "1":
                    stack.push(st.nextToken());
                    break;
                case "2":
                    sb.append(stack.isEmpty()?-1:stack.pop()).append("\n");
                    break;
                case "3":
                    sb.append(stack.size()).append("\n");
                    break;
                case "4":
                    sb.append(stack.isEmpty()?1:0).append("\n");
                    break;
                case "5":
                    sb.append(stack.isEmpty()?-1:stack.peek()).append("\n");
                    break;
            }
        }
        System.out.print(sb);
    }
}