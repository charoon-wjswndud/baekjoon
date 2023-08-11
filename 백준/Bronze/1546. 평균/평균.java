//java8
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int highScore = Integer.MIN_VALUE;
        for (int n = 0; n < N; n++){
            arr[n] = Integer.parseInt(st.nextToken());
            highScore = Math.max(arr[n], highScore);
        }

        double totalScore = 0;
        for (int score:arr)
            totalScore += forgery(score, highScore);

        System.out.print(totalScore/arr.length);
    }

    private static double forgery(double score, double highScore) {
        return score/highScore*100;
    }
}