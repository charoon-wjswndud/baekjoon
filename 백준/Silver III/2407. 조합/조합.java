import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        BigInteger[][] bi = new BigInteger[101][101];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                if ( j == 0 || i == j)
                    bi[i][j] = BigInteger.ONE;
                else
                    bi[i][j] = bi[i-1][j].add(bi[i-1][j-1]);
            }
        }

        System.out.println(bi[n][m]);
    }
}