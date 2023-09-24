import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[N];
		dp[0] = 1;
		for (int i = 1; i < N; i++) {
			int maxCnt = 0;
			for (int j = 0; j < i; j++) {
				if (arr[i] <= arr[j])
					continue;
				maxCnt = Math.max(maxCnt, dp[j]);
			}
			dp[i] = maxCnt+1;
		}

		int maxNum = 0;
		for (int num : dp) {
			maxNum = Math.max(maxNum, num);
		}
		System.out.println(maxNum);
	}
}
