import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        long left = 0;
        long right = (long)Math.ceil(Math.sqrt(Math.pow(2, 63)));

        while (left < right) {
            long mid = left + (right - left) / 2;
            if (mid * mid >= n) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(left);
    }
}