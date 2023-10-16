import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken()); //sum
        int L = Integer.parseInt(st.nextToken()); //min length
        boolean flag = true;
        while (L < 101) {
            long start = N / L - (L - 1) / 2;
            if(start < 0)
                break;

            if(N == (start * 2 + L - 1) * L / 2){
                for(long i = 0; i < L; i++)
                    sb.append(start + i + " ");
                flag = false;
                break;
            }
            L += 1;
        }
        
        if(flag)
            sb.append("-1");

        System.out.println(sb);
    }
}