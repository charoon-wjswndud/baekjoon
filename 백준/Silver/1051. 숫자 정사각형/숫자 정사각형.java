import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] rectangle = new int[N][M];

        for(int i=0; i<N; i++) {
            String row = br.readLine();
            for(int j=0; j<M; j++) {
                rectangle[i][j] = row.charAt(j) - '0';
            }
        }

        int length = Math.min(N, M);

        while(true) {
            for(int i = 0; i<= N- length; i++) {
                for(int j = 0; j<= M- length; j++) {
                    int n = rectangle[i][j];
                    if(n == rectangle[i][j+ length -1]
                            && n == rectangle[i+ length -1][j]
                            && n == rectangle[i+ length -1][j+ length -1]) {
                        System.out.println(length * length);
                        return;
                    }
                }

            }
            length--;
        }
    }

}