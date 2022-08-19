import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static boolean state;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		boolean[][] arr = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = line.charAt(j)-'0' == 1 ? true : false;
			}
		}
		
		compress(arr, 0, 0, N, sb);
		
		System.out.println(sb);
	}

	private static void compress(boolean[][] arr, int y, int x, int size, StringBuilder sb) {
		if(isCompressPossible(arr, y, x, size)) {
			sb.append(arr[y][x]?1:0);
			return;
		}else {
			int nSize = size/2;
			
			sb.append('(');
			
			//좌상
			compress(arr, y, x, nSize, sb);
			
			//우상
			compress(arr, y, x + nSize, nSize, sb);
			
			//좌하
			compress(arr, y + nSize, x, nSize, sb);
			
			//우하
			compress(arr, y + nSize, x + nSize, nSize, sb);
			
			sb.append(')');
		}
	}

	private static boolean isCompressPossible(boolean[][] arr, int y, int x, int size) {
		boolean temp = arr[y][x];
		
		for (int i = y; i < y + size; i++) {
			for (int j = x; j < x + size; j++) {
				if(arr[i][j] != temp) return false; 
			}
		}
		return true;
	}

}
