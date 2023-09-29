import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        int[] dp = new int[1001];
        int[] prev = new int[1001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(dp, 1);
        for (int i = 2; i <= n; i++) {
            int lastJ = 0;
            for (int j = 1; j < i; j++) {
                if (arr[j] >= arr[i])
                    continue;
                if (dp[i] <= dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    lastJ = j;
                }
            }
            prev[i] = lastJ;
        }

        int maxIdx = 1;
        for (int i = 2; i <= n; i++) {
            if (dp[i] <= dp[maxIdx])
                continue;
            maxIdx = i;
        }

        StringBuilder sb = new StringBuilder();

        sb.append(dp[maxIdx]).append("\n");

        List<Integer> list = new LinkedList<>();
        int prevNum = maxIdx;
        while (prev[prevNum] != 0){
            list.add(arr[prevNum]);
            prevNum = prev[prevNum];
        }
        list.add(arr[prevNum]);

        Collections.reverse(list);
        for (Integer num : list)
            sb.append(num).append(" ");
        System.out.println(sb);
    }
}