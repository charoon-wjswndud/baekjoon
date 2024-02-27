import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        
        int sum = 0;
        for (int i = 1; i <= N; i++) 
            sum += getCnt(i, D);
        System.out.println(sum);
    }
    public static int getCnt(int num, int d) {
        int cnt = 0;
        while (num != 0) {
            if (num%10 == d)
                cnt++;
            num/=10;
        }
        return cnt;
    }
}