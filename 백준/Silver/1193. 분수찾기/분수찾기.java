import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());
        int crossCnt = 1;
        int prevCntSum = 0;

        while (true) {
            if (X <= prevCntSum + crossCnt) {
                if (crossCnt % 2 == 1) {
                    System.out.print((crossCnt - (X - prevCntSum - 1)) + "/" + (X - prevCntSum));
                } else {
                    System.out.print((X - prevCntSum) + "/" + (crossCnt - (X - prevCntSum - 1)));
                }
                break;
            } else {
                prevCntSum += crossCnt;
                crossCnt++;
            }
        }
    }
}