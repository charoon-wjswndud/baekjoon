import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[6];
        for (int i = 0; i < 6; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        if (N == 1) {
            Arrays.sort(arr);
            int sum = 0;
            for (int i = 0; i < 5; i++) {
                sum += arr[i];
            }
            System.out.println(sum);
            return;
        }

        long[] num = new long[4];
        num[1] = (N - 2) * (N - 2) + 4 * (N - 2) * (N - 1);
        num[2] = (N - 2) * 4 + (N - 1) * 4;
        num[3] = 4;

        long result = 0;

        long min = arr[0];
        for (int i = 1; i < 6; i++)
            min = Math.min(min, arr[i]);
        result += num[1] * min;

        min = Long.MAX_VALUE;
        for (int i = 0; i < 6; i++)
            for (int j = i + 1; j < 6; j++)
                if (j + i != 5)
                    min = Math.min(min, arr[i] + arr[j]);
        result += num[2] * min;

        min = 0;
        for (int i = 0; i < 3; i++)
            min += Math.min(arr[i], arr[5 - i]);
        result += num[3] * min;

        System.out.println(result);
    }
}