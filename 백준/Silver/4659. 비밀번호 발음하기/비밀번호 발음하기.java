import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			String password = br.readLine();
			if (password.equals("end"))
				break;

			sb.append("<").append(password).append("> ");

			if (!check1(password)
					|| !check2(password)
					|| !check3(password)
			) {
				sb.append("is not acceptable.").append("\n");
				continue;
			}
			sb.append("is acceptable.").append("\n");
		}

		System.out.print(sb);
	}

	private static boolean check3(String password) {
		char[] pwArr = password.toCharArray();
		char prev = pwArr[0];
		for (int i = 1; i < pwArr.length; i++) {
			if (prev == 'e' && pwArr[i] == 'e')
				continue;
			if (prev == 'o' && pwArr[i] == 'o')
				continue;
			if (prev == pwArr[i])
				return false;
			prev = pwArr[i];
		}
		return true;
	}

	private static boolean check2(String password) {
		char[] pwArr = password.toCharArray();
		int cnt = 1;
		boolean prev = isGather(pwArr[0]);

		for (int i = 1; i < pwArr.length; i++) {
			boolean now = isGather(pwArr[i]);
			if (prev != now) {
				prev = now;
				cnt = 1;
				continue;
			}
			if (++cnt == 3)
				return false;
		}
		return true;
	}

	private static boolean check1(String password) {
		for (char c :
			password.toCharArray()) {
			if (isGather(c))
				return true;
		}
		return false;
	}

	private static boolean isGather(char c) {
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
	}
}
