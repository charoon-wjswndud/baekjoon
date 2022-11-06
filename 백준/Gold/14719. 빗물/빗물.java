import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int totalWater = 0;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[] arr = new int[W];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < W - 1; i++) {
            int now = arr[i];
            int maxL = now;
            int maxR = now;

            //왼쪽 최대 벽 탐색
            for (int k = i - 1; k >= 0; k--) {
                if (arr[k] > now) {
                    maxL = Math.max(maxL, arr[k]);
                }
            }

            //오른쪽 최대 벽 탐색
            for (int k = i + 1; k < W; k++) {
                if (arr[k] > now) {
                    maxR = Math.max(maxR, arr[k]);
                }
            }

            //계산
            if (Math.min(maxL, maxR) > now) {
                totalWater += (Math.min(maxL, maxR) - arr[i]);
            }
        }
        System.out.println(totalWater);
    }
}
