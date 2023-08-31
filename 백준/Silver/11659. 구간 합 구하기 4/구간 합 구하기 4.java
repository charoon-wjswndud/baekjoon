import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int[] dp = new int[11];
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		int[] sum = new int[N];
		sum[0] = arr[0];
		for (int i = 1; i < N; i++)
			sum[i] = arr[i] + sum[i-1];
		StringBuilder sb = new StringBuilder();
		for (int k = 0; k < M; k++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken())-2;
			int j = Integer.parseInt(st.nextToken())-1;
			int result = 0;
			if (i == -1)
				result = sum[j];
			else
				result = sum[j] - sum[i];
			sb.append(result).append("\n");
		}
		System.out.print(sb);
	}
}
