import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BigInteger A = new BigInteger(br.readLine());
		BigInteger B = new BigInteger(br.readLine());

		StringBuilder sb = new StringBuilder();
		sb.append(A.add(B)).append("\n").append(A.subtract(B)).append("\n").append(A.multiply(B));
		System.out.print(sb);
	}
}
