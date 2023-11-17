import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int P = Integer.parseInt(br.readLine());
        for (int p = 1; p <= P; p++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            st.nextToken();

            int count = 0;
            int[] arr= new int[20];

            for (int i = 0; i < 20; i++)
                arr[i] = Integer.parseInt(st.nextToken());

            for (int i = 0; i < 20; i++)
                for (int j = 0; j < i; j++)
                    if (arr[j] > arr[i])
                        count++;

            sb.append(p).append(" ").append(count).append("\n");
        }

        System.out.print(sb);
    }
}