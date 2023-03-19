import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());

		int[] arr = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for (int n = 1; n <= N; n++) {
			arr[n] = arr[n-1] + Integer.parseInt(st.nextToken());
		}

		int minLength = Integer.MAX_VALUE;
		int tail = 0;
		int head = 1;
		while (head < N+1) {
			if (arr[head] - arr[tail] < S) {
				head++;
			}else {
				minLength = Math.min(minLength, head-tail);
				tail++;
			}
		}

		System.out.println(minLength!=Integer.MAX_VALUE?minLength:0);
	}
}
