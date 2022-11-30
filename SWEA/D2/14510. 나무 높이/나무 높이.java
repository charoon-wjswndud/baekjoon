import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] trees = new int[N];
            int max = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int idx = 0; idx < N; idx++) {
                trees[idx] = Integer.parseInt(st.nextToken());
                max = Math.max(max, trees[idx]);
            }

            int odd = 0;
            int even = 0;
            for (int i = 0; i < N; i++) {
                odd += (max - trees[i]) % 2;
                even += (max - trees[i]) / 2;
            }

            int temp = Math.max(even - odd, 0) / 3;
            odd += temp * 2;
            even -= temp;
            int oddEvenMin = Math.min(odd, even);

            int result = oddEvenMin * 2
                    + Math.max((odd-oddEvenMin) *2-1, 0)
                    + (even - oddEvenMin) / 2 * 3
                    + (even - oddEvenMin) % 2 * 2;


            sb.append("#").append(t).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }
}
