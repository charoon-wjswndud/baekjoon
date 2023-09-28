import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n+1];
        int dp[] = new int[1001];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++)
            dp[i] = arr[i] = Integer.parseInt(st.nextToken());

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (arr[j] >= arr[i])
                    continue;
                dp[i] = Math.max(dp[j] + arr[i], dp[i]);
            }
        }

        int maxNum = 0;
        for (int i = 1; i <= n; i++) {
            maxNum = Math.max(dp[i], maxNum);
        }

        System.out.println(maxNum);
    }
}