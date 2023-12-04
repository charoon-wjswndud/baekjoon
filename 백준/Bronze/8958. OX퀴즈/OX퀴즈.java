import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int cnt = 0;
            int sum = 0;
            for (byte value : br.readLine().getBytes()) {
                if (value == 'O') {
                    cnt++;
                    sum += cnt;
                } else
                    cnt = 0;
            }
            sb.append(sum).append('\n');
        }
        System.out.print(sb);
    }
}