import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Optional;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		HashMap<Integer, Integer> map = new HashMap<>();
		for (int n = 0; n < N; n++) {
			int key = Integer.parseInt(st.nextToken());
			if (map.containsKey(key))
				map.put(key, map.get(key) + 1);
			else
				map.put(key, 1);
		}

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int m = 0; m < M; m++) {
			int key = Integer.parseInt(st.nextToken());
			if (map.containsKey(key))
				sb.append(map.get(key));
			else
				sb.append(0);

			sb.append(" ");
		}
		System.out.println(sb);
	}
}
