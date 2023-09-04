import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] trees = new int[N];
		int max = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			max = Math.max(max, num);
			trees[i] = num;
		}

		int result = binarySearch(trees, M, 0, max);
		System.out.println(result-1);
	}

	private static int binarySearch(int[] trees, int M, int min, int max) {
		if (min >= max)
			return min;
		int mid = (min+max)/2;
		long m = cut(trees, mid);
		if (m < M)
			return binarySearch(trees, M, min, mid);
		else
			return binarySearch(trees, M, mid+1, max);
	}

	private static long cut(int[] trees, int mid) {
		long total = 0;
		for (int tree :
				trees) {
			if (tree > mid)
				total += tree - mid;
		}
		return total;
	}
}
