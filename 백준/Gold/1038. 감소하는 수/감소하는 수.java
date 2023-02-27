import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();

		List<Long> list = new ArrayList<>();

		for (int i = 1; i <= 10; i++) {
			boolean[] visited = new boolean[10];
			calcSubset(visited, list, 0, i);
		}
		Collections.sort(list);
		try {
			System.out.print(list.get(num));
		} catch (IndexOutOfBoundsException e) {
			System.out.print(-1);
		}
	}

	private static void calcSubset(boolean[] visited, List<Long> list, int start, int i) {
		if (i == 0) {
			StringBuilder sb = new StringBuilder();
			for (int idx = 0; idx < 10; idx++) {
				if(visited[idx]) sb.append(idx);
			}
			list.add(Long.parseLong(sb.reverse().toString()));
		}
		for (int j = start; j < 10; j++) {
			visited[j] = true;
			calcSubset(visited, list, j+1, i-1);
			visited[j] = false;
		}
	}
}
