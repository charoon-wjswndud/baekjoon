import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		while (0 < T--) {
			int N = Integer.parseInt(br.readLine());
			String[] mbti = new String[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++)
				mbti[i] = st.nextToken();

			if (32 < N) {
				sb.append(0).append("\n");
				continue;
			}

			int min = Integer.MAX_VALUE;

			for (int i = 0; i < N; i++) {
				for (int j = i+1; j < N; j++) {
					for (int k = j+1; k < N; k++) {
						int count = 0;
						for (int l = 0; l < 4; l++) {
							count += mbti[i].charAt(l) == mbti[j].charAt(l) ? 0 : 1;
							count += mbti[i].charAt(l) == mbti[k].charAt(l) ? 0 : 1;
							count += mbti[j].charAt(l) == mbti[k].charAt(l) ? 0 : 1;
						}
						min = Math.min(min, count);
					}
				}
			}
			sb.append(min).append("\n");
		}
		System.out.print(sb.toString());
	}
}
