import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        boolean[][] map = new boolean[100][100];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int leftMargin = Integer.parseInt(st.nextToken());
            int bottomMargin = Integer.parseInt(st.nextToken());

            for (int j = 0; j < 10; j++)
                for (int k = 0; k < 10; k++)
                    map[j+bottomMargin][k+leftMargin] = true;

        }

        int cnt = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j])
                    cnt++;
            }
        }

        System.out.println(cnt);
    }
}