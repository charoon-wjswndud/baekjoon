import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		Deque<Integer> deque = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			Integer X = null;
			switch (command) {
				case "push_front":
					deque.addFirst(Integer.parseInt(st.nextToken()));
					break;
				case "push_back":
					deque.addLast(Integer.parseInt(st.nextToken()));
					break;
				case "pop_front":
					X = deque.pollFirst();
					if (X != null)
						sb.append(X).append("\n");
					else
						sb.append("-1").append("\n");
					break;
				case "pop_back":
					X = deque.pollLast();
					if (X != null)
						sb.append(X).append("\n");
					else
						sb.append("-1").append("\n");
					break;
				case "size":
					sb.append(deque.size()).append("\n");
					break;
				case "empty":
					sb.append(deque.isEmpty()?1:0).append("\n");
					break;
				case "front":
					if(!deque.isEmpty())
						sb.append(deque.getFirst()).append("\n");
					else
						sb.append("-1").append("\n");
					break;
				case "back":
					if(!deque.isEmpty())
						sb.append(deque.getLast()).append("\n");
					else
						sb.append("-1").append("\n");
					break;
			}
		}
		System.out.print(sb);
	}
}
