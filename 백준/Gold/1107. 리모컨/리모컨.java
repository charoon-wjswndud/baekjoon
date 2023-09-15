import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		boolean[] brokenButton = new boolean[10];
		
		StringTokenizer st = null;
		if (M != 0)
			st = new StringTokenizer(br.readLine());
		for(int i = 0; i<M; i++) {
			int button = Integer.parseInt(st.nextToken());
			brokenButton[button] = true;
		}

		int min = Math.abs(100-N);

		chanel:
		for(int i = 0; i<=999999; i++) {
			int cnt = 0;
			char[] chanel = String.valueOf(i).toCharArray();
			for (char c : chanel)
				if (brokenButton[c - '0'])
					continue chanel;

			cnt = chanel.length + Math.abs(i-N);
			min = Math.min(cnt, min);
		}
		System.out.println(min);
	}
}
