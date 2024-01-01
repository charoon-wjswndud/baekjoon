import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger N = new BigInteger(br.readLine());

        BigInteger left = BigInteger.ONE;
        BigInteger right = N;
        BigInteger mid;
        while (true) {
            mid = left.add(right).divide(new BigInteger("2"));
            int result = mid.multiply(mid).compareTo(N);
            if (result == 0)
                break;
            else if (result == 1)
                right = mid.subtract(BigInteger.ONE);
            else
                left = mid.add(BigInteger.ONE);

        }
        System.out.println(mid);
    }
}