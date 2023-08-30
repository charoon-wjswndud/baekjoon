import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			int day = 1;
			int N = Integer.parseInt(br.readLine());
			Map<String, Integer> map = new HashMap<>();
			for (int j = 0; j < N; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				st.nextToken();
				String type = st.nextToken();
				map.put(type, map.getOrDefault(type, 0)+1);
			}

			for (int n :
					map.values()) {
				day *= (n+1);
			}
			sb.append(day-1).append("\n");
		}
		System.out.print(sb);
	}
}
