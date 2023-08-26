import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		String[] arr = new String[N+1];
		Map<String, Integer> map = new HashMap<>();
		int M = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= N; i++){
			arr[i] = br.readLine();
			map.put(arr[i], i);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			String line = br.readLine();
			if (line.charAt(0) <= '9')
				sb.append(arr[Integer.parseInt(line)]).append("\n");
			else
				sb.append(map.get(line)).append("\n");
		}
		System.out.println(sb);
	}
}
