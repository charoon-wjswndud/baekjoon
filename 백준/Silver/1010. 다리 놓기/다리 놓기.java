import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] pascalTriangle = new int[30][30];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			sb.append(combi(M, N)).append('\n');
		}
		System.out.println(sb);
	}
	static int combi(int n, int r) {
		if(pascalTriangle[n][r] > 0) {
			return pascalTriangle[n][r]; 
		}
		if(n == r || r == 0) {
			return pascalTriangle[n][r] = 1;
		}
		return pascalTriangle[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
	}
}
