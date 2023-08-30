import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static long[] arr = new long[100];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		arr[0] = 1;
		arr[1] = 1;
		arr[2] = 1;
		arr[3] = 2;
		arr[4] = 2;
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			if (N < 4)
				sb.append(1).append("\n");
			else if (N < 6)
				sb.append(2).append("\n");
			else {
				for (int j = 5; j < N; j++)
					arr[j] = arr[j - 1] + arr[j - 5];
				sb.append(arr[N-1]).append("\n");
			}
		}
		System.out.print(sb);
	}
}
