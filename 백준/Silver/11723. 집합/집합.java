import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		int masking = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			int x = 0;
			if (st.hasMoreTokens())
				x = Integer.parseInt(st.nextToken());
			switch (command) {
				case "add":
					masking |= 1<<x;
					break;
				case "remove":
					masking &= ~(1<<x);
					break;
				case "check":
					if ((masking | (1<<x)) == masking)
						sb.append(1).append("\n");
					else
						sb.append(0).append("\n");
					break;
				case "toggle":
					masking ^= 1<<x;
					break;
				case "all":
					masking = (int) Math.pow(2, 21) -1;
					break;
				case "empty":
					masking = 0;
					break;
			}
		}
		System.out.print(sb);
	}
}
