import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        boolean[] switches = new boolean[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            switches[i] = st.nextToken().equals("1");

        int students = Integer.parseInt(br.readLine());
        for (int i = 0; i < students; i++) {
            st = new StringTokenizer(br.readLine());
            boolean male = st.nextToken().equals("1");
            int num = Integer.parseInt(st.nextToken());
            if (male)
                switchMale(switches, num);
            else
                switchFemale(switches, num);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(switches[i] ? 1 : 0).append(" ");
            if (i % 20 == 0)
                sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void switchFemale(boolean[] switches, int num) {
        switches[num] = !switches[num];
        int pair = 1;
        while (true) {
            if (num-pair < 1 || switches.length <= num+pair)
                return;
            if (switches[num-pair] != switches[num+pair])
                return;
            switches[num-pair] = switches[num+pair] = !switches[num+pair];
            pair++;
        }
    }

    private static void switchMale(boolean[] switches, int num) {
        for (int i = num; i < switches.length; i+=num)
            switches[i] = !switches[i];
    }
}