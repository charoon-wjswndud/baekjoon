import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int num = -1; //M에 가까운 수
    static int calcNum = 0; //계산을 위한 수
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[] cards = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++)
            cards[n] = Integer.parseInt(st.nextToken());

        //NC3
        combination(cards, 0, 3);
        System.out.print(num);
    }

    private static void combination(int[] cards, int index, int r) {
        if (r == 0) {
            if (calcNum > M)
                return;
            num = Math.max(calcNum, num);
            return;
        }
        for (int i = index; i < N; i++) {
            calcNum += cards[i];
            combination(cards, i+1, r-1);;
            calcNum -= cards[i];
        }
    }
}