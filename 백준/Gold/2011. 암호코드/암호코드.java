import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String code = br.readLine();

		if(code.length() == 0 || code.charAt(0) == '0') {
			System.out.println(0);
			return;
		}

		int[] dp = new int[code.length()+1];
		dp[0] = 1;
		dp[1] = 1;
		for (int idx = 2; idx <= code.length(); idx++) {
			char nowChar = code.charAt(idx-1);
			char prevChar = code.charAt(idx-2);
			if(nowChar == '0') {
				if(prevChar == '1' || prevChar == '2'){
					dp[idx] = dp[idx-2] % 1000000;
				}else break;
			} else {
				if(prevChar == '0') {
					dp[idx] = dp[idx-1] % 1000000;
				}else {
					int num = (prevChar - '0') * 10 + (nowChar - '0');

					if(0< num && num <27) {
						dp[idx] = (dp[idx-2] + dp[idx-1]) % 1000000;
					}else {
						dp[idx] = dp[idx - 1] % 1000000;
					}
				}
			}
		}
		System.out.println(dp[code.length()] % 1000000);
	}
}
