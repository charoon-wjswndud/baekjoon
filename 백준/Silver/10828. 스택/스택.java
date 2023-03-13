import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EmptyStackException;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Stack<String> stack = new Stack<>();
		for (int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			if (s.equals("push")) {
				stack.add(st.nextToken());
				continue;
			}
			else if(s.equals("pop")) {
				try {
					sb.append(stack.pop());
				} catch (EmptyStackException e) {
					sb.append(-1);
				}
			}else if(s.equals("size")) sb.append(stack.size());
			else if(s.equals("empty")) sb.append(stack.isEmpty()?1:0);
			else {
				try {
					sb.append(stack.peek());
				} catch (EmptyStackException e){
					sb.append(-1);
				}
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
