import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean NON_PRIME = true;
	static boolean PRIME = false;
	static boolean[] sieve = new boolean[1001];
	static int cntPrime = 0;
	public static void main(String[] args) throws IOException {
		//에라토스테네스의체 구현
		sieve[0] = NON_PRIME;
		sieve[1] = NON_PRIME;
		for (int i = 2; i < 1001; i++)
			if (!sieve[i])
				changePrime(i);

		//solution
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++) {
			int num = Integer.parseInt(st.nextToken());
			checkPrime(num);
		}
		System.out.print(cntPrime);
	}

	private static void checkPrime(int num) {
		if(sieve[num] == PRIME)
			cntPrime++;
	}

	private static void changePrime(int i) {
		for (int j = 2; i*j < 1001; j++) {
			sieve[i*j] = NON_PRIME;
		}
	}
}
