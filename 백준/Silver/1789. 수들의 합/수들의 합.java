import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long S = Long.parseLong(br.readLine());
        long sum = 0;
        int cnt = 0;

        while (true) {
            if (S < sum)
                break;
            cnt += 1;
            sum += cnt;
        }

        System.out.println(cnt-1);
    }
}