import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		Queue<String> queue = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		String last = null;
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			switch (st.nextToken()){
				case "push":
					last = st.nextToken();
					queue.add(last);
					break;
				case "pop":
					if (queue.isEmpty()) sb.append(-1);
					else sb.append(queue.poll());
					sb.append("\n");
					break;
				case "size":
					sb.append(queue.size());
					sb.append("\n");
					break;
				case "empty":
					if (queue.isEmpty()) sb.append(1);
					else sb.append(0);
					sb.append("\n");
					break;
				case "front":
					if (queue.isEmpty()) sb.append(-1);
					else sb.append(queue.peek());
					sb.append("\n");
					break;
				case "back":
					if (queue.isEmpty()) sb.append(-1);
					else sb.append(last);
					sb.append("\n");
					break;
			}
		}
		System.out.print(sb);
	}

}
