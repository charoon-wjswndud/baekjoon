import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Stack<Integer> line = new Stack<>();
        Stack<Integer> temp = new Stack<>();
        boolean[] tempCheck = new boolean[N+1];
        String[] tempArr = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            line.add(Integer.parseInt(tempArr[N-1-i]));
        }

        for (int order = 1; order <= N; order++) {
            if (!temp.isEmpty()) {
                if (temp.peek() == order) {
                    temp.pop();
                    continue;
                }
                if (tempCheck[order]) {
                    System.out.println("Sad");
                    return;
                }
            }

            while (line.peek() != order) {
                temp.push(line.pop());
                tempCheck[temp.peek()] = true;
            }
            line.pop();
        }

        System.out.println("Nice");
    }
}
