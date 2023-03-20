import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(br.readLine());

        int answer = 0;

        for(int i = 0; i < n; i++) {

            num[i] = Integer.parseInt(st.nextToken());

            if(num[i] == v) {

                answer++;

            }

        }

        System.out.println(answer);

    }

}