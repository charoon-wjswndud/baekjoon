import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] memoryArr = new int[(int)Math.pow(10, 6) + 1];

        int N = Integer.parseInt(br.readLine());

        for(int n = 2; n < N+1; n++){
            if(n%3 == 0 && n%2 == 0) memoryArr[n] = Math.min(memoryArr[n/3] + 1, memoryArr[n/2]+1);
            else if (n%3 == 0) memoryArr[n] = Math.min(memoryArr[n-1]+1,  memoryArr[n/3]+1);
            else if (n%2 == 0) memoryArr[n] = Math.min(memoryArr[n-1]+1,  memoryArr[n/2]+1);
            else memoryArr[n] = memoryArr[n-1] + 1;
        }

        System.out.println(memoryArr[N]);
    }
}
