import java.io.*;

public class Main {
	public static StringBuilder X = new StringBuilder("0");
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long k = Long.parseLong(br.readLine());

		System.out.println(loop(k));
	}

	private static long loop(long x) {
		if (x == 1)
			return 0;
		long i = 1;
		while (i+i < x)
			i+=i;

		return loop(x - i) == 0 ? 1 : 0;
	}
}
