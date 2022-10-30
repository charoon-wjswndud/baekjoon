import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[][] statsArr;
    static boolean[] team;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        init();
        for (int comb = 0; comb < (1<<N); comb++) {
            int count = 0;
            team = new boolean[N];
            for (int bit = 0; bit < N; bit++) {
                if((comb & (1 << bit)) != 0) {
                    team[bit] = true;
                    count++;
                }
            }
            if(count == N/2) solution(comb);
        }
        System.out.println(min);
    }

    private static void solution(int comb) {
        int startScore = 0, linkScore = 0;
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                if(row == col || team[row] != team[col]) continue;
                if(team[row]) {
                    startScore += statsArr[row][col];
                }
                else {
                    linkScore += statsArr[row][col];
                }
            }
        }
        min = Math.min(min, Math.abs(linkScore - startScore));
    }
    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        statsArr = new int[N][N];

        for (int row = 0; row < N; row++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int col = 0; col < N; col++) {
                statsArr[row][col] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
