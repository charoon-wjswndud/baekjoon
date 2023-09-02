import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int blue = 0, white = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[][] paper = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				paper[i][j] = st.nextToken().equals("1");
		}
		solution(paper, N, 0, 0);
		System.out.println(white);
		System.out.println(blue);
	}

	private static void solution(boolean[][] paper, int n, int y, int x) {
		if (n == 1 || isAllTrueOrAllFalse(paper, n, y, x)) {
			if(paper[y][x])
				blue++;
			else
				white++;
			return;
		}
		//2사분면
		solution(paper, n/2, y, x);
		//1사분면
		solution(paper, n/2, y, x+n/2);
		//3사분면
		solution(paper, n/2, y+n/2, x);
		//4사분면
		solution(paper, n/2, y+n/2, x+n/2);
	}

	private static boolean isAllTrueOrAllFalse(boolean[][] paper, int n, int y, int x) {
		boolean state = paper[y][x];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				if (state != paper[y+i][x+j])
					return false;
		return true;
	}

}
