import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] students = new int[N];
        for (int i = 0; i < N; i++) {
            students[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(students);

        System.out.println(students[N-k]);
    }
}

