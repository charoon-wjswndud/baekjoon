import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder asb = new StringBuilder();
		while (0 < T--) {
			char[] command = br.readLine().toCharArray();
			int N = Integer.parseInt(br.readLine());
			Deque<Integer> deque = new LinkedList<>();
			StringBuilder temp = new StringBuilder(br.readLine());
			temp.delete(temp.length()-1, temp.length()).delete(0,1);
			StringTokenizer st = new StringTokenizer(temp.toString(), ",");
			for (int i = 0; i < N; i++) {
				deque.add(Integer.parseInt(st.nextToken()));
			}

			StringBuilder sb = new StringBuilder();
			boolean state = true;
			for (int i = 0; i < command.length; i++) {
				if (command[i] == 'R') {
					state = !state;
				}else {
					Integer num = null;
					if (state) {
						num = deque.pollFirst();
					}else
						num = deque.pollLast();
					if (num == null) {
						sb.delete(0, sb.length());
						sb.append("error").append("\n");
						break;
					}
				}
			}
			if (sb.length() == 6) {
				asb.append(sb);
				continue;
			}
			sb.append("[");

			while (!deque.isEmpty()) {
				if (state)
					sb.append(deque.pollFirst());
				else
					sb.append(deque.pollLast());
				sb.append(",");
			}
			if (sb.charAt(sb.length()-1) == ',')
				sb.replace(sb.length()-1,sb.length(), "]").append("\n");
			else
				sb.append("]").append("\n");

			asb.append(sb);
		}
		System.out.println(asb);
	}
}
