import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] x = new int[M];
        for (int i = 0; i < M; i++)
            x[i] = Integer.parseInt(st.nextToken());

        int left = 1;
        int right = N;
        int result = 0;

        while(left <= right) {
            int mid = (left + right) / 2;

            if (possible(N, x, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(result);
    }
    static boolean possible (int N, int[] x, int target) {
        int prev = 0;

        for (int i = 0; i < x.length; i++) {
            if (x[i] - target <= prev)
                prev = x[i] + target;
            else
                return false;
        }
        return N - prev <= 0;
    }
}