import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] prime = new boolean[123456*2+1];
        int[] count_arr = new int[123456*2+1];

        prime[0] = prime[1] = true;
        for(int i = 2; i <= Math.sqrt(prime.length); i++) {
            if(prime[i])
                continue;
            for(int j = i * i; j < prime.length; j += i)
                prime[j] = true;
        }

        int count = 0;
        for(int i = 2; i < prime.length; i++) {
            if(!prime[i])
                count++;
            count_arr[i] = count;
        }

        StringBuilder sb = new StringBuilder();
        while(true) {
            int n = Integer.parseInt(br.readLine());
            if(n == 0)
                break;
            sb.append(count_arr[2 * n] - count_arr[n]).append('\n');
        }

        System.out.print(sb);
    }
}