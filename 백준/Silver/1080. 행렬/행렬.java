import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static int N, M;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        boolean[][] A = new boolean[N][M];
        boolean[][] B = new boolean[N][M];


        setMatrix(A);
        setMatrix(B);

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (A[i][j] != B[i][j] &&
                        i + 2 < N &&
                        j + 2 < M) {
                    for (int r = i; r < i + 3; r++) {
                        for (int c = j; c < j + 3; c++) {
                            A[r][c] = !A[r][c];
                        }
                    }
                    cnt++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (A[i][j] != B[i][j]) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(cnt);
    }

    public static void setMatrix(boolean[][] matrix) throws IOException {
        for (int i = 0; i < N; i++) {
            char[] str = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                matrix[i][j] = str[j] == '1';
            }
        }
    }
}