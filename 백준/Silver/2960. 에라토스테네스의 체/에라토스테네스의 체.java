import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] arr = new boolean[N+1];
        arr[0] = true;
        arr[1] = true;

        int cnt = 0;
        for (int i = 2; i <= N; i++) {
            for (int j = i; j <= N; j+=i) {
                if (arr[j])
                    continue;
                arr[j] = true;
                cnt++;

                if (cnt == K) {
                    System.out.println(j);
                    return;
                }
            }
        }
    }
}