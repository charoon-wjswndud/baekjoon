import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		int[] top = new int[H+1];
		int[] bottom = new int[H+1];

		for (int n = 0; n < N; n++) {
			int i = Integer.parseInt(br.readLine());

			if (n%2 == 0) bottom[i]++;
			else top[H-i+1]++;
		}

		//bottom 누적합
		int[] prefixTop = new int[H+1];
		for (int i = 1; i <= H; i++) {
			prefixTop[i] = prefixTop[i-1]+top[i];
		}

		//top 누적합
		int[] prefixBottom = new int[H+1];
		for (int i = H-1; i > 0; i--) {
			prefixBottom[i] = prefixBottom[i+1]+bottom[i];
		}

		//최종벽
		int[] wall = new int[H+1];
		for (int i = 1; i <= H; i++) {
			wall[i] = prefixTop[i] + prefixBottom[i];
		}
		int minNum = Integer.MAX_VALUE;
		for (int i = 1; i <= H; i++) {
			minNum = Math.min(minNum, wall[i]);
		}
		int cnt = 0;
		for (int i = 1; i <= H; i++) {
			if (minNum == wall[i]) cnt++;
		}
		System.out.print(minNum + " " + cnt);
	}
}
