import java.util.StringTokenizer;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int Z = calcWinningRate(X, Y);

        int ans = -1;
        int left = 0;
        int right = 1_000_000_000;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (calcWinningRate(X + mid, Y + mid) != Z) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(ans);
    }

    private static int calcWinningRate(int x, int y) {
        return (int) ((long) y * 100 / x);
    }
}