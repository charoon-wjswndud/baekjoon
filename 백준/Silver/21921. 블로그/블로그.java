import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        arr[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < N; i++)
            arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());

        int maxView = arr[X-1];
        int cnt = 1;

        int index = X;
        while (index < N) {
            int view = arr[index] - arr[index-X];
            if (view == maxView)
                cnt++;
            else if (view > maxView) {
                maxView = view;
                cnt = 1;
            }
            index++;
        }

        StringBuilder sb = new StringBuilder();
        if (maxView == 0)
            sb.append("SAD");
        else
            sb.append(maxView).append("\n").append(cnt);
        System.out.println(sb);
    }
}