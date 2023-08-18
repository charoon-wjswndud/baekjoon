import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        boolean[] arr = new boolean[N+1];
        arr[0] = true;
        arr[1] = true;
        for (int i = 2; i < arr.length; i++)
            if (!arr[i])
                for (int j = 2; i * j < arr.length ; j++)
                    arr[i * j] = true;

        StringBuilder sb = new StringBuilder();
        for (int i = M; i < N+1; i++)
            if (!arr[i])
                sb.append(i).append("\n");

        System.out.print(sb);
    }
}
