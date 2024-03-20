import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] cards = new int[N];
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        int[] LIS = new int[N];
        Arrays.fill(LIS, 1);

        for (int now = 1; now < N; now++) {
            for (int prev = 0; prev < now; prev++) {
                if (cards[now] > cards[prev] && LIS[now] < LIS[prev] + 1) {
                    LIS[now] = LIS[prev] + 1;
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int n :
                LIS) {
            max = Math.max(max, n);
        }

        System.out.println(max);
    }
}