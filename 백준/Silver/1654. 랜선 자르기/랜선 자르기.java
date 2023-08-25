import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		int[] lines = new int[K];
		long row = 1, mid = 0, high = 0;
		for (int i = 0; i < K; i++) {
			lines[i] = Integer.parseInt(br.readLine());
			high = Math.max(lines[i], high);
		}

		while (row <= high) {
			mid = (row + high) / 2;
			long len = cut(lines, mid);
			if (len < N)
				high = mid -1;
			else
				row = mid + 1;
		}
		System.out.print(high);
	}

	private static long cut(int[] lines, long mid) {
		long cnt = 0;
		for (int line : lines)
			cnt += line/mid;
		return cnt;
	}
}
