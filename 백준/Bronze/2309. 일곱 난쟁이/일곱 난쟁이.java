import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[9];

		int total = 0;
		for (int i = 0; i < 9; i++) {
			total += arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (i == j)
					continue;
				if (total - (arr[i] + arr[j]) != 100)
					continue;
				for (int k = 0; k < 9; k++) {
					if (k == i || k == j)
						continue;
					sb.append(arr[k]).append("\n");
				}
				System.out.print(sb);
				return;
			}
		}
	}
}
