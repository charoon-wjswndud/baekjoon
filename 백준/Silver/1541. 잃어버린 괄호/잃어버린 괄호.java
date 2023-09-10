import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer minus = new StringTokenizer(br.readLine(), "-");
		int cntMinus = minus.countTokens();

		int result = 0;
		for (int i = 0; i < cntMinus; i++) {
			StringTokenizer plus = new StringTokenizer(minus.nextToken(), "+");

			int temp = 0;
			while (plus.hasMoreTokens()) {
				temp += Integer.parseInt(plus.nextToken());
			}
			if (0 < i)
				result -= temp;
			else
				result = temp;
		}

		System.out.println(result);
	}
}
