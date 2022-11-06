import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {
        int t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            int num = Integer.parseInt(br.readLine());
            StringBuilder line = new StringBuilder("1");
            dfs(num, 1, 1, 1, 0, line);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    static void dfs(int maxN, int nowN, int num, int sign, int sum, StringBuilder line) {
        if(maxN == nowN) {
            sum = sum + (num * sign);
            if (sum == 0) {
                sb.append(line.toString() +"\n");
            }
            return;
        }
        //아스키 순서 " " -> + -> -
        //" "
        dfs(maxN, nowN +1, num*10+(nowN +1), sign, sum, new StringBuilder(line + " " + String.valueOf(nowN +1)));

        //+
        dfs(maxN, nowN +1, nowN +1, 1, sum + (num*sign), new StringBuilder(line + "+" + String.valueOf(nowN +1)));

        //-
        dfs(maxN, nowN +1, nowN +1, -1, sum + (num*sign), new StringBuilder(line + "-" + String.valueOf(nowN +1)));


    }
}
