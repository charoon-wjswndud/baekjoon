import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        for (char c :
                br.readLine().toCharArray()) {
            left.add(c);
        }

        StringTokenizer st;
        int M = Integer.parseInt(br.readLine());
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "L":
                    if (left.isEmpty())
                        continue;
                    right.add(left.pop());
                    break;
                case "D":
                    if (right.isEmpty())
                        continue;
                    left.add(right.pop());
                    break;
                case "B":
                    if (left.isEmpty())
                        continue;
                    left.pop();
                    break;
                case "P":
                    left.push(st.nextToken().charAt(0));
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c :
                left) {
            sb.append(c);
        }
        while (!right.isEmpty()) {
            sb.append(right.pop());
        }
        System.out.println(sb);
    }
}