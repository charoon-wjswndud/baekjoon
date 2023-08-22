import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < N; i++){
			int num = Integer.parseInt(br.readLine());
			arr[i] = num;
			map.put(num, map.getOrDefault(num, 0)+1);
		}

		StringBuilder sb = new StringBuilder();
		int average = (int)Math.round(Arrays.stream(arr).sum()/(double)N);
		sb.append(average).append("\n");

		Arrays.sort(arr);
		sb.append(arr[N/2]).append("\n");

		int num = Integer.MIN_VALUE;
		for (int n : map.values())
			num = Math.max(num, n);

		List<Integer> list = new LinkedList<>();
		for (int n : map.keySet())
			if (map.get(n) == num)
				list.add(n);

		if(list.size() == 1)
			sb.append(list.get(0)).append("\n");
		else {
			Collections.sort(list);
			sb.append(list.get(1)).append("\n");
		}
		if (arr.length == 1)
			sb.append(0);
		else
			sb.append(arr[N-1] - arr[0]);

		System.out.print(sb);
	}
}
