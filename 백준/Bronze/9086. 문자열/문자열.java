import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            char[] string = br.readLine().toCharArray();
            sb.append(string[0]).append(string[string.length - 1]).append("\n");
        }

        System.out.print(sb);
    }
}