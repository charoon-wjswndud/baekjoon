import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N; 
	static int M;
	static int[] arr;
	static boolean[] visitied;
	static int maxNum;
	static int sM;
	static int sum;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.delete(0, sb.length());
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			arr = new int[N];
			for(int i = 0;i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			maxNum = Integer.MIN_VALUE;
			visitied = new boolean[N];
			comb(0, 0);
			if (maxNum < 0) maxNum = -1;
			sb.append("#" + test_case + " " + maxNum);
			System.out.println(sb);
		}
	}

	private static void comb(int count, int sum) {
		if(sum > M) return;
		if(count == 2) {
			maxNum = Math.max(sum, maxNum);
			return;
		}
		for(int i = 0; i < N; i++ ) {
			if(!visitied[i]) {
				visitied[i] = true;
				comb(count+1, sum + arr[i]);
				visitied[i] = false;
			}
		}
	}
}