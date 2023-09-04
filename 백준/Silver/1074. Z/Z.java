import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int r, c;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		int result = DivideConquer(N, 0, 0, 0);
		System.out.println(result);
	}

	private static int DivideConquer(int n, int y, int x, int cnt) {
		if (n == 0) {
			return cnt;
		}
		int num = (int) Math.pow(2, n)/2;
		int quadrant = calcQuadrant(n, y, x);
		if (quadrant == 1)
			return DivideConquer(n-1, y, x+num, cnt + num*num);
		else if ( quadrant == 2)
			return DivideConquer(n-1, y, x, cnt);
		else if ( quadrant == 3)
			return DivideConquer(n-1, y+num, x, cnt+num*num*2);
		else
			return DivideConquer(n-1, y+num, x+num, cnt + num*num*3);
	}

	private static int calcQuadrant(int n, int y, int x) {
		int num =(int) Math.pow(2,n)/2;
		if (r < y + num)
			if (c < x + num)
				return 2;
			else
				return 1;
		else
			if (c < x + num)
				return 3;
			else
				return 4;
	}
}
