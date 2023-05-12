import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.sorted()
				.toArray();

		int M = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int m = 0; m < M; m++)
			System.out.print(binarySearch(arr, Integer.parseInt(st.nextToken()), 0, N-1) + " ");

	}

	private static int binarySearch(int[] arr, int target, int min, int max) {
		if (min > max) return 0;

		int mid = (min + max) / 2;
		if(arr[mid] == target)
			return 1;
		else if(arr[mid] < target)
			return binarySearch(arr, target, mid+1, max);
		else
			return binarySearch(arr, target, min, mid-1);
	}
}
