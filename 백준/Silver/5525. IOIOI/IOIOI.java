import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		char[] S = br.readLine().toCharArray();

		int result = 0, cnt = 0;
		for(int i=1; i < M - 1; i++) {
			if((S[i-1] == 'I') && (S[i] == 'O') && (S[i+1] == 'I')) {
				cnt++;
				if(cnt == N) {
					cnt--;
					result++;
				}
				i++;
			}
			else 
				cnt = 0;
		}
		System.out.println(result);
	}
}
