import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] set = new int[M];
        int[] one = new int[M];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            set[i] = Integer.parseInt(st.nextToken());
            one[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(set);
        Arrays.sort(one);

        int total = 0;

        //패키지 + 낱개
        int a = N/6*set[0] + N%6*one[0];
        //패키지
        int b = N/6*set[0];
        if (N%6 != 0)
            b += set[0];
        //낱개
        int c = one[0] * N;

        System.out.println((a < b) ? ((a < c) ? a : c) : ((b < c) ? b : c));
    }
}