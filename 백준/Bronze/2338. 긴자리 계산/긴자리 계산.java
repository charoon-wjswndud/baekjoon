import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger first = new BigInteger(br.readLine());
        BigInteger second = new BigInteger(br.readLine());

        System.out.println(first.add(second));
        System.out.println(first.subtract(second));
        System.out.print(first.multiply(second));

    }
}