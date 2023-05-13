import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.sorted()
				.toArray();

		int M = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int m = 0; m < M; m++) {

			//카드 검색
			int target = Integer.parseInt(st.nextToken());

			sb.append(upperBound(arr, target) - lowerBound(arr, target)).append(" ");
		}
		System.out.print(sb);
	}

	private static int upperBound(int[] arr, int target) {
		int min = 0;
		int max = arr.length;

		while (min < max) {
			int mid = (min + max) / 2;

			if (target < arr[mid])
				max = mid;
			else
				min = mid + 1;
		}
		return min;
	}

	private static int lowerBound(int[] arr, int target) {
		int min = 0;
		int max = arr.length;

		while (min < max) {
			int mid = (min + max) / 2;

			if (target <= arr[mid])
				max = mid;
			else
				min = mid + 1;
		}

		return min;
	}
}
