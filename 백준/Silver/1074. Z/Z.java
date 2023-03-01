import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int cnt = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int num = 1 << Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		divideArr(num, r, c);
		System.out.print(cnt);
	}

	private static void divideArr(int num, int r, int c) {
		/*
		┌─────┬─────┐
		│ 0,0 │ 0,1 │
		├─────┼─────┤
		│ 1,0 │ 1,1 │
		└─────┴─────┘
		 */
		if(num == 1)
			return;

		//0, 0
		if(r < num/2 && c < num/2) {
			divideArr(num/2, r, c);
		}

		//0, 1
		else if(r < num/2 && c >= num/2) {
			cnt += num * num / 4;
			divideArr(num/2, r, c - num/2);
		}

		//1, 0
		else if(r >= num/2 && c < num/2) {
			cnt += (num * num / 4) * 2;
			divideArr(num/2, r - num/2, c);
		}

		//1, 1
		else {
			cnt += (num * num / 4) * 3;
			divideArr(num/2, r - num/2, c - num/2);
		}
	}
}
