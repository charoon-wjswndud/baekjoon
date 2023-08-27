import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		Set<String> set = new HashSet<>();

		int M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++)
			set.add(br.readLine());

		List<String> list = new LinkedList<>();
		for (int i = 0; i < M; i++) {
			String line = br.readLine();
			if (set.contains(line))
				list.add(line);
		}

		Collections.sort(list);

		StringBuilder sb = new StringBuilder();
		sb.append(list.size()).append("\n");
		for (String name : list)
			sb.append(name).append("\n");

		System.out.print(sb);
	}
}

