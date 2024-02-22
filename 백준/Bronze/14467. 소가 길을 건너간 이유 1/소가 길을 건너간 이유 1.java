import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        final int NONE = -1, RIGHT = 1, LEFT = 0;
        int[] cows = new int[N+1];
        Arrays.fill(cows, -1);

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int site = Integer.parseInt(st.nextToken());


            if (cows[num] == NONE) {
                cows[num] = site;
                continue;
            }

            if (cows[num] == site)
                continue;

            cnt++;
            if (cows[num] == RIGHT)
                cows[num] = LEFT;
            else
                cows[num] = RIGHT;

        }

        System.out.println(cnt);
    }
}