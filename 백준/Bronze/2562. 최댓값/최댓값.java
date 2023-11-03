import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int maxNum = Integer.parseInt(br.readLine());
        int maxCnt = 1;
        for (int i = 2; i <= 9; i++) {
            int num  = Integer.parseInt(br.readLine());
            if (num > maxNum) {
                maxNum = num;
                maxCnt = i;
            }
        }

        System.out.println(maxNum);
        System.out.println(maxCnt);
    }
}