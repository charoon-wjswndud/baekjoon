import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] table = new int[N+1][N+1];
        for (int x = 1; x < N+1; x++) {
            st = new StringTokenizer(br.readLine());
            for (int y = 1; y < N+1; y++) {
                table[x][y] = table[x][y-1] + table[x-1][y] - table[x-1][y-1] + Integer.parseInt(st.nextToken());
            }
        }

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int sum = table[x2][y2] - table[x2][y1-1] - table[x1-1][y2] + table[x1-1][y1-1];

            sb.append(sum).append("\n");
        }
        System.out.print(sb);
    }
}
