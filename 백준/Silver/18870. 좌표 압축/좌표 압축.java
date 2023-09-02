import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int arr[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		List<Integer> list = new ArrayList<>();
		for (int n : arr)
			list.add(n);
		Collections.sort(list);
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0, j = 0; i < list.size(); i++) {
			if (map.containsKey(list.get(i)))
				continue;
			map.put(list.get(i), j++);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(map.get(arr[i])).append(" ");
		}

		System.out.println(sb);
	}
}
