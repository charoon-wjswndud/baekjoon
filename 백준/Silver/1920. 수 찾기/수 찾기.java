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

		StringBuilder sb = new StringBuilder();
		for (int m = 0; m < M; m++) {
			sb.append(binarySearch(arr, Integer.parseInt(st.nextToken()), 0, arr.length-1) ? 1 : 0).append("\n");
		}
		System.out.print(sb);
	}

	private static boolean binarySearch(int[] arr, int num, int min, int max) {
		if(min <= max) {
			int mid = (min + max) / 2;
			if(arr[mid] == num)
				return true;
			else if(num < arr[mid])
				return binarySearch(arr, num, min, mid-1);
			else
				return binarySearch(arr, num, mid+1, max);
		}
		return false;
	}
}
