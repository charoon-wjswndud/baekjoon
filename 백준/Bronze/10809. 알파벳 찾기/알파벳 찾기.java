import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();
		StringBuilder sb = new StringBuilder();
		for (int i = 'a'; i <= 'z'; i++) {
			sb.append(word.indexOf(i)).append(" ");
		}

		System.out.println(sb);
	}
}
