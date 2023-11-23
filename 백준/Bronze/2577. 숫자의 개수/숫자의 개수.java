import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[10];
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        String total = String.valueOf(A * B * C);

        for (int i = 0; i < total.length(); i++)
            arr[(total.charAt(i) - 48)]++;


        for (int cnt : arr)
            System.out.println(cnt);
    }
}