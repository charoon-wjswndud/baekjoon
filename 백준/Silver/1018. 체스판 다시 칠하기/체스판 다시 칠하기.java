import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
	static boolean[][] board;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		board = new boolean[N][M];
		//W == true
		//B == false
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++)
				board[i][j] = line.charAt(j) == 'W';
		}

		int minCnt = Integer.MAX_VALUE;
		for (int i = 0; i <= N-8; i++)
			for (int j = 0; j <= M-8; j++) {
				int[] arr = changeBitMasking(i, j);
				for (int k = 0; k < 2; k++) {
					int cnt = paint(k, arr);
					minCnt = Math.min(minCnt, cnt);
				}
			}

		System.out.println(minCnt);
	}

	private static int paint(int k, int[] arr) {
		int paintCnt = 0;
		for (int i = 0; i < 8; i++) {
			int checkNum = 0;
			if ((i+k)%2 == 0)
				checkNum = 170;
			else
				checkNum = 85;
			paintCnt += Integer.bitCount(arr[i] ^ checkNum);
		}
		return paintCnt;
	}

	private static int[] changeBitMasking(int r, int c){
		int[] arr = new int[8];
		for (int i = 0; i < 8; i++) {
			int num = 0;
			for (int j = 0; j < 8; j++)
				if (board[r+i][c+j])
					num |= (1 << 7-j);
			arr[i] = num;
		}
		return arr;
	}
}
