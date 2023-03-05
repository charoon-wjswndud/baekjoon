import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringTokenizer st0 = new StringTokenizer(line, "0");
        StringTokenizer st1 = new StringTokenizer(line, "1");
        System.out.println(Math.min(st0.countTokens(), st1.countTokens()));
    }
}