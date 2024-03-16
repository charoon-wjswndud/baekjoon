import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] prefixArr = new int[N+1];
        for (int i = 1; i <= N; i++) {
            prefixArr[i] = prefixArr[i - 1] + Integer.parseInt(st.nextToken());
        }

        int result = Integer.MIN_VALUE;
        for (int i = K; i <= N; i++) {
            result = Math.max(result, prefixArr[i] - prefixArr[i-K]);
        }

        System.out.println(result);
    }
}