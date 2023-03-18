import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int n = 0; n < N; n++) {
			for (int start = 0; start <= n; start++) {
				sb.append("*");
			}
			sb.append("\n");
		}

		System.out.print(sb);
	}
}
