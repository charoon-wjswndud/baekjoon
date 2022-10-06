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
            sb.append("#").append(t).append(" ");
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            int[] length = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int k = 0; k < N; k++) {
                length[k] = 1;
                for (int i = 0; i < k; i++) {
                    if(arr[i] < arr[k]){
                        length[k] = Math.max(length[k], length[i]+1);
                    }
                }
            }
            int max = length[0];
            for (int num :
                    length) {
                max = Math.max(num, max);
            }
            sb.append(max).append("\n");
        }
        System.out.println(sb);
    }
}
